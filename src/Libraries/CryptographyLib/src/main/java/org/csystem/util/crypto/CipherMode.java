package org.csystem.util.crypto;

public enum CipherMode {
    CBC("CBC"), ECB("ECB"), CFB("CFB"), OFB("OFB"), CTR("CTR"),;

    CipherMode(String mode)
    {
        MODE = mode;
    }

    public final String MODE;
}
