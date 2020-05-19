package string.validpalindromeII;

/**
 * Created by Michael Allan on 2020/5/19.
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        boolean validPalindrome = new ValidPalindromeII().new Solution().validPalindrome(s);
        System.out.println(validPalindrome);
    }
    class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            return leftValid(chars) || rightValid(chars);
        }

        private boolean leftValid(char[] chars) {
            int left = 0;
            int right = chars.length - 1;
            boolean hasRemoved = false;
            while (left < right) {
                if (chars[left] == chars[right]) {
                    left++;
                    right--;
                }else {
                    if(hasRemoved) {
                        return false;
                    }
                    hasRemoved = true;
                    if (chars[left + 1] == chars[right]) {
                        left += 2;
                        right--;
                    } else if (chars[left] == chars[right - 1]){
                        left++;
                        right -= 2;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean rightValid(char[] chars) {
            int left = 0;
            int right = chars.length - 1;
            boolean hasRemoved = false;
            while (left < right) {
                if (chars[left] == chars[right]) {
                    left++;
                    right--;
                }else {
                    if(hasRemoved) {
                        return false;
                    }
                    hasRemoved = true;
                    if (chars[left] == chars[right - 1]){
                        left++;
                        right -= 2;
                    }
                    else if (chars[left + 1] == chars[right]) {
                        left += 2;
                        right--;
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
