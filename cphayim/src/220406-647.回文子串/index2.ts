/*
 * @Author: Cphayim
 * @Date: 2022-04-06 02:45:36
 * @Description: 647.回文子串 https://leetcode-cn.com/problems/palindromic-substrings/submissions/
 * 动态规划
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(n^2)
 */

function countSubstrings(s: string): number {
  if (!s) return 0

  const n = s.length
  // 保存 [i,j] 这个范围的子串是否是回文串的状态数组
  // 状态转移方程：dp[i][j] = dp[i+1][j-1] && s[i] === s[j]
  const dp: boolean[][] = Array.from({ length: n }, () => [])

  let count = 0
  // 首先判断长度为 1 和 2 的子串的状态
  for (let i = 0; i < n; i++) {
    // 所有长度为 1 的子串都是回文串
    dp[i][i] = true
    count++
  }
  for (let i = 0; i < n - 1; i++) {
    dp[i][i + 1] = s[i] === s[i + 1]
    if (dp[i][i + 1]) {
      count++
    }
  }

  // 利用状态转移方程计算剩下的状态
  for (let i = n - 1; i >= 0; i--) {
    // 因为长度为 1 和 2 的子串的状态都是已知的了，从长度为 3 即 j=i+2 的位置开始判断
    for (let j = i + 2; j < n; j++) {
      dp[i][j] = dp[i + 1][j - 1] && s[i] === s[j]
      if (dp[i][j]) {
        count++
      }
    }
  }

  return count
}
