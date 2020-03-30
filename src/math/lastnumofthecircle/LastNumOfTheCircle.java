package math.lastnumofthecircle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * Created by Michael Allan on 2020/3/30.
 */
public class LastNumOfTheCircle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.valueOf(line);
            int m = Integer.valueOf(br.readLine());
            int lastRemaining = new Solution().lastRemaining(n, m);
            System.out.println(lastRemaining);
        }
    }
    static class Solution {
        public int lastRemaining(int n, int m) {
            return findLastNum(n, m);
        }

        private int findLastNum(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = findLastNum(n - 1, m);
            return (m + x) % n;
        }
    }
}
