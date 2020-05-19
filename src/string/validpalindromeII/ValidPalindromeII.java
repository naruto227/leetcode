package string.validpalindromeII;

/**
 * Created by Michael Allan on 2020/5/19.
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "baca";
        boolean validPalindrome = new ValidPalindromeII().new Solution().validPalindrome1(s);
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

        public boolean validPalindrome1(String s) {
            char[] chars = s.toCharArray();
            int low = 0;
            int high = chars.length - 1;
            while (low < high) {
                if (chars[low] == chars[high]) {
                    low++;
                    high--;
                } else {
                    boolean deleteHighOnce = true;
                    for (int i = low, j = high - 1; i < j; i++, j--) {
                        if (chars[i] != chars[j]) {
                            deleteHighOnce = false;
                            break;
                        }
                    }

                    boolean deleteLowOnce = true;
                    for (int i = low + 1, j = high; i < j; i++, j--) {
                        if (chars[i] != chars[j]) {
                            deleteLowOnce = false;
                            break;
                        }
                    }

                    return deleteHighOnce || deleteLowOnce;
                }
            }

            return true;
        }
    }
}
