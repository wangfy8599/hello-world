class CharArray {
    private native byte[] transformBytes(byte[] array);
    public static void main(String[] args) {
        byte[] inArray = "12345678".getBytes();
        byte[] outArray = new CharArray().transformBytes(inArray);
        System.out.println(new String(outArray));
    }
    static {
        System.loadLibrary("CharArray");
    }
}

javac CharArray

javah -jni CharArray

#include <jni.h>
#include <stdio.h>
#include "CharArray.h"

JNIEXPORT jbyteArray JNICALL Java_CharArray_transformBytes(JNIEnv *env, jobject obj, jbyteArray inputArray)
{
    jbyte* bufferPtr = env->GetByteArrayElements(inputArray, NULL);
    jsize size = env->GetArrayLength(inputArray);
    char* bufferV = reinterpret_cast<char*> (bufferPtr);
    char* pOutBuffer = new char[size];
    jbyteArray outBuffer = env->NewByteArray(size);
    for(jsize i=0; i<size; ++i)
    {
        pOutBuffer[i] =  *(bufferV + i) + 1;
    }

    const jbyte* jBuffer = reinterpret_cast<const jbyte*> (pOutBuffer);
    env->SetByteArrayRegion(outBuffer, 0, size, jBuffer);
    printf("Char Array Done!\n");
    return outBuffer;
}

g++ -std=c++11 -shared -I/${java_home}/jni/linux/include -o libCharArray.so -fPIC CharArray.c

java -Djava.library.path=. CharArray

