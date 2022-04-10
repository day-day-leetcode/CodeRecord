/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 随机化快速排序
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
 * 返回 p，使得 arr[l...p-1] < arr[p] < arr[p+1...r]
 */
function partition(arr: number[], l: number, r: number): number {
  //? 优化点：解决对近乎有序的数组排序时的退化问题

  //? 当对一个近乎有序的数组进行排序时，快速排序的递归树将不再不平衡
  //? 最差的情况下会退化到 O(n^2) 的时间复杂度
  //? 因此我们需要随机选择数作为 pivot，这样退化到 O(n^2) 的概率近乎为 0

  // 在 [l...r] 范围内随机取一个数交换到左侧
  swap(arr, l, Math.floor(Math.random() * (r - l + 1) + l))

  // 取最左侧的数（之前随机选到的数）作为基准值
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
