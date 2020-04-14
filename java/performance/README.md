# Print JVM arguments
```
java -XX:+PrintFlagsFinal -version
```

# -XX:+UseNUMA
Add this JVM argument to make use the local memory if NUMA supported

# Use G1GC for the real time application

# -XX:+UseCompressedOops
By default, this is enabled and you can check this by "java -XX:+PrintFlagsFinal -version | grep  UseCompressedOops"
