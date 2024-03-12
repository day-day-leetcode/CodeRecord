package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/03/06 15:13:40
 * @description 买卖股票的最佳时机 5
 */
public class Day_240306_188 {
    /**
     * 买卖股票的最佳时机 5
     *
     * @param k      买卖次数
     * @param prices 价格
     * @return 最大收益
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        //如果k大于天数的一半 那么就是可以无限次买卖
        if (k > prices.length / 2) {
            //相当于买卖股票的最佳时机 2
            int[][] dp = new int[prices.length][2];
            dp[0][1] = -prices[0];
            dp[0][0] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }

        //有限此时买入
        int[][][] dp = new int[prices.length][k + 1][2];
        //初始化
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
            dp[0][i][0] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }


    public static void main(String[] args) {
        Day_240306_188 day_240306_188 = new Day_240306_188();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(day_240306_188.maxProfit(2, prices));
    }
}
