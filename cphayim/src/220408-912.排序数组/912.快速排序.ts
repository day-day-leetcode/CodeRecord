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
  quickSort(nums, 0, nums.length - 1)
  return nums
}

function quickSort(arr: number[], left: number, right: number): void {
  if (!arr || arr.length <= 1 || left >= right) return

  const p = partition(arr, left, right)
  quickSort(arr, left, p - 1)
  quickSort(arr, p + 1, right)
}

/**
 * 将数组通过 pivot 分割成两个部分
 * 使得 pivot 左侧的部分的数都小于 pivot，pivot 右侧部分的数都大于 pivot
 * 返回 pivot 的坐标
 */
function partition(arr: number[], left: number, right: number): number {
  // 随机数优化
  const randomIndex = Math.floor(Math.random() * (right - left + 1)) + left
  ;[arr[left], arr[randomIndex]] = [arr[randomIndex], arr[left]]

  // 基准值
  const pivot = arr[left]
  let index = left

  for (let i = index; i <= right; i++) {
    // 当 i 的元素小于 pivot 的数时，将它和 index 的元素交换
    if (arr[i] < pivot) {
      index++
      ;[arr[i], arr[index]] = [arr[index], arr[i]]
    }
  }
  // 将 pivot 和现在 index 的元素交换
  ;[arr[left], arr[index]] = [arr[index], arr[left]]
  return index
}
