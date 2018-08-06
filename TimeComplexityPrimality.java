package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by Pratik Kayastha on 6/08/2018.
 * https://www.hackerrank.com/challenges/ctci-big-o/
 */
public class TimeComplexityPrimality {

    // Complete the primality function below.
    static String primality(int n) {
        // First checking boundary conditions
        if (n==1) {
            return "Not prime";
        }

        // Even numbers except 2 cannot be prime
        if (n % 2 == 0 && n!=2) {
            return "Not prime";
        }

        // Check for numbers >3 and less than square root of number
        for (int i=3; i<Math.sqrt(n)+1; i+=2) {
            if (n % i == 0) {
                return "Not prime";
            }
        }

        return "Prime";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}