/*
 * @Author: Cphayim
 * @Date: 2022-04-05 02:53:34
 * @Description: 125.验证回文串 reverse 解法 O(n)
 */

function isPalindrome(s: string): boolean {
  const matched = s.toLowerCase().match(/[a-z0-9]+/g)
  // 没有匹配到意味着去掉特殊字符后是空串
  if (!matched) return true

  // 去除了特殊字符后的原串
  const str = matched.join('')
  // 对原串取反
  const comp = str.split('').reverse().join('')
  return comp === str
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test('can verify palindrome', () => {
    expect(isPalindrome('A man, a plan, a canal: Panama')).toBe(true)
    expect(isPalindrome('race a car')).toBe(false)
  })
}
