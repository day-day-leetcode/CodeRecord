package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/02/29 16:26:31
 * @description 买卖股票的最佳时机 2
 */
public class Day_240229_122 {
    public int maxProfit(int[] prices) {
        //上升时买入 下降时卖出
        boolean isBuy = false;
        int sum = 0;
        //买入时价格
        int buyPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1] && isBuy) {
                //卖出
                isBuy = false;
                sum += prices[i - 1] - buyPrice;
            }
            if (prices[i] > prices[i - 1] && !isBuy) {
                isBuy = true;
                buyPrice = prices[i - 1];
            }
        }
        if (isBuy) {
            sum = sum + prices[prices.length - 1] - buyPrice;
        }
        return sum;
    }


    public static void main(String[] args) {
        Day_240229_122 day_240229_122 = new Day_240229_122();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(day_240229_122.maxProfit(prices));
    }
}
