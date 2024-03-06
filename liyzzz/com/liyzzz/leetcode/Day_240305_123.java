package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/03/05 17:38:03
 * @description 买卖股票的最佳时机 3
 */
public class Day_240305_123 {
    public int maxProfit(int[] prices) {
        //动态规划
        int[][][] dp = new int[prices.length][3][2];
        //初始化
        dp[0][2][0] = 0;
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][2][0] = dp[i - 1][2][0];
            dp[i][1][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][2][0] - prices[i], dp[i - 1][1][1]);
            dp[i][0][0] = Math.max(dp[i - 1][0][1] + prices[i], dp[i - 1][0][0]);
            dp[i][0][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][0][1]);
        }

        return dp[prices.length - 1][0][0];
    }

    public static void main(String[] args) {
        Day_240305_123 day_240305_123 = new Day_240305_123();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(day_240305_123.maxProfit(prices));
    }
}
