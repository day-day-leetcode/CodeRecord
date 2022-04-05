/*
 * @Author: Cphayim
 * @Date: 2022-04-06 02:45:36
 * @Description: 647.回文子串 https://leetcode-cn.com/problems/palindromic-substrings/submissions/
 * 中心线枚举
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 */

function countSubstrings(s: string): number {
  if (!s) return 0

  let count = 0
  for (let i = 0; i < s.length; i++) {
    // 分为两种情况：
    // 1.奇数长度的回文子串，从 i,i 向两侧遍历查找
    count += getPalindromeNum(s, i, i)
    // 2.偶数长度的回文子串，从 i,i+1 向两侧遍历查找
    count += getPalindromeNum(s, i, i + 1)
  }

  return count
}

/**
 * 背向双指针
 * 从中心 [left, right] 向两侧统计回文子串数量
 */
function getPalindromeNum(str: string, left: number, right: number) {
  let count = 0
  while (left >= 0 && right < str.length && str[left] === str[right]) {
    count++
    left--
    right++
  }

  return count
}
