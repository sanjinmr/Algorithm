package com.sanjin.www.algorithm;

import com.sanjin.www.algorithm.countsort.CountSort;
import com.sanjin.www.algorithm.mergesort.MergeSort;
import com.sanjin.www.algorithm.radixsort.RadixSortLSD;
import com.sanjin.www.algorithm.radixsort.RadixSortMSD;
import com.sanjin.www.algorithm.recall.RecallTest;
import com.sanjin.www.algorithm.swapsort.quicksort.QuickSort;
import com.sanjin.www.algorithm.insertsort.shellsort.AlgorithmShell1;
import com.sanjin.www.algorithm.swapsort.quicksort.QuickSort2;

import org.junit.Test;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "; ");
        }
        System.out.println("");
    }

    @Test
    public void quickSort() {
        new QuickSort2().test();
    }

    @Test
    public void sortTest() {
        int[] a = {9, 8, 7, 80, 30, 60, 11, 2, 40, 20, 11, 11, 6, 10, 50, 70, 3, 1, 0, 4, 5, 11};

        //AlgorithmShell.shellSort2(a, a.length);
        //InsertDirectSort.insertSort2(a, a.length);

        //new SimpleSelectSort().selectSort0(a, a.length);

        //new MaxHeapSort1().heapSort(a);

        //BubblingSort.bubbleSort3(a, a.length);

        //new MaxHeapSort().heapSort(a, a.length);

        //print(CountSort.countSort(a, a.length, 80));
    }

    private void print(int[] A) {
        System.out.println("");
        System.out.println("排序后：");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + "; ");
        }
        System.out.println("");
    }

    @Test
    public void testLsd() {
        //RadixSortLSD.test2();
        RadixSortMSD.test2();
    }

    @Test
    public void testMergeSort() {
        int[] a = {9, 8, 7, 80, 30, 60, 11, 2, 40, 20, 11, 11, 6, 10, 50, 70, 3, 1, 0, 4, 5, 11};
        int[] temp = new int[a.length];

        MergeSort.mergeSort(a, 0, a.length - 1, temp);

        print(a);
    }

    @Test
    public void testRecall() {
        RecallTest.test();
    }

    @Test
    public void testTypes() {

        byte[] bytes = new byte[6];
        bytes[0] = (byte) 0xA0;
        bytes[1] = (byte) 0x03;
        bytes[2] = (byte) 0x00;
        bytes[3] = (byte) 0x01;
        bytes[4] = (byte) 0x01;
        // 省略中间
        //bytes[5] = Byte.parseByte("SSID"); // 数据域

        byte checkNum = (byte) (0x0 - (bytes[0] + bytes[1] + bytes[2] + bytes[3] + bytes[4]));

        System.out.println(intToHex(checkNum));

        bytes[5] = checkNum;

        System.out.println("SSID".getBytes());
    }

    private static String intToHex(int n) {
        StringBuffer s = new StringBuffer();
        String a;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (n != 0) {
            s = s.append(b[n % 16]);
            n = n / 16;
        }
        a = s.reverse().toString();
        return a;
    }

    private static List<List<Integer>> splitListInt(List<Integer> rawList, int targ) {
        List<List<Integer>> mEndList = new ArrayList<>();

        if (rawList.size() % targ != 0) {
            for (int j = 0; j < rawList.size() / targ + 1; j++) {
                if ((j * targ + targ) < rawList.size()) {
                    mEndList.add(rawList.subList(j * targ, j * targ + targ));//0-3,4-7,8-11    j=0,j+3=3   j=j*3+1
                } else if ((j * targ + targ) > rawList.size()) {
                    mEndList.add(rawList.subList(j * targ, rawList.size()));
                } else if (rawList.size() < targ) {
                    mEndList.add(rawList.subList(0, rawList.size()));
                }
            }
        } else if (rawList.size() % targ == 0) {
            for (int j = 0; j < rawList.size() / targ; j++) {
                if ((j * targ + targ) <= rawList.size()) {
                    mEndList.add(rawList.subList(j * targ, j * targ + targ));//0-3,4-7,8-11    j=0,j+3=3   j=j*3+1
                } else if ((j * targ + targ) > rawList.size()) {
                    mEndList.add(rawList.subList(j * targ, rawList.size()));
                } else if (rawList.size() < targ) {
                    mEndList.add(rawList.subList(0, rawList.size()));
                }
            }
        }

        return mEndList;
    }

    private static byte[][] splitArrayByte(byte[] rawArray, int targ) {
        int size = rawArray.length;

        int divide = size / targ;
        int mod = size % targ;
        if (mod > 0) {
            divide += 1;
        }

        byte[][] bytes = new byte[divide][];

        for (int i = 0; i < divide; i ++) {
            if (i * targ + targ < size) {
                bytes[i] = new byte[targ];
            } else {
                bytes[i] = new byte[size - ((i - 1) * targ + targ)];
            }

            for (int j = 0; j < targ; j ++) {
                if (i * targ + j < size) {
                    bytes[i][j] = rawArray[i * targ + j];
                }
            }
        }

        return bytes;
    }

    @Test
    public void splitArrayTest() {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<List<Integer>> mEndList = splitListInt(Arrays.asList(ints), 4);
        for (int i = 0; i < mEndList.size(); i++) {
            System.out.println(mEndList.get(i).toString() + "");
        }

        Integer[][] ints1 = new Integer[mEndList.size()][];
        for (int i = 0; i < mEndList.size(); i++) {
            ints1[i] = mEndList.get(i).toArray(new Integer[0]);
        }

        System.out.println("=============");
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(Arrays.toString(ints1[i]));
        }
    }

    @Test
    public void splitArrayTestByte() {
        byte[] ints = "ssidssidssid".getBytes(Charset.defaultCharset());
        System.out.println("ints: " + Arrays.toString(ints));
        byte[][] bytes = splitArrayByte(ints, 5);

        System.out.println("=============");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(Arrays.toString(bytes[i]) + " length: " + bytes[i].length);
        }

    }
}