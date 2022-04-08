/*
 * @Author: Cphayim
 * @Date: 2022-04-08 08:13:37
 * @Description: 122.买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 动态规划
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
function maxProfit(prices: number[]): number {
  // 不存在或长度小于 2 直接返回 0
  if (!prices || prices.length < 2) return 0

  // dp[i][0] 表示第 i+1 天交易后手里没有股票的最大利润
  // dp[i][1] 表示第 i+1 天交易后手里有股票的最大利润
  const dp: number[][] = Array.from({ length: prices.length }, () => [])

  // 当天交易后手里没有股票有两种情况：
  // 1.当天没有进行任何交易，且前一天手里没有股票
  //   此时"当天最大利润"为"前一天手里没有股票的最大利润" dp[i-1][0]
  // 2.当天卖出了手里的股票，既然能卖，说明之前手里是有股票的
  //   此时"当天最大利润"为"前一天手里有股票的最大利润 + 当天的股票价格" dp[i-1][1] + prices[i]
  // 得到状态转移方程:
  // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])

  // 当天交易后手里有股票有两种情况：
  // 1.当天没有进行任何交易，即股票是之前买入在手中的
  //   此时"当天最大利润"为"前一天手中有股票的最大利润" dp[i-1][1]
  // 2.当天买入的股票，当天能买入股票，说明前一天手中是没有股票的
  //   此时"当天最大利润"为"前一天手中没有股票的最大利润 - 当日的股票价格" dp[i-1][0] - prices[i]
  // 得到状态转移方程:
  // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

  // 初始化边界条件
  dp[0][0] = 0 // 第一天没买
  dp[0][1] = -prices[0] // 第一天买了

  for (let i = 1; i < prices.length; i++) {
    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
  }

  // 取最后一天手上没有股票时的最大利润
  return dp[prices.length - 1][0]
}
