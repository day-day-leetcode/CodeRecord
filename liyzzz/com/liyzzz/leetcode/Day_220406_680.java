package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/06 22:40:19
 * @description 680 验证回文字符串Ⅱ 贪心 + 双指针 0(n)
 *
 * 这道题的关键是 最多只删除一个字符
 */
public class Day_220406_680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left=0;
        int right=chars.length-1;
        while (left<right){
            if(chars[left]!=chars[right]){
                //删除左边或者右边
                return subIsPalindrome(chars,left+1,right)||subIsPalindrome(chars,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean subIsPalindrome(char[] chars, int left, int right) {
        while (left<right){
            if(chars[left]!=chars[right]){
               return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
