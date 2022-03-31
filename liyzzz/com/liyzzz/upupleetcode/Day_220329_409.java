package com.liyzzz.upupleetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/03/29 21:08:00
 * @description 409
 */
public class Day_220329_409 {

    public int longestPalindrome(String s) {
        int maxLength = 0;
        if (s == null || s.length() == 0) {
            return maxLength;
        }
//        奇数个除了最大的值可以放在中间 偶数放在两边 比最大的奇数小的只能-1变成偶数放在两边
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        //奇数总和
        int addCount = 0;
        for (int i : cnt) {
            if (i % 2 != 0) {
                //是奇数
                addCount++;
            }
        }
        //如果有奇数 则为 总长度-奇书*1+ 最长的多的1
        return addCount == 0 ? s.length() : s.length() - addCount + 1;
    }

}

