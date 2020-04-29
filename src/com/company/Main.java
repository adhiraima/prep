package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    private static final int URL_SIZE = 6;
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String key="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        char[] charMap = key.toCharArray();

        String input = "";
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a url to shorten: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q"))
                break;

            MessageDigest md5 = MessageDigest.getInstance("SHA");

            byte[] inputBytes = input.getBytes();

            byte[] op = md5.digest(inputBytes);
            System.out.println(op.length);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < op.length; i++) {
                if (i < URL_SIZE) {
                    int nav = (Byte.toUnsignedInt(op[i]) + Byte.toUnsignedInt(op[URL_SIZE - 1])) / 2;
                    while (nav > charMap.length)
                        nav %= charMap.length;
                    sb.append(charMap[nav]);
                }
            }
//            for (byte byt : op) {
//                System.out.println(Byte.toUnsignedInt(byt));
//            }

            System.out.println("The shortened URL " + sb.toString());
        }
	// write your code here
        int[] test = {16, 17, 4, 3, 5, 2};

        for (int i = 0; i < test.length;){
            if (i == test.length - 1) {
                test[i] = -1;
                break;
            }
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < test.length; j++) {
                if (test[j] > max)
                    max = test[j];
            }
            if (test[i] < max)
                test[i++] = max;
            else
                test[i] = -1;
        }
        for (int i = 0 ; i < test.length; i++)
            System.out.println(test[i]);
    }
}
