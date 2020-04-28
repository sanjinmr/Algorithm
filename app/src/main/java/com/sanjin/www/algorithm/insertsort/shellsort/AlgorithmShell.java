package com.sanjin.www.algorithm.insertsort.shellsort;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2019/3/14
 * desc: 无log
 * note: 希尔排序
 */
public class AlgorithmShell {

    /**
     * 插入排序： 普通插入排序的步长改为了gap
     * @param a
     * @param n
     * @param i
     * @param gap
     */
    public static void directInsertSort(int[] a, int n, int i, int gap) {
        for (int j = i + gap; j < n; j += gap) {
            if (a[j - gap] > a[j]) {
                int temp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > temp) {
                    a[k +gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = temp;
            }
        }
    }

    /**
     * 插入排序： 普通插入排序的步长改为了gap
     * 将插入排序部分的while循环改为for循环，本质相同
     * @param a
     * @param n
     * @param i
     * @param gap
     */
    public static void directInsertSort1(int[] a, int n, int i, int gap) {
        int k;
        for (int j = i + gap; j < n; j += gap) {
            if (a[j - gap] > a[j]) {
                int temp = a[j];
                for (k = j - gap; k >=0 && a[k] > temp; k = k - gap) {
                    a[k +gap] = a[k];
                }
                a[k + gap] = temp;
            }
        }
    }

    public static void shellSort(int[] a, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i ++) {
                directInsertSort(a, n, i, gap);
            }
        }
    }
}
