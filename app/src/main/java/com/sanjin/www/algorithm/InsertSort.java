package com.sanjin.www.algorithm;

public class InsertSort {

    public static void insertShort(int [] a,  int n) {
        int i, j, k;

        for (i= 1; i < n; i++) {
            //为a[i]在前面的a[0...i-1]有序区间
            //中找一个合适的位置 ：小于a[i]的位置
            //如果有更小的元素j(索引)，位置就是j后面
            //如果没有，则视更小元素在-1，位置就是最前面
            for (j = i - 1; j >= 0; j --) {
                if (a[j] < a[i]) {
                    break;
                }
            }

            // 如比自己小的元素就在自己前面
            // 说明它已经是有序的，就不用排啦
            if (j != i -1) {
                // 将待排序的元素记录一下
                int temp = a[i];
                // 将比待排序的元素大的数据向后移
                // j到k表示要挪位置的元素们
                // k表示i元素可以选择插入的位置
                for (k = i -1; k > j; k --) {
                    a[k + 1] = a[k];
                }
                // 将待排序的元素放到正确的位置上
                // 挪位置后，k最后还减了1，这里加回来
                a[k + 1]  = temp;
            }
        }
    }

}
