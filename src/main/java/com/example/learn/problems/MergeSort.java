package org.example;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 4};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            System.out.printf("start = %d , middle =%d , end = %d ", start, middle, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        //copy current array elements to merge
        //int[] a1 = new int[middle - start + 1]; //since we are starting from 0 , we need to do +1 for actual length
        //int[] a2 = new int[end - middle]; //while splitting array starts at middle+1,so end-middle is enough size

        int[] a1 = Arrays.copyOfRange(arr, start, middle + 1);
        int[] a2 = Arrays.copyOfRange(arr, middle + 1, end + 1);
        int a1Pos = 0;
        int a2Pos = 0;
        System.out.println("Array 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(a2));
        int i = start;
        while (a1Pos < a1.length && a2Pos < a2.length) {
            if (a1[a1Pos] < a2[a2Pos]) {
                arr[i] = a1[a1Pos];
                a1Pos++;
            } else if (a1[a1Pos] > a2[a2Pos]) {
                arr[i] = a2[a2Pos];
                a2Pos++;
            }
            i++;
        }
        for (int j = a1Pos; j < a1.length; j++) {
            arr[i] = a1[j];
            i++;
        }
        for (int j = a2Pos; j < a2.length; j++) {
            arr[i] = a2[j];
            i++;
        }

    }

}

