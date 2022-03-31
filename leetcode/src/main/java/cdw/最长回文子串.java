package cdw;

/**
 * Created by chendongwen on 2022/3/31
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        String s = "eabcb";
        //eabcb
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = length; i > 0; i--) {
            for (int start = 0; start + i <= length; start++) {
                if (isPalindrome(chars, start, start + i - 1)) {
                    return s.substring(start, start + i);
                }
            }
        }

        return "";
    }

    private static boolean isPalindrome(char[] input, int left, int right) {
        while (left < right && input[left] == input[right]) {
            left++;
            right--;
        }
        return left >= right;
    }

}
