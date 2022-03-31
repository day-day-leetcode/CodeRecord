package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/03/31 20:06:23
 * @description 5 最长回文子串 中心点枚举
 */
public class Day_220331_5 {

    public static String longestPalindrome(String s) {
        //最大长度子串
        String maxLength = "";
        if (s == null || s.length() == 0) {
            return maxLength;
        }
        // 有两种情况 1.以当前字符为中心向两边找 2.以当前字符和前一个字符为中心向两边找
        for (int i = 0; i  < s.length(); i++) {
            // 情况1
            String charSubStr = getMaxPalindrome(s, i, i);
            // 情况2
            String spaceSunStr = getMaxPalindrome(s, i, i + 1);

            if (charSubStr.length() > maxLength.length()) {
                maxLength = charSubStr;
            }
            if (spaceSunStr.length() > maxLength.length()) {
                maxLength = spaceSunStr;
            }
        }

        return maxLength;
    }

    /**
     * 向两边找寻最大的回文串
     *
     * @param s     总长度
     * @param start 开始位置
     * @param end   结束位置
     * @return 最大的回文串
     */
    private static String getMaxPalindrome(String s, int start, int end) {
        if (end + 1 > s.length()) {
            return "";
        }

        //开始到结束位置必须已经是回文串
        if (!isPalindrome(s.substring(start, end + 1))) {
            return "";
        }

        char[] chars = s.toCharArray();
        //向两边走 最多增加一半
        for (int i = 1; i < chars.length; i++) {
            if (start - i < 0 || end + i >= chars.length || chars[start - i] != chars[end + i]) {
                return s.substring(start - i + 1, end + i);
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 判断当前子串是不是回文串
     *
     * @param str 子串
     * @return 是或者否
     */
    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
