package com.sanjin.www.algorithm;

public class MaxHeapSort {

    private int parent(int i) {return (i - 1) / 2;}

    private int left(int i) {return 2 * i + 1;}

    private int right(int i) {return 2 * i + 2;}

    private void maxHeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = left(parent); // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child ++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child]) {
                break;
            }
            // 把孩子结点的值赋给父结点
            array[parent] = array[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = left(child);
        }
        array[parent] = temp;
    }

    public void heapSort(int[] array) {
        // 循环建立初始堆：从下往上排序
        for (int i = parent(array.length - 1); i >= 0; i --) {
			// 从尾部递增向上排序：大的上去，小的下来，尾部边界是数组末尾
            maxHeapAdjust(array, i, array.length);
        }
        // 进行n-1次循环，完成排序：从上往下排序
        for (int i = array.length - 1; i > 0; i --) {
            // 最后一个元素和第一元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆
			// 整理，将剩余的元素整理成堆：每次从最上面开始排序，尾部递减
            maxHeapAdjust(array, 0, i);
        }
    }
}