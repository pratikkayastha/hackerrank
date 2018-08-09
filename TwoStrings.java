package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by Pratik Kayastha on 9/08/2018.
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean isSubstring = false;

        Set<String> chars = new HashSet<String>(Arrays.asList(s1.split("")));
        for (String ch : chars) {
            if (s2.contains(ch)) {
                isSubstring = true;
            }
        }

        return isSubstring ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
