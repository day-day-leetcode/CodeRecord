/*
 * @Author: Cphayim
 * @Date: 2022-04-05 03:15:18
 * @Description: 125.验证回文串 双指针解法 O(n)
 */

function isPalindrome(s: string): boolean {
  const str = s.toLowerCase()
  // 头尾相向双指针
  let [left, right] = [0, str.length - 1]
  while (left < right) {
    // 特殊字符跳过
    if (!isValid(str[left])) {
      left++
      continue
    }
    if (!isValid(str[right])) {
      right--
      continue
    }

    if (str[left] !== str[right]) return false

    left++
    right--
  }
  return true
}

function isValid(c: string): boolean {
  return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test('can verify palindrome', () => {
    expect(isPalindrome('A man, a plan, a canal: Panama')).toBe(true)
    expect(isPalindrome('race a car')).toBe(false)
  })
}
