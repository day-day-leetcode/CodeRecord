/*
 * @Author: Cphayim
 * @Date: 2022-04-05 19:40:19
 * @Description: 1.两数之和 https://leetcode-cn.com/problems/two-sum/
 * 哈希表解法
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */

function twoSum(nums: number[], target: number): number[] {
  // 用于保存遍历过的 值:索引
  const map = new Map<number, number>()

  for (let i = 0; i < nums.length; i++) {
    // 如果在 map 中找到差值则返回结果
    if (map.has(target - nums[i])) {
      return [map.get(target - nums[i])!, i]
    }
    map.set(nums[i], i)
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
