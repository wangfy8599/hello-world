import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public class TestObjects {

    static void print(String args) {
        System.out.println(args);
    }

    static class OA {
        private String a;

        public OA(String a) {
            this.a = a;
        }

        @Nullable
        @CheckReturnValue
        public static String getString() {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(Objects.equal(null, ""));
        OA oa = new OA("oa-attr");
        print(MoreObjects.toStringHelper(oa).addValue(1).add("kye", 2).toString());
        OA.getString();
        Strings.isNullOrEmpty(null);
        String s = "hello world";
        s.toUpperCase();
    }
}
