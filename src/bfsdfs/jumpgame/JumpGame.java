package bfsdfs.jumpgame;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

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
            boolean canJump = new Solution().canJump(nums);
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
            int lastIndex = 0;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                for (int i = 1; i <= node[1]; i++) {
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
                        lastIndex = index;
                    }
                }
            }
            return false;
        }
    }
}
