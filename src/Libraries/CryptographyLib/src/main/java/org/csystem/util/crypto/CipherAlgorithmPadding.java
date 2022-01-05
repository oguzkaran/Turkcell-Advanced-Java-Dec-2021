package org.csystem.util.crypto;

public enum CipherAlgorithmPadding {
    NONE("NoPadding"), PKCS5("PKCS5Padding"), PKCS1("PKCS1Padding"),
    OAEPWithSHA_1AndMGF1("OAEPWithSHA-1AndMGF1Padding"), OAEPWithSHA_256AndMGF1Padding("OAEPWithSHA-256AndMGF1Padding"),;

    CipherAlgorithmPadding(String algorithmPadding)
    {
        this.ALGORITHM_PADDING = algorithmPadding;
    }

    public final String ALGORITHM_PADDING;
}
