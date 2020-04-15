package bfsdfs.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * 链接：https://leetcode-cn.com/problems/01-matrix/
 * Created by Michael Allan on 2020/4/15.
 */
public class Matrix {
    /**
     * 使用多源BFS解法
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < direction.length; i++) {
                int row = x + direction[i][0];
                int col = y + direction[i][1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    matrix[row][col] = 1 + matrix[x][y];
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        return matrix;
    }
}
