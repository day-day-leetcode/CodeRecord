package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/03/29 20:50:42
 * @description 5 爆破 时间复杂度o(n^3)
 */
public class Day_220330_5 {

    public static String longestPalindrome(String s){
        //最大长度子串
        String maxLength = "";
        if (s == null || s.length() == 0) {
            return maxLength;
        }
        // 遍历找出所有的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() ; j > i; j--) {
                //左闭又开
                String sub = s.substring(i, j);
                //判断当前子串是不是回文串 且 大于已知最大长度
                if (isPalindrome(sub) && sub.length() > maxLength.length()) {
                    maxLength = sub;
                }
            }
        }

        return maxLength;
    }

    /**
     * 判断当前子串是不是回文串
     *
     * @param str
     * @return 是或者否
     */
    private static boolean isPalindrome(String str) {
//        是回文串证明 每个 char[i]==char[str.length()-1-i]
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

}

