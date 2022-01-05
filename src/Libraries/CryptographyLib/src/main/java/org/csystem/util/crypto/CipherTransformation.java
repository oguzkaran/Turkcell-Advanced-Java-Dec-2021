package org.csystem.util.crypto;

public enum CipherTransformation {
    AESCBCNoPadding("AES/CBC/NoPadding"),
    AESCBCPKCS5Padding("AES/CBC/PKCS5Padding"),
    AESECBNoPadding("AES/ECB/NoPadding"),
    AESECBPKCS5Padding("AES/ECB/PKCS5Padding"),
    DESCBCNoPadding("DES/CBC/NoPadding"),
    DESCBCPKCS5Padding("DES/CBC/PKCS5Padding"),
    DESECBNoPadding("DES/ECB/NoPadding"),
    DESECBPKCS5Padding("DES/ECB/PKCS5Padding"),
    DESedeCBCNoPadding("DESede/CBC/NoPadding"),
    DESedeCBCPKCS5Padding("DESede/CBC/PKCS5Padding"),
    DESedeECBNoPadding("DESede/ECB/NoPadding"),
    DESedeECBPKCS5Padding("DESede/ECB/PKCS5Padding"),
    RSAECBPKCS1Padding("RSA/ECB/PKCS1Padding"),
    RSAECBOAEPWithSHA_1AndMGF1Padding("RSA/ECB/OAEPWithSHA-1AndMGF1Padding"),
    RSAECBOAEPWithSHA_256AndMGF1Padding("RSA/ECB/OAEPWithSHA-256AndMGF1Padding"),;

    CipherTransformation(String transformation)
    {
        TRANSFORMATION = transformation;
    }

    public final String TRANSFORMATION;
}
