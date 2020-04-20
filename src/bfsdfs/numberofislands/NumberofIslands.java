package bfsdfs.numberofislands;

import java.util.LinkedList;

/**
 * 200. Number of Islands
 * 链接：https://leetcode-cn.com/problems/number-of-islands/
 * Created by Michael Allan on 2020/4/20.
 */
public class NumberofIslands {
    public static void main(String[] args) {
        Solution solution = new NumberofIslands().new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands = solution.numIslands(grid1);
        System.out.println(numIslands);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands1 = solution.numIslands(grid2);
        System.out.println(numIslands1);

    }

    class Solution {
        private int row;
        private int col;

        /**
         * BFS解法
         * @param grid
         * @return
         */
        public int numIslands(char[][] grid) {
            this.row = grid.length;
            // 矩阵为空
            if (row == 0) {
                return 0;
            }
            this.col = grid[0].length;
            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            boolean[][] visited = new boolean[row][col];
            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // 如果是一个陆地，且未被访问过，从坐标为 (i,j) 的点开始进行广度优先搜索
                    // 搜索所有与（i,j）连接在一起构成岛屿的点
                    if (!visited[i][j] && grid[i][j] == '1') {
                        res++;
                        // 注意：这里要标记上已经访问过
                        visited[i][j] = true;
                        LinkedList<Integer> queue = new LinkedList<>();
                        // 小技巧：把坐标转换为一个数字
                        // 否则，得用一个数组存
                        queue.offer(i * col + j);
                        while (!queue.isEmpty()) {
                            Integer cur = queue.poll();
                            int curX = cur / col;
                            int curY = cur % col;
                            // 得到 4 个方向的坐标
                            for (int k = 0; k < 4; k++) {
                                int newX = curX + direction[k][0];
                                int newY = curY + direction[k][1];
                                // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                                if (inArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                                    // 标记这个点访问过了
                                    visited[newX][newY] = true;
                                    // 将新点加入队列
                                    queue.offer(newX * col + newY);
                                }
                            }
                        }
                    }
                }
            }

            return res;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < row && y >= 0 && y < col;
        }
    }
}
