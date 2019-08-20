package integer.reverseInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 * Created by Michael Allan on 2019/8/21.
 */
public class ReverseInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}

class Solution {
    public int reverse(int x) {
        return 0;
    }
}
