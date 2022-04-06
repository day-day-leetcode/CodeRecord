package com.cdw.leetcode;

/**
 * Robin Karp算法
 * 时间复杂度：o(n+m)
 * 比较当前字符和目标字符的哈希，如果相等则继续比较值，相较于直接比较值，减少了得到目标值之前的比较时间
 * Created by chendongwen on 2022/4/01
 */
public class Day_220403_实现strStrv2 {
    private static final int BASE = 1000000;

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        if (null == haystack || haystack.length() == 0 || null == needle) {
            return -1;
        }
        int length = needle.length();
        if (0 == length) {
            return 0;
        }
        int power = 1;
        for (char c : needle.toCharArray()) {
            power = (power * 31) % BASE;
        }

        int targetCode = 0;
        for (char c : needle.toCharArray()) {
            targetCode = (targetCode * 31 + c) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < haystack.length(); i++) {
            hashCode = (hashCode * 31 + haystack.charAt(i)) % BASE;

            if (i < length - 1) {
                continue;
            }

            if (i >= length) {
                // abcd中比较完abc不匹配 接下去要匹配bcd, bcd的hashCode等于abc的hashCode - abcd的hashCode - a的hashCode
                hashCode = hashCode - (haystack.charAt(i - length) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            if (hashCode == targetCode) {
                if (haystack.substring(i - length + 1, i + 1).equals(needle)) {
                    return i - length + 1;
                }
            }
        }

        return -1;
    }


}
