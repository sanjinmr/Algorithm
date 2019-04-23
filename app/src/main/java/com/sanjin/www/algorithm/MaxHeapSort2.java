package com.sanjin.www.algorithm;

import java.util.Arrays;

public class MaxHeapSort2 {

    // 求parent/left child/right child:

    protected int parent(int i) {return (i - 1) / 2;}
    protected int left(int i) {return 2 * i + 1;}
    protected int right(int i) {return 2 * i + 2;}

    // 保持最大堆特性：

    protected void maxHeapify(int[] A, int heapsize, int i){
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left <= heapsize - 1 && A[left] > A[i]) {
            largest = left;
        }
        if (right <= heapsize - 1 && A[right] > A[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = A[i];
            // swap
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, heapsize, largest);
        }
    }

    // 构造一个“最大堆”：

    public void buildMaxHeap(int[] A, int heapsize){
        for (int i = parent(heapsize - 1); i >= 0; i --) {
            maxHeapify(A, heapsize, i);
        }
    }

    // 对一个array使用heapsort:

    public void heapsort(int[] A){
        int heapsize = A.length;

        buildMaxHeap(A, heapsize);

        int step = 1;
        for (int i = A.length - 1; i > 0; i --) {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            heapsize --;
            System.out.println("Step: " + (step++) + Arrays.toString(A));
            maxHeapify(A, heapsize, 0);
        }
    }

    // main函数:

    public void test() {
        //a sample input
        int[] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(A));
        heapsort(A);
        System.out.println("Output: " + Arrays.toString(A));
    }

    /*
    运行结果:

    Input: [3.0, 7.0, 2.0, 11.0, 3.0, 4.0, 9.0, 2.0, 18.0, 0.0]
    Step: 1[0.0, 11.0, 9.0, 7.0, 3.0, 4.0, 2.0, 2.0, 3.0, 18.0]
    Step: 2[0.0, 7.0, 9.0, 3.0, 3.0, 4.0, 2.0, 2.0, 11.0, 18.0]
    Step: 3[2.0, 7.0, 4.0, 3.0, 3.0, 0.0, 2.0, 9.0, 11.0, 18.0]
    Step: 4[2.0, 3.0, 4.0, 2.0, 3.0, 0.0, 7.0, 9.0, 11.0, 18.0]
    Step: 5[0.0, 3.0, 2.0, 2.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    Step: 6[0.0, 3.0, 2.0, 2.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    Step: 7[0.0, 2.0, 2.0, 3.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    Step: 8[2.0, 0.0, 2.0, 3.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    Step: 9[0.0, 2.0, 2.0, 3.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    Step: 10[0.0, 2.0, 2.0, 3.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    Output: [0.0, 2.0, 2.0, 3.0, 3.0, 4.0, 7.0, 9.0, 11.0, 18.0]
    */

}
