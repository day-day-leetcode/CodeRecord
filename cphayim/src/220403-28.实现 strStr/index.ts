/*
 * @Author: Cphayim
 * @Date: 2022-04-03 11:52:14
 * @Description: 28.实现 strStr 暴力解法 O(n^2)
 * https://leetcode-cn.com/problems/implement-strstr/
 */
function strStr(haystack: string, needle: string): number {
  if (!needle) return 0
  if (!haystack || haystack.length < needle.length) return -1

  for (let i = 0; i < haystack.length; i++) {
    for (let j = 0; j + i < haystack.length; j++) {
      if (needle[j] !== haystack[j + i]) break
      if (j === needle.length - 1) return i
    }
  }

  return -1
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test('can get correct index', () => {
    expect(strStr('hello', 'll')).toBe(2)
    expect(strStr('aaaaa', 'ab')).toBe(-1)
    expect(strStr('mississippi', 'issip')).toBe(4)
    expect(strStr('', '')).toBe(0)
    expect(strStr('abc', 'abcd')).toBe(-1)
  })
}
