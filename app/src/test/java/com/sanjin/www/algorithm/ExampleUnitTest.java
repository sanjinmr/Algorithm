package com.sanjin.www.algorithm;

import com.sanjin.www.algorithm.selectsort.heapsort.MaxHeapSort;
import com.sanjin.www.algorithm.swapsort.bubblesort.BubblingSort;
import com.sanjin.www.algorithm.swapsort.quicksort.QuickSort;
import com.sanjin.www.algorithm.insertsort.shellsort.AlgorithmShell1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void shellAlgorithmTest() {
        int[] a = {80, 30, 60, 40, 20, 10, 50, 70};

        //AlgorithmShell.shellSort2(a, a.length);
        AlgorithmShell1.shellSort(a, a.length);

        System.out.println("");
        System.out.println("排序后：");
        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + "; ");
        }
        System.out.println("");
    }

    @Test
    public void quickSort() {
        new QuickSort().test();
    }

    @Test
    public void sortTest() {
        int[] a = {9, 8, 7, 80, 30, 60, 11, 2, 40, 20, 11, 11, 6, 10, 50, 70, 3, 1, 0, 4, 5, 11};

        //AlgorithmShell.shellSort2(a, a.length);
        //InsertDirectSort.insertSort2(a, a.length);

        //new SimpleSelectSort().selectSort0(a, a.length);

        //new MaxHeapSort1().heapSort(a);

        //BubblingSort.bubbleSort3(a, a.length);

        new MaxHeapSort().heapSort(a, a.length);

        System.out.println("");
        System.out.println("排序后：");
        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + "; ");
        }
        System.out.println("");
    }
}