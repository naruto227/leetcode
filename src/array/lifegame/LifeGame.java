package array.lifegame;

/**
 * 链接：https://leetcode-cn.com/problems/game-of-life/solution/sheng-ming-you-xi-by-leetcode-solution/
 */
public class LifeGame {
    public static void main(String[] args) {

    }

    static class Solution {
        public void gameOfLife1(int[][] board) {
            int[] neighbors = {0, 1, -1};

            int rows = board.length;
            int cols = board[0].length;
            // 复制一份数组，保留原始状态
            int[][] copyBoard = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    copyBoard[i][j] = board[i][j];
                }
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    // 统计相邻的活细胞数量
                    int liveNeighbors = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                                int r = row + neighbors[i];
                                int c = col + neighbors[j];

                                if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                    liveNeighbors++;
                                }
                            }
                        }
                    }

                    if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                        board[row][col] = 0;
                    }

                    if((copyBoard[row][col] == 0) && (liveNeighbors == 3)) {
                        board[row][col] = 1;
                    }
                }
            }
        }
    }
}
