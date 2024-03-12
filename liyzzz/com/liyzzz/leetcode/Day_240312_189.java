package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/03/12 22:14:43
 * @description 轮转数组
 */
public class Day_240312_189 {
    public void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, newNums.length);
    }

    public static void main(String[] args) {
        Day_240312_189 day240312189 = new Day_240312_189();
        int[] nums = {-1, -100, 3, 99};
        day240312189.rotate(nums, 2);
    }
}
