package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by Pratik Kayastha on 31/07/2018.
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        //Rather than tracking all changes in numbers, just track where numbers increased
        long[] array = new long[n];
        for (int i=0; i<queries.length; i++) {
            array[queries[i][0] - 1] += queries[i][2];

            if (queries[i][1]<n) {
                array[queries[i][1]] -= queries[i][2];
            }
        }

        long max = 0;
        long sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
