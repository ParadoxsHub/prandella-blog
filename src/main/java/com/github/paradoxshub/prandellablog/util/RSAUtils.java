package com.github.paradoxshub.prandellablog.util;

import javax.crypto.Cipher;
import java.security.*;

public class RSAUtils {
    public static class Key {
        String name;
        static PrivateKey sk; //私钥:
        static PublicKey pk;  //公钥:

        // 密钥的生成:
        public Key(String name) throws GeneralSecurityException {
            this.name = name;
            // 生成公钥／私钥对:
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA"); //生成公私钥对，非对称加密所用的类，指定算法，生成RSA非对称加密的公私钥对
            kpGen.initialize(1024); //1024 位是 RSA 密钥对的传统大小，曾经被认为是安全的。但是，当前的计算能力已经超过了 1024 位的安全性，因此建议使用更长的密钥长度，例如 2048 位或 4096 位。
            KeyPair kp = kpGen.generateKeyPair();
            sk = kp.getPrivate();
            pk = kp.getPublic();
        }

        // 把私钥导出为字节
        public byte[] getPrivateKey() {
            return sk.getEncoded();
        }

        // 把公钥导出为字节
        public byte[] getPublicKey() {
            return pk.getEncoded();
        }

        // 用公钥加密:
        public static byte[] encrypt(byte[] message) throws GeneralSecurityException {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pk);
            return cipher.doFinal(message);
        }

        // 用私钥解密:
        public byte[] decrypt(byte[] input) throws GeneralSecurityException {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, sk);
            return cipher.doFinal(input);
        }
    }
}
