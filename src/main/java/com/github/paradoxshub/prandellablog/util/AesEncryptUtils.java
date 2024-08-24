package com.github.paradoxshub.prandellablog.util;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

public class AesEncryptUtils {
    // AES对称加密/解密工具类
    // 主要两部分构成，一个加密，一个解密

    static String AlgorithmStr = "AES/ECB/PKCS5Padding"; //算法/数据分组模式/补齐规则

    byte[] key = "1234567890abcdef".getBytes(StandardCharsets.UTF_8); //密钥

    public static byte[] encrypt(byte[] key, String input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(AlgorithmStr); //创建密码器实例，指定算法
        SecretKey keySpec = new SecretKeySpec(key, "AES"); //SecretKeySpec类是KeySpec接口的实现类,用于构建秘密密钥规范
        cipher.init(Cipher.ENCRYPT_MODE, keySpec); //将密码器设置为加密模式，并给上密钥
        return cipher.doFinal(input.getBytes()); //对输入数据进行加密操作，并将结果返回
    }

    public static byte[] decrypt(byte[] key, String input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(AlgorithmStr);
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec); //将密码器设置为解密模式，并给上密钥
        return cipher.doFinal(input.getBytes());//对输入数据进行解密操作，并将结果返回
    }

    public AesEncryptUtils() throws UnsupportedEncodingException {
    }
}

