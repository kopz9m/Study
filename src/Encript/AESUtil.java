package Encript;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESUtil {
    /**
     * AES加密算法
     */
    private static final String ENCRY_ALGORITHM = "AES";
    /**
     * 加密算法/加密模式/填充类型
     * <p>
     * 本例采用AES加密，ECB加密模式，PKCS5Padding填充
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";
    /**
     * 设置iv偏移量
     * <p>
     * 本例采用ECB加密模式，不需要设置iv偏移量
     */
    private static final String IV_ = null;
    /**
     * 设置加密字符集
     * <p>
     * 本例采用 UTF-8 字符集
     */
    private static final String CHARACTER = "UTF-8";
    /**
     * 设置加密密码处理长度。
     * <p>
     * 不足此长度补0；
     */
    private static final int PWD_SIZE = 16;

    /**
     * 密码处理方法
     * 如果加解密出问题，
     * 请先查看本方法，排除密码长度不足补"0",导致密码不一致
     *
     * @param password 待处理的密码
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] pwdHandler(String password) throws UnsupportedEncodingException {
        byte[] data = null;
        if (password == null) {
            password = "";
        }
        StringBuffer sb = new StringBuffer(PWD_SIZE);
        sb.append(password);
        while (sb.length() < PWD_SIZE) {
            sb.append("0");
        }
        if (sb.length() > PWD_SIZE) {
            sb.setLength(PWD_SIZE);
        }
        data = sb.toString().getBytes("UTF-8");
        return data;
    }

    /**
     * 加密
     *
     * @param cipherTextBytes
     * @param pwdBytes
     * @return
     */
    private static byte[] encrypt(byte[] cipherTextBytes, byte[] pwdBytes) {
        return crypto(cipherTextBytes, pwdBytes, "encrypt");
    }

    /**
     * 解密
     *
     * @param cipherTextBytes
     * @param pwdBytes
     * @return
     */
    private static byte[] decrypt(byte[] cipherTextBytes, byte[] pwdBytes) {
        return crypto(cipherTextBytes, pwdBytes, "decrypt");
    }

    /**
     * 原始加密解密
     *
     * @param cipherTextBytes 密文字节数组，待解密的字节数组
     * @param pwdBytes        解密密码字节数组
     * @param action          用于判断是加密还是解密的标识
     * @return 返回解密后的明文字节数组，解密错误返回null
     */
    private static byte[] crypto(byte[] cipherTextBytes, byte[] pwdBytes, String action) {
        try {
//	1 获取解密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
// 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
//	查看数据块位数 默认为16（byte） * 8 =128 bit
            System.out.println("数据块位数(byte)：" + cipher.getBlockSize());
//	3 初始化Cipher实例。设置执行模式以及加密密钥
            if ("encrypt".equals(action)) {
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
            }
//	4 执行
            byte[] clearTextBytes = cipher.doFinal(cipherTextBytes);
//	5 返回明文字符集
            return clearTextBytes;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//	解密错误 返回null
        return null;
    }

    /**
     * BASE64加密
     *
     * @param clearText 明文，待加密的内容
     * @param password  密码，加密的密码
     * @return 返回密文，加密后得到的内容。加密错误返回null
     */
    public static String encryptBase64(String clearText, String password) {
        try {
//	1 获取加密密文字节数组
            byte[] cipherTextBytes = encrypt(clearText.getBytes(CHARACTER), pwdHandler(password));
//	2 对密文字节数组进行BASE64 encoder 得到 BASE6输出的密文
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String cipherText = base64Encoder.encode(cipherTextBytes);
//	3 返回BASE64输出的密文
            return cipherText;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//	加密错误 返回null
        return null;
    }

    /**
     * BASE64解密
     *
     * @param cipherText 密文，带解密的内容
     * @param password   密码，解密的密码
     * @return 解密后得到的内容。解密错误返回null
     */
    public static String decryptBase64(String cipherText, String password) {
        try {
//	1 对 BASE64输出的密文进行BASE64 decodebuffer 得到密文字节数组
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] cipherTextBytes = base64Decoder.decodeBuffer(cipherText);
//	2 对密文字节数组进行解密 得到明文字节数组
            byte[] clearTextBytes = decrypt(cipherTextBytes, pwdHandler(password));
//	3 根据 CHARACTER 转码，返回明文字符串
            return new String(clearTextBytes, CHARACTER);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//	解密错误返回null
        return null;
    }

    public static void main(String[] args) {
//注意时间戳一定要用毫秒级（不要用秒级的）的时间戳，对于多对一的对接，注意字符串中的-号
//不要忘记了, 类似于：1625206834965-10192
        String cipher = encryptBase64(System.currentTimeMillis() + "-10192", "XCWYOP00222ke1WK");
//        String cipher = encryptBase64("1581920018924-10192", "XCWYOP00222ke1WK");
        try {
            System.out.println("URLEncoder前：" + cipher);
            cipher = URLEncoder.encode(cipher, "UTF-8");
            System.out.println("URLEncoder后：" + cipher);
            System.out.println("解密后：" + decryptBase64(URLDecoder.decode(cipher, "UTF-8"), "XCWYOP00222ke1WK"));
            System.out.println("解密指定：" + decryptBase64("oGkJ53/E8vcj7jkR2ElcK8kLtpZNGvwTueuDc6nLoiA=", "XCWYOP00222ke1WK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
