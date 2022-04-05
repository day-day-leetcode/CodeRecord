/*
 * @Author: Cphayim
 * @Date: 2022-04-05 19:40:19
 * @Description: 1.两数之和 https://leetcode-cn.com/problems/two-sum/
 * 排序+双指针
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(n) 空间复杂度一般指额外空间复杂度，既不包含输入和输出
 */

function twoSum(nums: number[], target: number): number[] {
  // 生成一个 [num, index][] 元组数组 tnums，元组的第一个元素是数字，第二个元素是索引
  const tupleArr = nums.map<[number, number]>((num, index) => [num, index])
  // 对 tnums 按 num 大小进行顺序排序，JS 中 Array.prototype.sort 使用的是快速排序，时间复杂度为 O(nlogn)
  tupleArr.sort((tupleA, tupleB) => tupleA[0] - tupleB[0])

  let left = 0
  let right = tupleArr.length - 1
  // 相向双指针遍历
  while (left < right) {
    if (tupleArr[left][0] + tupleArr[right][0] > target) {
      // 相加结果大于 target，左移右指针
      right--
    } else if (tupleArr[left][0] + tupleArr[right][0] < target) {
      // 相加结果小于 target，右移左指针
      left++
    } else {
      // 相加结果等于 target，返回对应的索引数组
      return [tupleArr[left][1], tupleArr[right][1]]
    }
  }

  return [-1, -1]
}

if (import.meta.vitest) {
  const { test, expect } = import.meta.vitest
  test('can get the index of two numbers', () => {
    expect(twoSum([3, 2, 4], 6)).toEqual([1, 2])
    expect(twoSum([3, 3], 6)).toEqual([0, 1])
    expect(twoSum([2, 7, 11, 15], 9)).toEqual([0, 1])
  })
}
