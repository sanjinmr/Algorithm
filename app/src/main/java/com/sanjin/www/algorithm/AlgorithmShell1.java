package com.sanjin.www.algorithm;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2019/3/14
 * desc:
 * note:
 */
public class AlgorithmShell1 {

    static int sum = 0;

    public static void shellSort(int[] a, int n) {
        System.out.println("开始希尔排序");
        for (int gap = n / 2; gap > 0;  gap = gap / 2) {
            groupInGap(a, n, gap);
        }
    }

    public static void groupInGap(int[] a, int n, int gap) {
        System.out.println("整体根据增量第" + sum++ + "次全局分组，增量为： " + gap);
        for (int i = 0; i < gap; i ++) {
            devideGroup(a, n, i, gap);
        }
    }

    public static void devideGroup(int[] a, int n, int i, int gap) {
        System.out.println("第[" + i + "]组===============");
        System.out.print("[" + a[i]);
        for (int j = i + gap; j < n; j = j + gap) {
            System.out.print(" " + a[j]);
        }
        System.out.println("]");

        for (int j = i + gap; j < n; j = j + gap) {
            insertSort(a, j, gap);
        }
    }

    public static void insertSort(int[] a, int j, int gap) {
        if (a[j] < a[j - gap]) {
            System.out.println("插入排序比较：" + (j - gap) + " > " + j);
            int temp = a[j];
            int k = j - gap;
            while (k >= 0 && compare(a, k, j, temp)) {
                System.out.println("交换" + k + "和" + (k + gap));
                a[k + gap] = a[k];
                k = k - gap;
            }
            a[k + gap] = temp;
        } else {
            System.out.println("插入排序比较：" + (j - gap) + " < " + j);
            System.out.println("不用交换");
        }
    }

    public static boolean compare(int[] a, int k, int j, int temp) {
         if (a[k] > temp) {
             System.out.println("比较" + k + " > " + j);
             return true;
         } else {
             System.out.println("比较" + k + " < " + j);
             System.out.println("交换结束");
             return false;
         }
    }
}
