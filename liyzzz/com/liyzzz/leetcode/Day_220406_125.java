package com.liyzzz.leetcode;

import javax.xml.stream.events.Characters;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/06 21:35:57
 * @description 125题 验证回文串 双指针 o(n)
 */
public class Day_220406_125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            //判断左边不是数字或者字母的 就左指针右移  为什么 left < right 没有 = 号 因为 left=right 字符一定是相等的没有判断必要
            while (left < right && !isDigitOrLetter(chars[left])) {
                left++;
            }
            //判断右边不是数字或者字母的 就右指针左移
            while (left < right && !isDigitOrLetter(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            if (!isEquals(chars[left], chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isDigitOrLetter(char ch) {
        //isDigit 是否是数字 isLetter 是否是字母
        return Character.isDigit(ch) || Character.isLetter(ch);
    }

    /**
     * 判断两个字符忽略大小写是否相等
     *
     * @param left  字符1
     * @param right 字符2
     * @return 是否相等
     */
    private boolean isEquals(char left, char right) {
        return Character.toLowerCase(left) == Character.toLowerCase(right);
    }

    public static void main(String[] args) {
        Day_220406_125 day_220406_125 = new Day_220406_125();
        System.out.println(day_220406_125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
