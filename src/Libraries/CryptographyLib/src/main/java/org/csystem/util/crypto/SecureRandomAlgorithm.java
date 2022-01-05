package org.csystem.util.crypto;

public enum SecureRandomAlgorithm {
    NativePRNG("NativePRNG"),
    NativePRNGBlocking("NativePRNGBlocking"),
    NativePRNGNonBlocking("NativePRNGNonBlocking"),
    PKCS11("PKCS11"),
    SHA1PRNG("SHA1PRNG"),
    Windows_PRNG("Windows-PRNG"),;

    SecureRandomAlgorithm(String algorithm)
    {
        ALGORITHM = algorithm;
    }

    public final String ALGORITHM;
}
