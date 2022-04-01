/*
 * @Author: Cphayim
 * @Date: 2022-04-01 14:37:39
 * @Description: 5.最长回文子串 基于中心线枚举 O(n^2)
 */
function longestPalindrome(str: string): string {
  str = str ?? ''
  if (str.length <= 1) return str

  let longest: string = ''
  for (let i = 0; i < str.length; i++) {
    // 分为两种情况:
    // 1.奇数长度的回文串（以 i 为中心向两边找）
    const oddPalindrome = getMaxPalindrome(str, i, i)
    if (oddPalindrome.length > longest.length) {
      longest = oddPalindrome
    }
    // 2.偶数长度的回文串（以 i 和 i+1 为中心向两边找）
    const evenPalindrome = getMaxPalindrome(str, i, i + 1)
    if (evenPalindrome.length > longest.length) {
      longest = evenPalindrome
    }
  }

  return longest
}

/**
 * 从中心向两侧寻找最大的回文串
 */
function getMaxPalindrome(str: string, left: number, right: number): string {
  // 背向双指针
  while (left >= 0 && right < str.length) {
    if (str[left] !== str[right]) break
    left--
    right++
  }
  return str.slice(left + 1, right)
}

if (require.main === module) {
  console.log(longestPalindrome('babad'))
}
