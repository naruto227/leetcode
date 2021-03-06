package string.formcharacters;

import java.util.*;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * You are given an array of strings words and a string chars.

 A string is good if it can be formed by characters from chars (each character can only be used once).

 Return the sum of lengths of all good strings in words.

 String[] words = {"cat","bt","hat","tree"};
 String chars = "atach";


 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * Created by Michael Allan on 2020/3/17.
 */
public class FormCharacters {
    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        int countCharacters = new Solution().countCharacters1(words, chars);
        System.out.println(countCharacters);
    }

    static class Solution {
        public int countCharacters(String[] words, String chars) {
            char[] charArray = chars.toCharArray();
            Map<Character, Integer> charsMap = new HashMap<>();
            for (char c : charArray) {
                if(charsMap.containsKey(c)) {
                    charsMap.put(c, charsMap.get(c) + 1);
                }else {
                    charsMap.put(c, 1);
                }
            }
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                boolean formed = true;
                Map<Character, Integer> wordMap = new HashMap<>();
                char[] wordArray = words[i].toCharArray();
                for (char c : wordArray) {
                    if(wordMap.containsKey(c)) {
                        wordMap.put(c, wordMap.get(c) + 1);
                    }else {
                        wordMap.put(c, 1);
                    }
                    if(charsMap.get(c) == null || charsMap.get(c) < wordMap.get(c)) {
                        formed = false;
                        break;
                    }
                }
                if(formed) {
                    sum += wordArray.length;
                }
            }
            return sum;
        }

        public int countCharacters1(String[] words, String chars) {
            int sum = 0;
            int[] chars_count = count(chars);
            for (String word : words) {
                int[] word_count = count(word);
                if (contains(chars_count, word_count)) {
                    sum += word.length();
                }
            }
            return sum;
        }

        private boolean contains(int[] chars_count, int[] word_count) {
            boolean res = true;
            for (int i = 0; i < 26; i++) {
                if(chars_count[i] < word_count[i]) {
                    res = false;
                    break;
                }
            }
            return res;
        }

        private int[] count(String word) {
            int[] counter = new int[26];
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                counter[c - 'a']++;
            }
            return counter;
        }
    }
}
