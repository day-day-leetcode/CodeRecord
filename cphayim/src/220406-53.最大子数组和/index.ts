/*
 * @Author: Cphayim
 * @Date: 2022-04-06 04:57:17
 * @Description: 53.最大子数组和 https://leetcode-cn.com/problems/maximum-subarray/
 * 动态规划
 */

function maxSubArray(nums: number[]): number {
  if (nums.length < 1) return 0

  // dp[i] 表示以 nums[i] 结尾的连续子数组最大和
  const dp: number[] = []

  // 当 dp[i-1] 大于等于 0 时，dp[i] = dp[i-1] + nums[i]
  // 当 dp[i-1] 小于 0 时，dp[i] = nums[i]
  // 得到状态转移方程：
  // dp[i] = max(dp[i-1] + nums[i], nums[i])

  // 初始化状态
  dp[0] = nums[0]
  let result = dp[0]

  for (let i = 1; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
    result = Math.max(result, dp[i])
  }
  return result
}
