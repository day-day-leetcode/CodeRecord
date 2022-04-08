/*
 * @Author: Cphayim
 * @Date: 2022-04-08 08:13:37
 * @Description: 121. 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 暴力解法 超时
 * 时间复杂度 O(n^2)
 * 空间复杂度 o(1)
 */
function maxProfit(prices: number[]): number {
  // 不存在或长度小于 2 直接返回 0
  if (!prices || prices.length < 2) return 0

  // 最大利润
  let result = 0
  // i 表示买入日
  for (let i = 0; i < prices.length - 1; i++) {
    // j 表示卖出日
    for (let j = i + 1; j < prices.length; j++) {
      result = Math.max(result, prices[j] - prices[i])
    }
  }
  return result
}
