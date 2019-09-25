package my.demo.service;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;

public class MyEncryptablePropertyResolver implements EncryptablePropertyResolver {
    //自定义解密方法
    @Override
    public String resolvePropertyValue(String s) {
        if (null != s && s.startsWith(MyEncryptablePropertyDetector.ENCODED_PASSWORD_HINT)) {
            return PasswordUtil.decode(s.substring(MyEncryptablePropertyDetector.ENCODED_PASSWORD_HINT.length()));
        }

        return s;
    }
}