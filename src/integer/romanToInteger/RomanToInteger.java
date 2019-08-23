// source: https://leetcode-cn.com/problems/roman-to-integer
package integer.romanToInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9. 
 X can be placed before L (50) and C (100) to make 40 and 90. 
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 * Created by Michael Allan on 2019/8/24.
 */
public class RomanToInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

        }
    }

}

class Solution {
    public int romanToInt(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(romanCharToInt(s.charAt(i)));
        }
        int sum = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Integer left = list.get(i);
            if (i == size - 1) {
                sum += left;
                break;
            }
            int j = i + 1;
            Integer right = list.get(j);
            if (left >= right) {
                sum += left;
            } else {
                sum += (right - left);
                i = j;
            }
            if (i == size - 1) {
                break;
            }
        }
        return sum;
    }


    private Integer romanCharToInt(char c) {
        int num = 0;
        switch (c) {
            case 'I': num = 1;break;
            case 'V': num = 5;break;
            case 'X': num = 10;break;
            case 'L': num = 50;break;
            case 'C': num = 100;break;
            case 'D': num = 500;break;
            case 'M': num = 1000;break;
            default: num = 0;
        }
        return num;
    }
}