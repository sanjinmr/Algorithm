package com.sanjin.www.algorithm;

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
}