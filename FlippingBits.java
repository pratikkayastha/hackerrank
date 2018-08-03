package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by Pratik Kayastha on 3/08/2018.
 * https://www.hackerrank.com/challenges/flipping-bits/problem
 */
public class FlippingBits {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        byte[] binary = new byte[32];

        // Convert decimal to binary and store it in byte array
        int idx = 31;
        while(n>0) {
            binary[idx] = ((byte) (n%2));
            n = n /2;
            idx--;
        }

        // Convert binary back to decimal but flip each byte by doing binary[i]^1
        long decimal = 0;
        for (int i=0; i<binary.length; i++) {
            decimal = decimal + ((long) Math.pow(2, (binary.length-1-i))) * (binary[i]^1);
        }

        return decimal;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}