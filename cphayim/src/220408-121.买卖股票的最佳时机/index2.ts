/*
 * @Author: Cphayim
 * @Date: 2022-04-08 08:13:37
 * @Description: 121. 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 动态规划
 * 时间复杂度 O(n)
 * 空间复杂度 o(n)
 */
function maxProfit(prices: number[]): number {
  // 不存在或长度小于 2 直接返回 0
  if (!prices || prices.length < 2) return 0

  const n = prices.length
  // dp[i] 表示当日卖出的最大利润
  // i < j < n
  // 当日卖出的最大利润 = max( 昨日卖出的最大利润 + 利润差 , 0 )
  // 状态转移方程：dp[i] = max(dp[i-i] + prices[j] - prices[j-1], 0)
  const dp: number[] = []
  dp[0] = 0 // 第一天不存在卖出

  // 最大利润
  let result = 0
  for (let i = 1; i < n; i++) {
    dp[i] = Math.max(dp[i - 1] + prices[i] - prices[i - 1], 0)
    result = Math.max(result, dp[i])
  }
  return result
}
