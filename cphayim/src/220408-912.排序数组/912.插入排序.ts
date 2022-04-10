/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 插入排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(n)
 */

function sortArray(nums: number[]): number[] {
  insertionSort(nums)
  return nums
}

// 插入排序可以提前终止内层循环
// 因此在对近乎有序的数组进行排序时，时间复杂度接近 O(n)
function insertionSort(arr: number[]): void {
  if (!arr || arr.length <= 1) return

  // 从 1 开始，将每个元素向前插入到合适的位置
  for (let i = 1; i < arr.length; i++) {
    // 寻找元素 arr[i] 合适的插入位置
    let e = arr[i]
    let j // j 保存元素 e 应该插入的位置

    // 当 arr[j-1] > e 说明循环还要继续
    for (j = i; j > 0 && arr[j - 1] > e; j--) {
      arr[j] = arr[j - 1] // 将前面的元素向后移一位
    }
    // 此时 j 的位置就是 e 应该插入的位置
    arr[j] = e
  }
}
