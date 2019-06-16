package com.sanjin.www.algorithm.swapsort.quicksort;

/**
 * 两侧遍历后，再交换 将递归和partition搞一起的
 * 以左侧为枢轴
 */
public class QuickSort2 {

    public void quickSort(int[] array,int low,int high) {

        if(low > high) return;

        int low1, high1, temp, t;

        low1 = low;

        high1 = high;

        //temp就是基准位
        temp = array[low];

        while (low1 < high1) {
            //先看右边，依次往左递减
            while (low1 < high1 && array[high1] >= temp) high1 --;
            //再看左边，依次往右递增
            while (low1 < high1 && array[low1] <= temp) low1 ++;

            //如果满足条件则交换
            if (low1 < high1) {
                t = array[high1];
                array[high1] = array[low1];
                array[low1] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        array[low] = array[low1];
        array[low1] = temp;

        //递归调用左半数组
        quickSort(array, low, high1 - 1);
        //递归调用右半数组
        quickSort(array, high1 + 1, high);
    }

    public void test(){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
