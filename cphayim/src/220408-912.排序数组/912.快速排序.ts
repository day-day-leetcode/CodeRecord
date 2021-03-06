/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 快速排序
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(logn)
 */

function sortArray(nums: number[]): number[] {
  if (!nums || nums.length <= 1) return nums
  quickSort(nums)
  return nums
}

function quickSort(arr: number[], l = 0, r = arr.length - 1): void {
  if (l >= r) return

  const p = partition(arr, l, r)
  quickSort(arr, l, p - 1)
  quickSort(arr, p + 1, r)
}

/**
 * 对 arr[l...r] 部分进行 partition
 * 返回 p，使得 arr[l...p-1] < arr[p] < arr[p+1...r]
 */
function partition(arr: number[], l: number, r: number): number {
  // 取最左侧的数作为基准值
  const pivot = arr[l]

  // 在循环中始终保持
  // arr[l+1,...j] < pivot; arr[j+1...i) > pivot
  let j = l
  for (let i = l + 1; i <= r; i++) {
    // 当 i 遇到小于 pivot 的数时，将该数与 j 前面的数字交换，之后 j 前移
    if (arr[i] < pivot) {
      swap(arr, i, j + 1)
      j++ // 现在 arr[l+1...j] 包含了刚才交换过来的数
      // 可以写成 swap(arr, i, ++j)
    }
  }

  // 将 pivot 和 j 位置的数（arr[j] < pivot）交换位置
  // 来满足 arr[l...p-1] < arr[p] < arr[p+1...r]
  swap(arr, l, j)
  return j
}

function swap(arr: number[], l: number, r: number): void {
  ;[arr[l], arr[r]] = [arr[r], arr[l]]
}
