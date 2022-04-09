/*
 * @Author: Cphayim
 * @Date: 2022-04-08 15:31:26
 * @Description: 912.排序数组 https://leetcode-cn.com/problems/sort-an-array/
 * 三路快速排序
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

  const [p1, p2] = partition(arr, l, r)
  quickSort(arr, l, p1)
  quickSort(arr, p2, r)
}

/**
 * 对 arr[l...r] 部分进行 partition
 * 将 arr[l...r] 分为 <v; =v; >v 三个部分
 * 返回元组 [p1, p2]，[l...p1] 部分大于 v，[p2...r] 部分小于 v
 */
function partition(arr: number[], l: number, r: number): [number, number] {
  // 在 [l...r] 范围内随机取一个数交换到左侧
  swap(arr, l, Math.floor(Math.random() * (r - l + 1) + l))

  // 取最左侧的数（之前随机选到的数）作为基准值
  const pivot = arr[l]

  //? 优化点：解决数组中存在大量重复元素所导致的退化问题

  //? 当对一个存在大量重复元素的数组进行排序时
  //? 单路快排：
  //? 只能使与 pivot 相等的元素归于一侧（根据 arr[i] < pivot 或 arr[i] <= pivot）
  //? 这样会导致递归树失去平衡
  //? 双路快排：
  //? 每次进行 partition 可以保证左右相对平衡，但是左右还是会包含重复的（等于 pivot）的元素，需要重复处理

  let lt = l // arr[l+1...lt] < v
  let gt = r + 1 // arr[gt...r] > v
  let i = l + 1 // i 表示正在考察的位置，需满足 arr[lt+1...i) == v

  // 循环中始终保持
  //? arr[l+1,...lt] < pivot; arr[lt+1,...i) == v; arr[gt...r] > pivot
  while (i < gt) {
    //? 当 i 找到小于 pivot 的数时，将该数交换至 arr[l+1...lt] 区间
    if (arr[i] < pivot) {
      swap(arr, i, lt + 1)
      lt++
      i++
    }

    //? 当 i 遇到等于 pivot 的数时，什么也不做，继续前进
    else if (arr[i] === pivot) {
      i++
    }

    //? 当 i 遇到大于 pivot 的数时，将该数交换至 arr[gt...r] 区间
    else {
      swap(arr, i, gt - 1)
      gt--
      // 注意此处 i 不需要移动，因为交换回来的数还没有经过处理
    }
  }

  // lt 此时停在最后一个小于 pivot 的位置
  // gt 此时停第一个大于 pivot 的位置
  // [l=pivot][l+1...lt][lt+1...i)[gt...r]

  // 因为 pivot 现在所在的位置 l 处于小于 pivot 的这一头
  // 将 pivot 与 lt 位置的元素交换位置
  swap(arr, l, lt)
  lt-- // 注意，上一步交换之后 lt 位置的数是 pivot
  // 返回 lt 和 gt，中间部分都是等于 pivot 已经排好序
  return [lt, gt]
}

function swap(arr: number[], l: number, r: number): void {
  ;[arr[l], arr[r]] = [arr[r], arr[l]]
}
