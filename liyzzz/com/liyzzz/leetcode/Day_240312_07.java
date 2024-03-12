package com.liyzzz.leetcode;

import java.util.*;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/03/12 22:37:28
 * @description 三数之和
 */
public class Day_240312_07 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //确定第一个数,其他两个数只需要和为差值就可以
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            //去除第一个数重复的场景
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                int num = nums[l] + nums[r];
                if (num < target) {
                    l++;
                } else if (num > target) {
                    r--;
                } else {
                    //去除第二数重复的场景
                    if (l > i + 1 && nums[l] == nums[l - 1]) {
                        l++;
                        r--;
                        continue;
                    }
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    result.add(list);
                    l++;
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Day_240312_07 day24031207 = new Day_240312_07();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        day24031207.threeSum(nums);
    }
}
