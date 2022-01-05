package org.csystem.app;

import org.csystem.util.crypto.CryptoUtil;

import java.security.SecureRandom;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16]; //{ 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16 };
        byte[] ivec = new byte[16]; //{ 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16 };

        secureRandom.nextBytes(key);
        secureRandom.nextBytes(ivec);

        System.out.print("key :");
        for (byte b : key)
            System.out.printf("%X ", b);

        System.out.println();

        System.out.print("ivec:");

        for (byte b : ivec)
            System.out.printf("%X ", b);

        System.out.println();


        for (;;) {
            try {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();
                String encryptText = CryptoUtil.encryptString(text, key, ivec);

                System.out.printf("Encrypt Text:%s%n", encryptText);
                String decryptText = CryptoUtil.decryptString(encryptText, key, ivec);
                System.out.printf("Text:%s%n", decryptText);
                System.out.printf("Decrypt Text:%s%n", decryptText);
                System.out.printf("Decrypt Text:%s%n", decryptText.length());

                if (text.equals("quit"))
                    break;
            }
            catch (Throwable ex) {
                System.out.printf("Exception Message:%s%n", ex.getMessage());
            }
        }
    }
}


