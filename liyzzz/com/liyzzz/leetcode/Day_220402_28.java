package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/02 18:49:40
 * @description 28 实现 strStr  优化版暴力
 */
public class Day_220402_28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int needleHashCode = needle.hashCode();
        for (int i = 0; i <= haystackChars.length - needleChars.length; i++) {
            if (haystackChars[i] != needleChars[0]) {
                continue;
            }
            //开头字母相等
            if (haystack.substring(i, i + needleChars.length).hashCode() != needleHashCode) {
                //如果hash不相等就没有判断的必要了
                continue;
            }
            boolean flag = true;
            //开头字母相等且hash相等 挨个比较
            for (int m = needleChars.length - 1; m >= 0; m--) {
                if (needleChars[m] != haystackChars[i + m]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
