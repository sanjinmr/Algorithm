package com.sanjin.www.algorithm.dynamicprogramming;

import com.sanjin.www.algorithm.common.PrintUtils;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2020/3/11
 * desc: 动态规划
 * note:
 */
public class DynamicProgramming {

    /**
     * 对动态规划代码的测试
     */
    public static void testDynamicProgramming() {
        int[] weights = {2, 2, 4, 6, 3};
        int[] values = {3, 4, 8, 9, 6};
        int n = 5;
        int w = 9;

        int[][] states = new int[n][w + 1];
        // 初始化states
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < w + 1;j++) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        states[0][weights[0]] = values[0];

        PrintUtils.println("初始 ============== 初始");
        PrintUtils.println("i=" + 0 + " weight: " + weights[0] + " price: " + values[0] + ": ==============");

        for (int ii = 0; ii < n; ii ++) {
            PrintUtils.println("states-" + ii + "： " + PrintUtils.array2String(states[ii]));
        }

        for (int i = 1; i < n; i ++) {

            PrintUtils.println("i=" + i + " weight: " + weights[i] + " price: " + values[i] + ": 不选择==============");

            for (int j = 0; j <= w; j ++) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i- 1][j];
                }
            }

            for (int ii = 0; ii < n; ii ++) {
                PrintUtils.println("states-" + ii + "： " + PrintUtils.array2String(states[ii]));
            }

            PrintUtils.println("i=" + i + " weight: " + weights[i] + " price: " + values[i] + ": 选择==============");

            for (int j =0; j < w - weights[i]; j ++) {
                if (states[i - 1][j] >= 0) {
                    PrintUtils.print("### i: " + i);
                    PrintUtils.print(" j: " + j);

                    int v = states[i - 1][j] + values[i];
                    PrintUtils.print(" ### vpre: " + states[i][j + weights[i]]);
                    PrintUtils.print(" value: " + values[i]);
                    PrintUtils.println(" vpost: " + v);
                    if (v > states[i][j + weights[i]]) {
                        states[i][j + weights[i]] = v;
                    }
                }
            }
            for (int ii = 0; ii < n; ii ++) {
                PrintUtils.println("states-" + ii + "： " + PrintUtils.array2String(states[ii]));
            }
        }

        int maxValue = -1;

        for (int j = 0; j <= w; j ++) {
            if (states[n - 1][j] > maxValue) {
                maxValue = states[n - 1][j];
            }
        }

        PrintUtils.println("maxValue: " + maxValue);

        PrintUtils.println("end =================== end");

        for (int ii = 0; ii < n; ii ++) {
            PrintUtils.println("states-" + ii + ": " + PrintUtils.array2String(states[ii]));
        }
    }
}
