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
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineFreq = new HashMap<>();
        for (String word : magazine) {
            magazineFreq.put(word, magazineFreq.containsKey(word) ? magazineFreq.get(word)+1 : 1);
        }

        boolean isValid = true;
        for (String word : note) {
            if (magazineFreq.containsKey(word)) {
                magazineFreq.put(word, magazineFreq.get(word)-1);
                if (magazineFreq.get(word)<0) {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
        }

        System.out.println(isValid ? "Yes" : "No");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
