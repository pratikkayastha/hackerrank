package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by Pratik Kayastha on 23/07/2018.
 */
public class TwoDArrayDs {

    /**
     * 2D Array - DS
     * https://www.hackerrank.com/challenges/2d-array/
     * */

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        // Possible indices of elements of an hourglass
        int[][] hourGlassIdx = {{0,0}, {0,1}, {0,2}, {1,1}, {2,0}, {2,1}, {2,2}};

        for (int i=0; i<=arr.length-3; i++) {
            for (int j=0; j<=arr.length-3; j++) {
                int sum = 0;
                for (int k=0; k<hourGlassIdx.length; k++) {
                    sum = sum + arr[i+hourGlassIdx[k][0]][j+hourGlassIdx[k][1]];
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}