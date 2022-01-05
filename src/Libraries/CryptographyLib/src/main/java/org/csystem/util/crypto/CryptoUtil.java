/*----------------------------------------------------------------------
	FILE        : CryptoUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 30.10.2020

	CryptoUtil class for cryptography operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public final class CryptoUtil {
    private static final SecureRandom DEFAULT_SECURE_RANDOM = new SecureRandom();

    private static byte [] encryptDecrypt(int opMode, String text, byte [] keyData, byte[] ivData, CipherAlgorithm cipherAlgorithm, CipherTransformation cipherTransformation, Charset charset) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        Key key = new SecretKeySpec(keyData, cipherAlgorithm.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivData);

        Cipher cipher = getCipher(cipherTransformation);

        cipher.init(opMode, key, ivParameterSpec);

        return cipher.doFinal(text.getBytes(charset));
    }

    private CryptoUtil()
    {
    }

    public static Cipher getCipher(CipherTransformation cipherTransformation) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        return Cipher.getInstance(cipherTransformation.TRANSFORMATION);
    }

    public static byte [] getRandomBytes(int size)
    {
        return getRandomBytes(DEFAULT_SECURE_RANDOM, size);
    }

    public static byte [] getRandomBytes(SecureRandomAlgorithm secureRandomAlgorithm, int size) throws NoSuchAlgorithmException
    {
        return getRandomBytes(SecureRandom.getInstance(secureRandomAlgorithm.ALGORITHM), size);
    }

    public static byte [] getRandomBytes(SecureRandom secureRandom, int size)
    {
        byte [] data = new byte[size];

        secureRandom.nextBytes(data);

        return data;
    }

    public static String decryptString(String text, byte [] keyData, byte[] ivData)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        return decryptString(text, keyData, ivData, StandardCharsets.UTF_8);
    }

    public static String decryptString(String text, byte [] keyData, byte[] ivData, Charset charset)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        return decryptString(text, keyData, ivData, CipherAlgorithm.AES, CipherTransformation.AESCBCPKCS5Padding, charset);
    }

    public static String decryptString(String text, byte [] keyData, byte[] ivData, CipherAlgorithm cipherAlgorithm, CipherTransformation cipherTransformation)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        return decryptString(text, keyData, ivData, cipherAlgorithm, cipherTransformation, StandardCharsets.UTF_8);
    }

    public static String decryptString(String text, byte [] keyData, byte[] ivData, CipherAlgorithm cipherAlgorithm, CipherTransformation cipherTransformation, Charset charset)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        Key key = new SecretKeySpec(keyData, cipherAlgorithm.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivData);
        Cipher cipher = getCipher(cipherTransformation);

        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);

        return new String(cipher.doFinal(Base64.getDecoder().decode(text.getBytes(charset))), charset);
    }

    public static String encryptString(String text, byte [] keyData, byte[] ivData)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        return encryptString(text, keyData, ivData, StandardCharsets.UTF_8);
    }

    public static String encryptString(String text, byte [] keyData, byte[] ivData, Charset charset)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        return encryptString(text, keyData, ivData, CipherAlgorithm.AES, CipherTransformation.AESCBCPKCS5Padding, charset);
    }

    public static String encryptString(String text, byte [] keyData, byte[] ivData, CipherAlgorithm cipherAlgorithm, CipherTransformation cipherTransformation)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        return encryptString(text, keyData, ivData, cipherAlgorithm, cipherTransformation, StandardCharsets.UTF_8);
    }

    public static String encryptString(String text, byte [] keyData, byte[] ivData, CipherAlgorithm cipherAlgorithm, CipherTransformation cipherTransformation, Charset charset)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        Key key = new SecretKeySpec(keyData, cipherAlgorithm.ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivData);
        Cipher cipher = getCipher(cipherTransformation);

        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);

        return Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes(charset)));
    }
}
