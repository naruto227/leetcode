package bfsdfs.jumpgame;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/5/4.
 */
public class JumpGameTwo {
    public static void main(String[] args) throws IOException {
        Solution solution = new JumpGameTwo().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int jump = solution.jump(nums);
            System.out.println(jump);
        }
    }

    class Solution {
        // 这个写法有点问题
        public int jump(int[] nums) {
            int end = nums.length - 1;
            if (end == 0) {
                return 0;
            }
            int times = 0;
            int start = 0;

            for(;;) {
                int remote = start + nums[start];
                ++times;
                if (remote == end) {
                    return times;
                }
                int k = remote;
                int i = start + 1;
                for (;i <= k; i++) {
                    remote = i + nums[i];
                    if (remote >= end) {
                        return ++times;
                    }
                    start = Math.max(start, remote);
                }
            }
        }

        public int jump1(int[] nums) {
            int step = 0;
            int end = 0;
            int maxPosition = 0;
            int lastIndex = nums.length - 1;
            for (int i = 0; i < lastIndex; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    step++;
                }
            }
            return step;
        }
    }
}
