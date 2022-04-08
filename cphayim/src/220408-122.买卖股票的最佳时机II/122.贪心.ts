/*
 * @Author: Cphayim
 * @Date: 2022-04-08 08:13:37
 * @Description: 122.买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 贪心算法
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
function maxProfit(prices: number[]): number {
  // 不存在或长度小于 2 直接返回 0
  if (!prices || prices.length < 2) return 0

  let total = 0
  let index = 0
  // 找到所有上涨波段，记录终点和起点的差值即利润
  while (index < prices.length) {
    // 如果股票一直下跌，直到股票开始上涨为止
    while (index < prices.length - 1 && prices[index] > prices[index + 1]) {
      index++
    }
    // 股票开始上涨了，记录起点（最小值）
    const min = prices[index]
    // 一直找到股票上涨的最大值
    while (index < prices.length - 1 && prices[index] < prices[index + 1]) {
      index++
    }
    total += prices[index] - min
    index++
  }
  return total
}
