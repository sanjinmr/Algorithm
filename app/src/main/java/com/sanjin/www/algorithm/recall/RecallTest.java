package com.sanjin.www.algorithm.recall;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2020/2/28
 * desc: 回溯算法的测试
 * note: 把输入的变量都定义成了成员变量
 */
public class RecallTest {

    public static final String TAG = RecallTest.class.getSimpleName();

    // 结果放到maxW中
    private int maxW = Integer.MIN_VALUE;

    // 物品重量
    private int[] weight = {2, 2, 4, 6, 3};

    // 物品个数
    private int n = 5;

    // 背包承受的最大重量
    private int w = 9;

    public RecallTest() {
        System.out.println(TAG + ": maxW: " + maxW);
    }

    /**
     *
     * @param i
     * @param cw 已装入的物品的重量和
     */
    public void f(int i, int cw, String tag) {

        System.out.println( TAG + ": find i: " + i + " cw: " + cw + " maxW: " + maxW + tag);

        // cw==w表示装满了，i==n表示物品考察完了
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }

        // 选择不装第i个物品
        f(i + 1, cw, " <- 选择不装");

        // 选择装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], " <- 选择装");
        }
    }

    public static void test () {
        new RecallTest().f(0, 0, " <- 初始时");
    }
}
