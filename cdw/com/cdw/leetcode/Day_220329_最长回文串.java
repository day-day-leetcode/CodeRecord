package com.cdw.leetcode;

/**
 * Created by chendongwen on 2022/3/29
 */
public class Day_220329_最长回文串 {

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }

        /**
         * 大写字母A~Z对应的ASCII码（十进制）为“65”~“90”
         *
         * 小写字母a~z对应的百ASCII码（十进制）为"97"~“122”
         */
        int[] nums = new int[58];
        for (char temp : s.toCharArray()) {
            nums[temp - 'A']++;
        }
        int result = 0;
        for (int num : nums) {
            result += num - (num & 1);
        }
        /**
         *  result< s.length() 表示有一个多余的字符可以放在中间维持对称
         */
        return result < s.length() ? result + 1 : result;
    }
}
