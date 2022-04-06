package com.cdw.leetcode;

/**
 * 暴力破解
 *  时间复杂度：o(n^3)
 * Created by chendongwen on 2022/4/1
 */
public class Day_220330_最长回文子串v1 {
    public static void main(String[] args) {
        String s = "eabcb";
        //eabcb
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = length; i > 0; i--) {
            for (int start = 0; start + i <= length; start++) {
                if (isPalindrome(chars, start, start + i - 1)) {
                    return s.substring(start, start + i);
                }
            }
        }

        return "";
    }

    private static boolean isPalindrome(char[] input, int left, int right) {
        while (left < right && input[left] == input[right]) {
            left++;
            right--;
        }
        // left >= right表示跳出while循环是因为两个指针相遇过
        return left >= right;
    }

}
