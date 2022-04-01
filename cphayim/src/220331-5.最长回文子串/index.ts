/*
 * @Author: Cphayim
 * @Date: 2022-04-01 02:43:51
 * @Description: 5.最长回文子串 暴力解法 O(n^3)
 */
function longestPalindrome(str: string): string {
  str = str ?? ''
  if (str.length <= 1) return str

  let longest: string = ''
  for (let i = 0; i < str.length; i++) {
    for (let j = str.length; j > i; j--) {
      if (isPalindrome(str, i, j - 1) && j - i > longest.length) {
        longest = str.slice(i, j)
      }
    }
  }

  return longest
}

function isPalindrome(str: string, left: number, right: number): boolean {
  // 对向双指针
  while (right > left) {
    if (str[left] !== str[right]) return false
    left++
    right--
  }
  return true
}

if (require.main === module) {
  console.log(longestPalindrome('babad'))
}
