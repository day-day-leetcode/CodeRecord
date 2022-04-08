/*
 * @Author: Cphayim
 * @Date: 2022-04-01 19:07:03
 * @Description: 5.最长回文子串 基于动态规划 O(n^2)
 */
function longestPalindrome(str: string): string {
  str = str ?? ''
  if (str.length <= 1) return str

  const n = str.length
  // 将所有子串是否是回文串的结果存储在一个二维数组中
  // [i][j] 表示起始位置和结束位置
  // 例如 'baab' isPalindrome[1][2] 表示 'aa'
  // isPalindrome[i][j] = isPalindrome[i+1][j-1] && str[i] === str[j]
  const isPalindrome: boolean[][] = Array.from({ length: n }, () => [])

  // 起始位和长度
  let start = 0
  let long = 1

  for (let i = 0; i < n; i++) {
    // 单个字符一定是回文串
    isPalindrome[i][i] = true
  }

  for (let i = 0; i < n - 1; i++) {
    // 判断 [i][i+1] 这两个字符是否是回文串
    isPalindrome[i][i + 1] = str[i] === str[i + 1]
    if (isPalindrome[i][i + 1]) {
      start = i
      long = 2
    }
  }

  for (let i = n - 1; i >= 0; i--) {
    // 长度为 1 和 2 的子串均已计算，从长度为 3 的子串开始
    for (let j = i + 2; j < n; j++) {
      // console.log(`isPalindrome[${i + 1}][${j - 1}]=${isPalindrome[i + 1][j - 1]}`)
      isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && str[i] === str[j]
      if (isPalindrome[i][j] && j - i + 1 > long) {
        start = i
        long = j - i + 1
      }
    }
  }
  // console.log(isPalindrome)
  return str.slice(start, start + long)
}

if (require.main === module) {
  console.log(longestPalindrome('babad'))
}
