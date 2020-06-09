package bfsdfs.tnis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/6/9.
 */
public class TranslateNumIntoStr {
    public static void main(String[] args) throws IOException {
        Solution solution = new TranslateNumIntoStr().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int translateNum = solution.translateNum(Integer.parseInt(line));
            System.out.println(translateNum);
        }
    }

    class Solution {
        public int translateNum(int num) {
            return helper(num);
        }

        private int helper(int num) {
            if (num < 10) {
                return 1;
            }
            // 最后的两位数字大于等于10，且小于等于25，可以拆分成两种情况
            if (num % 100 < 26 && num % 100 > 9) {
                return helper(num / 10) + helper(num / 100);
            } else {
                return helper(num / 10);
            }
        }
    }
}
