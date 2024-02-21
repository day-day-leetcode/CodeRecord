package com.liyzzz.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/02/21 16:41:40
 * @description 350 两个数组的交集 II
 * Map 实现
 */
public class Day_240221_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> maps = new HashMap<>(nums1.length);
        for (int k : nums1) {
            maps.put(k, maps.getOrDefault(k, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int j : nums2) {
            Integer count = maps.get(j);
            if (count == null || count == 0) {
                continue;
            }
            list.add(j);
            maps.put(j, maps.get(j) - 1);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Day_240221_350 day_240221_350 = new Day_240221_350();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = day_240221_350.intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

}
