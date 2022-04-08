package com.liyzzz.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/08 20:01:43
 * @description 1 两数之和 双指针 hash
 * <p>
 * 这里主要需要很巧妙地避免hash冲突的情况
 */
public class Day_220408_1 {
    public int[] twoSum(int[] nums, int target) {
        //返回值
        int[] targetNums = new int[2];

        if (nums == null || nums.length < 2) {
            //违规输入
            return targetNums;
        }
        //key：值  value：下标
        Map<Integer, Integer> maps = new HashMap<>(128);
        for (int i = 0; i < nums.length; i++) {
            // 为了避免重复值  所以判断再放值
            // 1.每次写入时，判断条件 不是当前的key本身存不存在，而是key和 tag 之间的差值存不存在，这一点很重要。
            // 2.题目命题说明了一点，假定只有一个解。也就是说重复元素再多都无所谓。
            // case 1：如果有3个或者以上的重复元素，代表这个重复元素不可能是解，所以写入map的时候直接覆盖也无所谓；
            // case2：如果只有两个重复元素，同样的道理，假如这个重复元素是解，那么必定是两个重复元素的和等于tag。
            // 这种情况下，当遇到第二个重复元素时，不会写入map，这个时候直接已经取到解了。 所以这种方式，不用考虑hash冲突的问题。
            Integer integer = maps.get(target - nums[i]);
            if (integer != null) {
                targetNums[0] = i;
                targetNums[1] = integer;
                return targetNums;
            }
            maps.put(nums[i], i);
        }
        return targetNums;
    }
}
