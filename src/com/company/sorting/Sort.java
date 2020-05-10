package com.company.sorting;

import java.util.Scanner;

public class Sort {

    private int[] arr;

    public Sort() { }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        String[] strip = inp.split(" ");

        Sort sort = new Sort();

        sort.setArray(str2Int(strip));
        sort.bubbleSort();

        sort.setArray(str2Int(strip));
        sort.removeAndShift();

        sort.setArray(str2Int(strip));
        sort.insertionSort();

        sort.setArray(str2Int(strip));
        sort.mergeSortInit();

    }

    private void setArray(int[] arr) {
        this.arr = arr;
    }

    private static int[] str2Int(String[] arr) {
        int[] iinp = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            iinp[i] = Integer.parseInt(arr[i]);
        return iinp;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void bubbleSort() {
        System.out.print("Before Bubble Sort ");
        printArr(this.arr);

        for (int i = 0; i < this.arr.length; i++) {
            for (int j = i + 1; j < this.arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("After ");
        printArr(this.arr);
    }

    private void insertionSort() {
        System.out.print("Before Insertion Sort ");
        printArr(this.arr);

        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > val){
                arr[j + 1] = arr[j];
                if (j == 0) break;
                else j--;
            }
            arr[j] = val;

        }

        System.out.print("After ");
        printArr(this.arr);
    }

    private void removeAndShift() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Before ...");
        printArr(arr);
        //remove the index # 1 and move to the end
        int val = arr[1];
        int index = 1;

        while (index < arr.length - 1) {
            arr[index] = arr[index + 1];
            index++;
        }
        arr[index] = val;
        System.out.print("After ...");
        printArr(arr);
    }

    private void mergeSortInit() {
        System.out.print("Before Merge Sort ");
        printArr(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("After ");
        printArr(arr);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int lenl = mid - left + 1;
        int lenr = right - mid;

        int[] larr = new int[lenl];
        int[] rarr = new int[lenr];

        for (int i = 0; i < lenl; ++i)
            larr[i] = arr[left + i];

        for (int j = 0; j < lenr; ++j)
            rarr[j] = arr[mid + 1 + j];

        int index = left;
        int rindex = 0;
        int lindex = 0;

        while (rindex < rarr.length && lindex < larr.length) {
            if (rarr[rindex] < larr[lindex])
                arr[index++] = rarr[rindex++];
            else
                arr[index++] = larr[lindex++];
        }
        for(;rindex < rarr.length;)
            arr[index++] = rarr[rindex++];
        for(;lindex < larr.length;)
            arr[index++] = larr[lindex++];
    }
}
