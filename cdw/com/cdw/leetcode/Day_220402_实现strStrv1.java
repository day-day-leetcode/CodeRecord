package com.cdw.leetcode;

/**
 * 暴破
 * Created by chendongwen on 2022/4/01
 */
public class Day_220402_实现strStrv1 {

    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        if (null == haystack || haystack.length() == 0 || null == needle || needle.length() == 0) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            String temp;
            if (haystack.length() - i >= needle.length()) {
                temp = haystack.substring(i, needle.length() + i);
            } else {
                return -1;
            }

            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}
