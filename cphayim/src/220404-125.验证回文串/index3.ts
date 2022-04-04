/*
 * @Author: Cphayim
 * @Date: 2022-04-05 03:58:20
 * @Description: 125.验证回文串 栈解法 O(n)
 */

function isPalindrome(s: string): boolean {
  const matched = s.toLowerCase().match(/[a-z0-9]+/g)
  // 没有匹配到意味着去掉特殊字符后是空串
  if (!matched) return true

  const str = matched.join('')
  const stack: string[] = []

  // 中间点，str.length 左移 1 位，相当于整除 2
  let middle = str.length >> 1
  // 将前半部分入栈
  for (let i = 0; i < middle; i++) {
    stack.push(str[i])
  }

  // 如果 str 长度是奇数，应跳过中间字符 ab c ba
  if (str.length % 2) {
    middle++
  }

  // 将后半部分依次和出栈字符对比
  for (let i = middle; i < str.length; i++) {
    if (str[i] !== stack.pop()) return false
  }

  return true
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test('can verify palindrome', () => {
    expect(isPalindrome('A man, a plan, a canal: Panama')).toBe(true)
    expect(isPalindrome('race a car')).toBe(false)
  })
}
