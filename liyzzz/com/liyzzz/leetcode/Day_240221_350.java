package com.liyzzz.leetcode;

import java.util.*;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/02/21 16:41:40
 * @description 350 两个数组的交集 II
 * Map 实现 时间复杂度 o(m+n)
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 双指针
 * <p>
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 将较小的数组哈希计数，随后在另一个数组中根据哈希来寻找。
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 如果内存十分小，不足以将数组全部载入内存，那么必然也不能使用哈希这类费空间的算法，只能选用空间复杂度最小的算法，即双指针解法。
 */
public class Day_240221_350 {
    /**
     * Map 实现
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect01(int[] nums1, int[] nums2) {
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

    /**
     * 双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        nums1 = Arrays.stream(nums1).sorted().toArray();
        nums2 = Arrays.stream(nums2).sorted().toArray();
        List<Integer> result=new ArrayList<>();
        int index = 0;
        for (int k : nums2) {
            for (int j = index; j < nums1.length; j++) {
                if (k == nums1[j]) {
                    index = j + 1;
                    result.add(k);
                    break;
                } else if (k < nums1[j]) {
                    break;
                }
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Day_240221_350 day_240221_350 = new Day_240221_350();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersect = day_240221_350.intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

}
