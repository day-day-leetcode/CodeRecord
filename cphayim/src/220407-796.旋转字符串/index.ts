/*
 * @Author: Cphayim
 * @Date: 2022-04-07 21:05:55
 * @Description: 796.旋转字符串 https://leetcode-cn.com/problems/rotate-string/
 * 模拟旋转
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 */

function rotateString(s: string, goal: string): boolean {
  if (!s || !goal || s.length !== goal.length) return false

  // s[(i + j) % length] 模拟 s 旋转 i 次时 j 索引对应的字符

  for (let i = 0; i < goal.length; i++) {
    let flag = true
    for (let j = 0; j < goal.length; j++) {
      // 将 s 旋转后的字符和 goal 的字符进行比较
      if (s[(i + j) % goal.length] !== goal[j]) {
        flag = false
        break
      }
    }
    if (flag) return true
  }

  return false
}
