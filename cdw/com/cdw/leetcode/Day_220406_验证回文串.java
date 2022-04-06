package com.cdw.leetcode;

/**
 * 双指针算法
 * 时间复杂度：
 * 比较当前字符和目标字符的哈希，如果相等则继续比较值，相较于直接比较值，减少了得到目标值之前的比较时间
 * Created by chendongwen on 2022/4/01
 */
public class Day_220406_验证回文串 {

    /**
     * 大写字母A~Z对应的ASCII码（十进制）为“65”~“90”
     * 数字0~9对应的ASCII码（十进制）为“48”~“57”
     * 小写字母a~z对应的百ASCII码（十进制）为"97"~“122”
     */
    public static boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (s.length() <= 1) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValid(s.charAt(right))) {
                right--;
                continue;
            }
            if (convertCase(s.charAt(left)) != convertCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isValid(char c) {
        return (65 <= c && c <= 90) || (97 <= c && c <= 122) || (48 <= c && c <= 57);
    }

    private static char convertCase(char c) {
        //小写转大写
        if (97 <= c && c <= 122) {
            return (char) (c - 32);
        }
        if ((65 <= c && c <= 90) || (48 <= c && c <= 57)) {
            return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
