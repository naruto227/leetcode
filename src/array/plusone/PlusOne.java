package array.plusone;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/1/27.
 */
public class PlusOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int[] res = new Solution().plusOne(nums);
            System.out.println(ArrayUtil.integerArrayToString(res));
        }
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        int cnt = 1;
        for (int i = digits .length - 1; i >= 0; i--) {
            digits[i] = digits[i] + cnt;
            if (digits[i] >= 10) {
                cnt = 1;
                digits[i] = 0;
                continue;
            }
            break;
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
