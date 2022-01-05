package org.csystem.util.crypto;

public enum CipherAlgorithm {
    AES("AES"), DES("DES"), RSA("RSA"), AESWrap("AESWrap"), DESEDE("DESede"),;

    CipherAlgorithm(String algorithm)
    {
        ALGORITHM = algorithm;
    }

    public final String ALGORITHM;
}
