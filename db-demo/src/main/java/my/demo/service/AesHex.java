package my.demo.service;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AesHex {
    private static final String AESTYPE ="AES/ECB/PKCS5Padding";

    public static String encrypt(String keyStr, String plainText) {
        byte[] encrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
        return toHex(encrypt);
    }

    public static String decrypt(String keyStr, String encryptData) {
        byte[] decrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(toByte(encryptData));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(
                    hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }
    public static String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private final static String HEX = "0123456789abcdef";

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }


    private static Key generateKey(String key)throws Exception{
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        String keyStr = "asdewDSQkisoe436";
        String plainText = "root";
        String encText = encrypt(keyStr, plainText);
        String decString = decrypt(keyStr, "27a2251a15c98aeeb6518edb7edae61a");
        System.out.println(encText);
        System.out.println(decString);
    }
}
