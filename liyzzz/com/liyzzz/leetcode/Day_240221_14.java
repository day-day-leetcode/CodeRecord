package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/02/22 16:15:20
 * @description 14 最长公共前缀
 */
public class Day_240221_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //最长公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //找出当前字符串和最长公共前缀的最长公共前缀
            prefix = getCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private String getCommonPrefix(String prefix, String str) {
        if (prefix == null || prefix.trim().length() == 0) {
            return "";

        }
        int length = Math.min(prefix.length(), str.length());
        for (int i = length; i > 0; i--) {
            for (int j = length; j > 0; j--) {
                if (prefix.substring(0, i).equals(str.substring(0, j))) {
                    return prefix.substring(0, i);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Day_240221_14().longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
