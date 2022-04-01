package com.cdw.leetcode;

/**
 * 描述
 *
 * @author cdw
 * @version 1.0
 * @date 2022/03/31 19:50:40
 * @description 5
 */
public class Day_220401_最长回文子串v3 {

    public static void main(String[] args) {
        String s = "eabcb";
        //eabcb
        System.out.println(longestPalindrome(s));
    }

    /**
     * 暴力解 o(n^3)
     *
     * @param s
     * @return
     */
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
