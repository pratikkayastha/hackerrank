package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by Pratik Kayastha on 24/07/2018.
 * https://www.hackerrank.com/challenges/minimum-swaps-2
 */
public class MinimumSwapsTwo {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i=0; i<arr.length-1; i++) {
            // Checking if the number is not in its position
            // As the numebers are consecutive, arr[i] = i, if its in correct position
            if ((i+1)!=arr[i]) {
                swaps++;
                swapElements(arr, i, arr[i]-1);
                //Going back a step
                i--;
            }
        }

        return swaps;
    }

    private static int[] swapElements(int[] arr, int idxFrom, int idxTo) {
        int temp = arr[idxTo];
        arr[idxTo] = arr[idxFrom];
        arr[idxFrom] = temp;

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
