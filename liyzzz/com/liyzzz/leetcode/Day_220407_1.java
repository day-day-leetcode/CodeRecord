package com.liyzzz.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/08 11:28:32
 * @description 1 两数之和 双指针
 */
public class Day_220407_1 {
    public int[] twoSum(int[] nums, int target) {
        //返回值
        int[] targetNums = new int[2];

        if (nums == null || nums.length < 2) {
            //违规输入
            return targetNums;
        }
        //列是每个数 行是原来下标
        int[][] indexNums = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            indexNums[i][0] = nums[i];
            indexNums[i][1] = i;
        }
        //排序
        Arrays.sort(indexNums, Comparator.comparing(o->o[0]));

        int right = indexNums.length - 1;
        int left = 0;
        while (left < right) {
            int targetRight = target - indexNums[left][0];
            while (right > left && indexNums[right][0] > targetRight) {
                right--;
            }
            if (left >= right) {
                break;
            }
            if (indexNums[right][0] < targetRight) {
                left++;
                continue;
            }
            if (indexNums[right][0] == targetRight) {
                targetNums[0] = indexNums[left][1];
                targetNums[1] = indexNums[right][1];
                break;
            }
        }
        return targetNums;
    }

    public static void main(String[] args) {
        Day_220407_1 day_220407_1 = new Day_220407_1();
        int[] nums = {0,4,3,0};
        System.out.println(Arrays.toString(day_220407_1.twoSum(nums, 0)));
    }
}
