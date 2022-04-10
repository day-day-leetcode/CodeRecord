/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 双路快速排序
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

  //? 优化点：对小范围使用插入排序优化
  //? 参考 v8 对 Array.prototype.sort 的优化
  //? https://github.com/v8/v8/blob/ad82a40509c5b5b4680d4299c8f08d6c6d31af3c/src/js/array.js#L763
  if (r - l <= 10) return insertionSort(arr, l, r)

  const p = partition(arr, l, r)
  quickSort(arr, l, p - 1)
  quickSort(arr, p + 1, r)
}

/**
 * 对 arr[l...r] 部分进行 partition
 * 返回 p，使得 arr[l...p-1] <= arr[p] <= arr[p+1...r]
 */
function partition(arr: number[], l: number, r: number): number {
  // 在 [l...r] 范围内随机取一个数交换到左侧
  swap(arr, l, Math.floor(Math.random() * (r - l + 1) + l))

  // 取最左侧的数（之前随机选到的数）作为基准值
  const pivot = arr[l]

  //? 优化点：解决数组中存在大量重复元素所导致的退化问题

  //? 当对一个存在大量重复元素的数组进行排序时
  //? 单路排序只能使与 pivot 相等的元素归于一侧（根据 arr[i] < pivot 或 arr[i] <= pivot）
  //? 这样会导致递归树失去平衡

  let i = l + 1
  let j = r
  // 循环中始终保持
  // arr[l+1,...i) <= pivot; arr(j...r] >= pivot
  while (true) {
    //? i 向右侧移动，直到遇到 >= pivot 的元素
    //? j 向左侧移动，直到遇到 <= pivot 的元素
    while (i <= r && arr[i] < pivot) i++
    while (j >= l + 1 && arr[j] > pivot) j--

    // 循环结束条件
    if (i > j) break

    swap(arr, i, j)
    i++
    j--
  }

  // i 此时停在从前向后看第一个大于等于 pivot 的位置
  // j 此时停在从后向前看第一个小于等于 pivot 的位置
  // [l=pivot] [l+1...j][i...r]

  // 因为 pivot 现在所在的位置 l 处于小于等于 pivot 的这一头
  // 将 pivot 与 j 位置的元素交换位置
  // 来满足 arr[l...p-1] <= arr[p] <= arr[p+1...r]
  swap(arr, l, j)
  return j
}

function swap(arr: number[], l: number, r: number): void {
  ;[arr[l], arr[r]] = [arr[r], arr[l]]
}

// 插入排序可以提前终止内层循环
// 因此在对近乎有序的数组进行排序时，时间复杂度接近 O(n)
function insertionSort(arr: number[], l: number, r: number) {
  // 从 l+1 开始将每个元素向前插入到合适的位置
  for (let i = l + 1; i <= r; i++) {
    let e = arr[i] // 寻找 e 合适的插入位置
    let j: number

    // 当 arr[j-1] <= e 退出循环
    for (j = i; j > l && arr[j - 1] > e; j--) {
      arr[j] = arr[j - 1] // 将元素后移
    }
    // 此时 j 的位置就是 e 需要插入的位置
    arr[j] = e
  }
}
