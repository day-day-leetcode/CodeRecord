/*
 * @Author: Cphayim
 * @Date: 2022-04-08 08:13:37
 * @Description: 122.买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 贪心算法 优化
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
function maxProfit(prices: number[]): number {
  let total = 0
  for (let i = 0; i < prices.length - 1; i++) {
    // 如果原数组中后一个减去前一个是正数，说明是上涨的
    // 我们就累加，否则不累加
    total += Math.max(prices[i + 1] - prices[i], 0)
  }
  return total
}
