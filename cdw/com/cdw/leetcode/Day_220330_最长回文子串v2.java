package com.cdw.leetcode;

/**
 * Created by chendongwen on 2022/4/1
 */
public class Day_220330_最长回文子串v2 {

    public static void main(String[] args) {
        System.out.println(longestPalindromeV1("eabcb"));
    }

    /**
     * 背向双指针
     *
     * @param s
     * @return
     */
    public static String longestPalindromeV1(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        //start回文串起点 longest回文串最长
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            //奇数回文串
            String oddPalindrome = getLongestPalindrome(s, i, i);
            if (longestPalindrome.length() < oddPalindrome.length()) {
                longestPalindrome = oddPalindrome;
            }

            //偶数回文串
            String evenPalindrome = getLongestPalindrome(s, i, i + 1);
            if (longestPalindrome.length() < evenPalindrome.length()) {
                longestPalindrome = evenPalindrome;
            }
        }

        return longestPalindrome;
    }

    private static String getLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
