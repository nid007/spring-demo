package my.demo.service;

public class PasswordUtil {
    static final String keyStr = "asdewDSQkisoe436";
    public static String decode(String str) {
        return  AesHex.decrypt(keyStr,str);

    }

}
