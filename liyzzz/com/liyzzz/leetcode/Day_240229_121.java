package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/02/29 17:11:22
 * @description 买卖股票的最佳时机
 */
public class Day_240229_121 {
//    public int maxProfit(int[] prices) {
//        //在价格最低时买入在价格最多时卖出 解法有问题  万一价格最高的时候是在价格最低时之前呢
//        //该问题其实就是只买入一次 怎么收益最高
//        //爆破 超时
//        //每次的操作只有有三种 买入 卖出 什么都不做 但是该操作要依据上一次的操作(是否持有股票) 例如 上一次是买入的 这次只能是 卖出 和 什么都不做
//        int[] ints = eachOperation(false, prices, 0, 0, new int[prices.length]);
//        int max = 0;
//        for (int anInt : ints) {
//            if (anInt > max) {
//                max = anInt;
//            }
//        }
//        return max;
//    }

    /**
     * 每次操作的收益
     *
     * @param isBuy    是否持有股票
     * @param prices   股票每日价格
     * @param index    当前操作天数
     * @param buyPrice 购买价格
     * @param income   收益
     * @return 每次收益
     */
//    public int[] eachOperation(boolean isBuy, int[] prices, int index, int buyPrice, int[] income) {
//        if (index >= prices.length) {
//            return income;
//        }
//        if (isBuy) {
//            //如果是最后一天 必须卖出
//            if (index == prices.length - 1) {
//                income[index] = Math.max(prices[index] - buyPrice, income[index]);
//                return income;
//            }
//            //什么都不做
//            eachOperation(isBuy, prices, index + 1, buyPrice, income);
//            //卖出
//            income[index] = Math.max(prices[index] - buyPrice,income[index]);
//            return income;
//        } else {
//            //什么都不做
//            eachOperation(isBuy, prices, index + 1, buyPrice, income);
//            //买入
//            eachOperation(true, prices, index + 1, prices[index], income);
//        }
//        return income;
//    }

//    public int maxProfit(int[] prices) {
//        //爆破2  找出数据中最大的差值 此外，第二个数字（卖出价格）必须大于第一个数字（买入价格） 超时
//        int max=0;
//        for (int i = 0; i < prices.length-1 ; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                if(prices[j]-prices[i]>max){
//                    max=prices[j]-prices[i];
//                }
//            }
//        }
//        return max;
//    }
//    public int maxProfit(int[] prices) {
//        //动态规划
//        //dp[i][0/1] 表示第i天持有/不持有股票的最大收益 0表示持有0只股票 1表示持有1只股票
//        int[][] dp = new int[prices.length][2];
//        //初始化值
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        //
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
//        }
//        return dp[prices.length - 1][0];
//    }
    public int maxProfit(int[] prices) {
        //动态规划
        int max = 0;
        //第i天卖出的最大利润只和 prices[0]-prices[i]的最小值有关系
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //计算当天卖出利润
            int dayPrices = prices[i] - minPrice;
            max = Math.max(max, dayPrices);
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Day_240229_121 day_240229_121 = new Day_240229_121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(day_240229_121.maxProfit(prices));
    }
}
