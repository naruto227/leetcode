package bfsdfs.rangemotionofrobot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题13. 机器人的运动范围
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 注：此问题使用DFS的解法比BFS快
 * Created by Michael Allan on 2020/4/8.
 */
public class RangeMotionOfRobot {
    public static void main(String[] args) {
//        int movingCount = new Solution().movingCount(2, 3, 1);
//        int movingCount = new Solution().movingCount(3, 1, 0);
        int movingCount = new Solution().movingCount2(100, 100, 20);
        System.out.println(movingCount);
    }

    static class Solution {
        /**
         * 使用 BFS，数位和优化点：数位和特点： 根据数位和增量公式得知，数位和每逢 进位 突变一次（如行
         * 列从 9-->10 ）。
         * 若当前和为s_x，(x + 1) % 10 != 0 ? s_x + 1 : s_x - 8
         * @param m
         * @param n
         * @param k
         * @return
         */
        public int movingCount(int m, int n, int k) {
            int res = 0;
            boolean[][] visited = new boolean[m][n];
            // 队列中存放数组，包含行号、列号、行的数位和、列的数位和
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{0, 0, 0, 0});
            while (!deque.isEmpty()) {
                int[] node = deque.poll();
                int row = node[0];
                int col = node[1];
                int sx = node[2];
                int sy = node[3];
                if (row >= m || col >= n || sx + sy > k || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                res++;
                int nsx = (row + 1) % 10 == 0 ? sx - 8 : sx + 1; // row + 1，向下移动，产生新的数位和
                int nsy = (col + 1) % 10 == 0 ? sy - 8 : sy + 1; // col + 1，向右移动，产生新的数位和
                deque.add(new int[]{row + 1, col, nsx, sy}); // 向下
                deque.add(new int[]{row, col + 1, sx, nsy}); // 向右
//                deque.add(new int[] { row + 1, col, (row + 1) % 10 != 0 ? sx + 1 : sx - 8, sy });
//                deque.add(new int[] { row, col + 1, sx, (col + 1) % 10 != 0 ? sy + 1 : sy - 8 });
            }
            return res;
        }

        public int movingCount1(int m, int n, int k) {
            int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[] { 0, 0 });

            boolean[][] visited = new boolean[m][n];
            visited[0][0] = true;
            int res = 1;
            while (!deque.isEmpty()) {
                int[] element = deque.poll();
                for (int i = 0; i < 4; i++) {
                    int row = element[0] + direction[i][1];// 行上下放向移动
                    int col = element[1] + direction[i][0];// 列左右移动
                    if ((row >= 0) && (row < m) && (col >= 0) && (col < n) && !visited[row][col]) {
                        visited[row][col] = true;
                        int sum = 0;
                        int tempRow = row;
                        int tempCol = col;
                        while (tempRow != 0) {
                            sum += tempRow % 10;
                            tempRow /= 10;
                        }
                        while (tempCol != 0) {
                            sum += tempCol % 10;
                            tempCol /= 10;
                        }
                        if (sum <= k) {
                            deque.add(new int[] { row, col });
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        /**
         * DFS。通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
         剪枝： 在搜索中，遇到数位和超出目标值、此元素已访问，则应立即返回，称之为 可行性剪枝 。
         * @param m
         * @param n
         * @param k
         * @return
         */
        int m, n, k;
        boolean[][] visited;
        public int movingCount2(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        private int dfs(int row, int col, int sx, int sy) {
            if (row >= m || col >= n || sx + sy > k || visited[row][col]) {
                return 0;
            }
            visited[row][col] = true;
            int nsx = (row + 1) % 10 == 0 ? sx - 8 : sx + 1; // row + 1，向下移动，产生新的数位和
            int nsy = (col + 1) % 10 == 0 ? sy - 8 : sy + 1; // col + 1，向右移动，产生新的数位和
            return 1 + dfs(row + 1, col, nsx, sy) + dfs(row, col + 1, sx, nsy);
        }
    }
}
