package com.liyzzz.leetcode;

import java.util.Arrays;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/01 20:11:11
 * @description 5 最长回文子串 动态规划 时间复杂度 o(n^2)
 * 什么是动态规划: 设计合理的遍历路径 让下次的遍历的结果可以依据上次的结果来减少计算
 * 关键步骤：
 * 1.状态容器    用来存储每次遍历计算的结果 让上次结果可以在下次利用
 * 2.初始化状态容器
 * 3.状态转移方程    上次的结果和这次的结果有什么联系
 */
public class Day_220401_5 {
    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        // bp数组 状态容器 初始化都为false   bp[i][j]表达从i到j是否为回文串 两边都包含
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化状态容器  一个字符永远为回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }


        char[] chars = s.toCharArray();
        //这里状态转移方程有两个遍历思路 但是核心思想都是 判断 dp[i][j] 是否是回文串需要知道 dp[i+1][j-1]

        //思路1: 路径从二维状态容器的左斜线开始遍历 这样可以提前获得好dp[i+1][j-1]的计算结果
        // 找子串是长度为1 长度为2 依次找下去判断是否是回文子串 其实这种思路和中心点枚举的思想有点类似
        // 长度为3的子串只是在长度为1的子串判断两边的字符是否相等 长度为4的只是判断长度为2的两边字符是否相等 (1可以派生出任其奇数的子串，2可以派生出任意偶数的子串)
        //最大长度子串 开始位置 包含
//        int maxLengthStart = 0;
        //最大长度子串 结束位置 不包含  初始化时长度至少为1
//        int maxLengthEnd = 1;
//        for (int n = 2; n <= s.length(); n++) {
//            //遍历从第i位字符位置开始长度为n的子串
//            for (int i = 0; i + n <= s.length(); i++) {
//                //长度至少从2开始
//                if (chars[i] == chars[i + n - 1]) {
//                    //两个字符相等
//                    //如果长度是2 就可以直接赋值
//                    //长度大于2 需要判断 dp[i+1][i+n-1-1] 是否为true
//                    if (n == 2 || dp[i + 1][i + n - 2]) {
//                        maxLengthStart = i;
//                        maxLengthEnd = i + n;
//                        dp[i][i+n-1]=true;
//                    }
//                }
//            }
//        }

        //思路2: 路径从二维数组竖着开始遍历 这样可以提前获得好dp[i+1][j-1]的计算结果 （或者横着遍历也行）
        //以 baba 举例 先看 位置1 a 可以组成那些回文串 位置2 b 可以组成那些回文串 位置3 a 可以组成那些回文串
        //最大长度
        int max = 1;
        //最大长度开始位置
        int start = 0;
        //因为 dp[0][0] 已经是true 所以从1开始
        for (int i = 1; i < chars.length; i++) {
            // i 和 j 不能相等 因为相等一定为true i为结束位置 j为开始位置
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i]) {
                    //如果是小于三个字符的子串 这个时候一定是回文串
                    //如果是大于三个字符就需要判断 dp[i-1][j+1] 是否为回文串
                    if (i - j < 3 || dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        if (max > i - j + 1) {
                            continue;
                        }
                        max = i - j + 1;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaa"));
    }
}
