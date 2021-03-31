package com.sanjin.www.algorithm.dynamicprogramming;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2021/3/31
 * desc: 零钱找零问题：假设我们有几种不同的币值的硬币V1、V2、。。。。Vn（单位是元），每个币值的数量不限。
 * 如果要支付w元，求最少需要多少个硬币？
 * 比如，我们有3中不同的硬币（1元、3元、5元），我们要支付9元，最少需要3个硬币（3个3元的硬币）。
 * note:
 */
public class SmallchangeDP {

    private int[] values = {1, 3, 4, 5, 6, 12};
    private int w = 9;
    private int minCount = Integer.MAX_VALUE;
    private int[][] num = new int[w + 1][w + 1];

    public void test() {
        //algo(0, 0);
        algo1(w, 0);
        System.out.println("count: " + minCount);
    }

    /**
     * 回溯算法的实现
     * 穷举所有
     * @param cw
     * @param curCount
     */
    private void algo(int cw, int curCount) {
        System.out.println("algo cw: " + cw + " curCount: " + curCount);

        if (cw > w) {
            return;
        }

        if (cw == w) {
            if (curCount < minCount) {
                minCount = curCount;
            }
            return;
        }

        if (curCount > w) {
            return;
        }

        if (num[cw][curCount] > 0) {
            return;
        } else {
            num[cw][curCount] = 1;
        }

        for (int i = 0; i < values.length; i ++) {
            // 加入当前的
            algo(cw + values[i], curCount + 1);
            // 不加入当前的
            algo(cw, curCount);
        }
    }

    /**
     * 动态转移方程的解法
     * f(w) = min(f(w-v1), f(w-v2), f(w-v3)....) + 1
     * @param w1
     * @param curCount
     */
    private void algo1(int w1, int curCount) {

        if (w1 > w) {
            return;
        }

        if (w1 < 0) {
            return;
        }

        if (curCount > w) {
            return;
        }

        System.out.println("algo1 w1: " + w1 + " curCount: " + curCount);

        if (w1 == 0) {
            if (curCount < minCount) {
                minCount = curCount;
            }
        }

        if (num[w1][curCount] > 0) {
            return;
        } else {
            num[w1][curCount] = 1;
        }

        for (int i = 0; i < values.length; i ++) {
            // 探索f(w-vi)+1的值
            algo1(w1 - values[i], curCount + 1);
        }
    }
}
