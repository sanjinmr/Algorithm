package com.sanjin.www.algorithm.strings;

/**
 * author: sanji
 * email: sanjinmr@sina.com
 * time: 2021/2/16
 * desc: 字符串的字符的所有排列
 * note:
 */
public class StringPermutation {

    /**
     * 测试方法
     */
    public static void test() {
        String str = "abc";
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.permutation(str.toCharArray(), 0);
    }

    /**
     * 计算字符串的所有排列情况 -- 递归
     * note: 在理解或写这段代码的时候，脑海里呈现那副树图
     * @param chars
     * @param begin
     */
    private void permutation(char[] chars, int begin) {

        if (chars == null || begin > chars.length - 1) {
            return;
        }

        if (begin == chars.length - 1) {
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                builder.append(c);
            }
            String str = builder.toString();
            System.out.println("result: " + str);
            return;
        }

        for (int i = begin; i < chars.length; i ++) {
            swap(chars, i, begin);
            permutation(chars, begin + 1);
            swap(chars, i, begin);
        }
    }

    private void swap(char[] chars, int i, int begin) {
        char temp = chars[i];
        chars[i] = chars[begin];
        chars[begin] = temp;
    }

}
