package com.sanjin.www.algorithm;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2019/3/14
 * desc:
 * note:
 */
public class AlgorithmShell {

    public static void groupSort(int[] a, int n, int i, int gap) {
        System.out.println(" ,gap: " + gap);
        for (int j = i + gap; j < n; j += gap) {
            System.out.print(" ,j: " + j);
            if (a[j] < a[j - gap]) {
                int temp = a[j];
                int k = j - gap;
                System.out.print(" ,k: " + k);
                while (k >= 0 && a[k] > temp) {
                    a[k +gap] = a[k];
                    k -= gap;
                    System.out.println(" ,k1: " + k);
                }
                a[k + gap] = temp;
            }
        }
    }

    public static void shellSort(int[] a, int n) {
        int sum = 0;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\n<=========>");
            System.out.println("第" + sum++ + "次增量： " + gap);
            for (int i = 0; i < gap; i ++) {
                System.out.println("第" + i + "次排序，增量： " + gap);
                groupSort(a, n, i, gap);
            }
        }
    }
}
