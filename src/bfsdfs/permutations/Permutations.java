package bfsdfs.permutations;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations
 * 链接：https://leetcode-cn.com/problems/permutations/
 * Created by Michael Allan on 2020/4/25.
 */
public class Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            List<List<Integer>> permute = new Permutations().new Solution().permute(nums);
            System.out.println(permute);
        }
    }

    class Solution {
        List<List<Integer>> list = new LinkedList<>();
//        public List<List<Integer>> permute(int[] nums) {
//
//            boolean[] visited = new boolean[nums.length];
//
//            getPermute(0, nums, visited, new LinkedList<>());
//
//            return list;
//        }
//
//        /**
//         * 以第nums[index]开头的全遍历，搜索回溯
//         * @param index
//         * @param nums
//         * @param visited 存储中间结果，元素是否访问过，回溯用
//         * @param res 存储遍历的结果
//         */
//        private void getPermute(int index, int[] nums, boolean[] visited, List<Integer> res) {
//            if (index >= nums.length) {
//                list.add(new LinkedList<>(res));
//                return;
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if (!visited[i]) {
//                    res.add(nums[i]);
//                    visited[i] = true;
//                    getPermute(index + 1, nums, visited, res);
//                    // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
//                    visited[i] = false;
//                    res.remove(res.size() - 1);
//                }
//            }
//
//        }
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>();
            dfs(nums, len, 0, used, path);
            return list;
        }

        private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path) {
            if (depth == len) {
                list.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.addLast(nums[i]);
                    used[i] = true;
                    dfs(nums, len, depth + 1, used, path);
                    used[i] = false;
                    path.removeLast();
                }
            }
        }
    }

}
