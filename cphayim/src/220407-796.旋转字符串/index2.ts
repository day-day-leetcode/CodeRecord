/*
 * @Author: Cphayim
 * @Date: 2022-04-07 21:05:55
 * @Description: 796.旋转字符串 https://leetcode-cn.com/problems/rotate-string/
 * 子串
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */

function rotateString(s: string, goal: string): boolean {
  if (!s || !goal || s.length !== goal.length) return false

  // s[(i + j) % length] 模拟 s 旋转 i 次时 j 索引对应的字符
  return (s + s).indexOf(goal) !== -1
}
