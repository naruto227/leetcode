package bfsdfs.jumpgame;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 55. Jump Game
 * 链接：https://leetcode-cn.com/problems/jump-game/
 * Created by Michael Allan on 2020/4/17.
 */
public class JumpGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            boolean canJump = new Solution().canJump2(nums);
            System.out.println(canJump);
        }
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int end = nums.length - 1;
            Deque<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { 0, nums[0] });
            boolean[] visited = new boolean[nums.length];
            visited[0] = true;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                for (int i = 1; i < nums.length && i <= node[1]; i++) {
                    int index = node[0] + i;
                    // 当走到了新的索引的位置，刚好是最后一个元素时，返回true
                    if (index == end) {
                        return true;
                    }
                    int value = nums[index];
                    int[] newNode = new int[] { index, value };
                    // 剪枝，如果未访问过就加入队列
                    if (!visited[index]) {
                        queue.offer(newNode);
                        visited[index] = true;
                    }
                }
            }
            return false;
        }

        /**
         * 贪心算法，遍历，找到当前最远可到达的位置
         * @param nums
         * @return
         */
        public boolean canJump1(int[] nums) {
            int len = nums.length;
            int remote = 0;
            for (int i = 0; i < len; i++) {
                // 第i个位置可达
                if (remote >= i) {
                    if (remote >= len - 1) {
                        return true;
                    }
                    remote = Math.max(remote, i + nums[i]);
                }
            }
            return false;
        }

        /**
         * dp思想，dp[i]表示前i个元素所能到达的最远位置。
         * 状态转移方程：
         * 1、i可达，dp[i - 1] >= i, dp[i] = max(dp[i - 1], i + nums[i])；
         * 2、dp[i - 1] < i, i不可达 --> 大于等于i后面的位置均不可达
         * @param nums
         * @return
         */
        public boolean canJump2(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int length = nums.length;
            int end = length - 1;
            int[] dp = new int[length];
            dp[0] = nums[0];
            for (int i = 1; i < length; i++) {
                if (dp[i - 1] >= end) {
                    return true;
                }
                if (dp[i - 1] >= i) {
                    dp[i] = Math.max(dp[i - 1], i + nums[i]);
                }else {
                    return false;
                }
            }
            return false;
        }

        public boolean canJump3(int[] nums) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[nums.length];
            q.offer(0);
            while(!q.isEmpty()) {
                for(int size=q.size();size>0;size--) {
                    // idx is current position
                    int idx = q.remove();
                    // if this condition is true, we can find an answer
                    if(idx >= nums.length - 1) return true;
                    // i is the next rightmost position we can reach
                    for(int i=idx + 1;i < nums.length &&
                            i<=idx + nums[idx];i++) {
                        if(visited[i]) continue;
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
            return false;
        }
    }
}
