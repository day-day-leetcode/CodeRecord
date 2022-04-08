/*
 * @Author: Cphayim
 * @Date: 2022-04-03 11:52:14
 * @Description: 28.实现 strStr Robin karp O(n+m)
 * https://leetcode-cn.com/problems/implement-strstr/
 */
function strStr(haystack: string, needle: string): number {
  if (!needle) return 0
  if (!haystack || haystack.length < needle.length) return -1

  const needleCode = hashCode(needle)

  for (let i = 0; i < haystack.length - needle.length + 1; i++) {
    // 头字符不相等直接跳过
    if (haystack[i] !== needle[0]) continue
    // 计算 hash 是否相等
    const sub = haystack.slice(i, i + needle.length)
    if (hashCode(sub) === needleCode && sub === needle) {
      return i
    }
  }

  return -1
}

function hashCode(s: string): number {
  let h = 0
  for (let i = 0; i < s.length; i++) {
    h = (Math.imul(31, h) + s.charCodeAt(i)) | 0
  }
  return h
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test.each([[1, 2, { name: 'cphayim' }]])('(%i, %i) -> %o', (a, b, c) => {
    expect(strStr('hello', 'll')).toBe(2)
    expect(strStr('aaaaa', 'ab')).toBe(-1)
    expect(strStr('mississippi', 'issip')).toBe(4)
    expect(strStr('', '')).toBe(0)
    expect(strStr('abc', 'abcd')).toBe(-1)
  })
}
