/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 归并排序
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(n)
 */

function sortArray(nums: number[]): number[] {
  mergeSort(nums)
  return nums
}

function mergeSort(arr: number[]): void {
  if (!arr || arr.length <= 1) return
  __mergeSort(arr, 0, arr.length - 1)
}

/**
 * 递归使用归并排序，对 arr[l...r] 的范围进行排序
 */
function __mergeSort(arr: number[], l: number, r: number): void {
  if (l >= r) return

  const mid = (l + r) >> 1
  __mergeSort(arr, l, mid)
  __mergeSort(arr, mid + 1, r)

  //? 优化点
  //? 如果 arr[mid] <= arr[mid+1]，说明整体已经有序了
  if (arr[mid] > arr[mid + 1]) {
    __merge(arr, l, mid, r)
  }
}

/**
 * 将 arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
 */
function __merge(arr: number[], l: number, mid: number, r: number): void {
  // 辅助数组，范围是 arr[l...r]
  const aux: number[] = Array.from({ length: r - l + 1 }, (_, index) => arr[index + l])

  let i = l // [l...mid]
  let j = mid + 1 // [mid+1...r]

  for (let k = l; k <= r; k++) {
    // 首先考虑一侧越界的两种情况
    // 如果 i > mid，说明 剩下的元素都在 arr[mid+1, r] 中，只需要考虑 j
    if (i > mid) {
      arr[k] = aux[j - l]
      j++
    }
    // 如果 j > r，说明 剩下的元素都在 arr[l...mid] 中，只需要考虑 i
    else if (j > r) {
      arr[k] = aux[i - l]
      i++
    }
    // 两侧索引均合法的两种情况
    // 把较小的数放入原数组 k 的位置
    else if (aux[i - l] < aux[j - l]) {
      arr[k] = aux[i - l]
      i++
    } else {
      arr[k] = aux[j - l]
      j++
    }
  }
}
