package com.liyzzz.leetcode;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/06 15:41:48
 * @description 28 实现 strStr  Rabin Karp 算法 时间复杂度 o(m)
 * 该算法和 Day_220402_28 爆破相比 对计算hash值哪里做了优化
 * 一般来说计算hash值的方式是  以 "abcd" 为例：a*31^4+b*31^3+c*31^2+d*31^1
 * 注:  31 只是一个java为了 散列 所选择的数 从理论上来讲 任意一个数字都可以 一般来说选择素数散列的效果会更好
 * <p>
 * 从上面来看计算过程可以得到 如果我计算的是"abcd" 的两个子串 "abc" 和 "bcd" 其实两个值得结果是由联系的
 * "abc" hash： a*31^3+b*31^2+c*31^1
 * "bcd" hash: b*31^3+c*31^2+d*31^1
 * 也等于: （"abc"的hash值 - a*31^子串的长度）*31 + d*31^1
 * 这样每次计算hash值都不用从头到位去遍历的 只需要把上次的hash来计算一遍 就可以得到下个子串的hash值
 * <p>
 * 为了避免每次计算值过大 可以在每次计算的时候都取一个固定模
 * 算的过程中避免数字过大要不断模，如果减后变为负数，再加上模即
 */
public class Day_220403_28 {
    /**
     * 取模值
     */
    private int MOD = 1000000;

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();


        int needleHashCode = strHashCode(needle, 0, needle.length());
        //每次的hash值 初始化为-1
        int subHaystackHash = -1;

        for (int i = 0; i <= haystackChars.length - needleChars.length; i++) {
            //和 Day_220402_28 相比只是这里发生的改变
            subHaystackHash = subHaystackHash(haystack, i - 1, needleChars.length, subHaystackHash);
            if (subHaystackHash != needleHashCode) {
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

    /**
     * 计算一个字符串从开始到结束位置的hash值
     *
     * @param str   计算的字符串
     * @param start 开始位置 包含
     * @param end   结束位置 不包含
     * @return hash值
     */
    private int strHashCode(String str, int start, int end) {
        char[] chars = str.toCharArray();
        int hash = 0;
        for (int i = start; i < start+end; i++) {
            hash = hash + chars[i] * 31 % MOD;
        }
        return hash % MOD;
    }

    /**
     * 根据上次计算的结果 计算开始位置移动1位 子串的hash值
     *
     * @param haystack            寻找的串
     * @param lastStart           上次计算的hash值的开始位置 包含
     * @param needleLength        子串的长度
     * @param lastSubHaystackHash 上次计算的hash值
     * @return 新的hash值
     */
    private int subHaystackHash(String haystack, int lastStart, int needleLength, int lastSubHaystackHash) {
        char[] chars = haystack.toCharArray();
        if (lastSubHaystackHash < 0) {
            //证明没有计算过
            return strHashCode(haystack, lastStart + 1, needleLength);
        }
        return (lastSubHaystackHash - chars[lastStart] * 31 % MOD + chars[lastStart + needleLength] * 31 % MOD) % MOD;
    }

    public static void main(String[] args) {
        Day_220403_28 day_220403_28 = new Day_220403_28();
        System.out.println(day_220403_28.strStr("hellolla", "lla"));
    }
}
