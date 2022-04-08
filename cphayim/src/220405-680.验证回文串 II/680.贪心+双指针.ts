/*
 * @Author: Cphayim
 * @Date: 2022-04-05 02:53:34
 * @Description: 680.验证回文串 II 贪心+双指针 O(n)
 */

function validPalindrome(s: string): boolean {
  if (typeof s !== 'string') return false
  if (s.length <= 1) return true

  // 贪心，如果已经遍历完成，可以确认是回文串
  const [left, right] = findDefference(s, 0, s.length - 1)
  if (left >= right) return true

  // 在左侧或右侧跳过一个字符，判断中间是否是回文串
  return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)
}

/**
 * 相向双指针，返回发现不同字符时的 left 和 right
 */
function findDefference(s: string, left: number, right: number): [number, number] {
  while (left < right) {
    if (s[left] !== s[right]) break
    left++
    right--
  }
  return [left, right]
}

/**
 * 判断 s[left, right] 范围是不是回文串
 */
function isPalindrome(s: string, left: number, right: number): boolean {
  ;[left, right] = findDefference(s, left, right)
  return left >= right
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test('can verify palindrome', () => {
    expect(validPalindrome('abca')).toBe(true)
    expect(validPalindrome('abc')).toBe(false)
  })
}
