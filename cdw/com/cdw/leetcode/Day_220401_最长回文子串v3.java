package com.cdw.leetcode;

/**
 * 动态规划解法
 * 时间复杂度：o(n^2)
 * Created by chendongwen on 2022/4/01
 */
public class Day_220401_最长回文子串v3 {

    public static void main(String[] args) {
        String s = "ac";
        //eabcb
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        int length = s.length();
        if (length == 1) {
            return s;
        }
        boolean[][] min = new boolean[length][length];
        String longestStr = s.substring(0, 1);
        for (int right = 1; right < length; right++) {
            // 单个字符必定是回文串
            min[right][right] = true;
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    min[left][right] = false;
                    continue;
                }
                // aa bb这种情况
                if (left + 1 > right - 1) {
                    min[left][right] = true;
                } else {
                    //如果字串也是回文串，那么当前串也是回文串
                    min[left][right] = min[left + 1][right - 1];
                }
                //当前串是回文串，并且大于当前最大的回文串长度
                if (min[left][right] && right - left + 1 > longestStr.length()) {
                    longestStr = s.substring(left, right + 1);
                }
            }
        }
        return longestStr;
    }


}
