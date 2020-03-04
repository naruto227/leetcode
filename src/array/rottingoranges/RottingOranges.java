package array.rottingoranges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * <p>
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * Created by Michael Allan on 2020/3/4.
 */
public class RottingOranges {
    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};
        int res = new Solution().orangesRotting(grid);
        System.out.println(res);
    }

    private static class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            int M = grid.length;
            int N = grid[0].length;
            int count = 0;
            for (int row = 0; row < M; row++) {
                for (int column = 0; column < N; column++) {
                    if (grid[row][column] == 1) {
                        count++;
                    }
                    if (grid[row][column] == 2) {
                        queue.add(new int[]{row, column});
                    }
                }
            }

            int[] dx = {0, 0, -1, 1};
            int[] dy = {1, -1, 0, 0};
            int round = 0;
            while (count > 0 && !queue.isEmpty()) {
                round++;
                int num = queue.size();
                for (int i = 0; i < num; i++) {
                    int[] rotRange = queue.poll();
                    for (int index = 0; index < 4; index++) {
                        int row = rotRange[0] + dx[index];
                        int column = rotRange[1] + dy[index];
                        if (row >= 0 && row < M && column >= 0 && column < N && grid[row][column] == 1) {
                            grid[row][column] = 2;
                            count--;
                            queue.add(new int[]{row, column});
                        }
                    }
                }
            }
            if (count > 0) {
                return -1;
            } else {
                return round;
            }
        }
    }
}
