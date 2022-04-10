/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 选择排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(n)
 */

function sortArray(nums: number[]): number[] {
  selectionSort(nums)
  return nums
}

function selectionSort(arr: number[]): void {
  if (!arr || arr.length <= 1) return

  for (let i = 0; i < arr.length; i++) {
    // 每轮找出 [i...length-1] 中最小的那个元素，交换到 i 位置
    let minIndex = i
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j
      }
    }
    swap(arr, i, minIndex)
  }
}

function swap(arr: number[], i: number, j: number) {
  ;[arr[i], arr[j]] = [arr[j], arr[i]]
}
