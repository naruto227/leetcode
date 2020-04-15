package dynamicpro.matrix;

import java.util.Arrays;

/**
 * 542. 01 Matrix
 * 链接：https://leetcode-cn.com/problems/01-matrix/
 * 用dp解法比bfs解法快解释：
 * BFS使用队列，比如本文使用LinkedList，每次入队出队都有Node对象的创建和操作等开销；
 * BFS中对matrix中的元素是随机访问的话，无法利用cpu的局部缓存，而dp是有序访问，可以利用cpu缓存来加速。
 * Created by Michael Allan on 2020/4/16.
 */
public class Matrix {
    /**
     * 动态规划解法
     * 假设某个位置[i][j]，从左上方开始查找，从第0行，第1行……，直到第i-1行第j-1列的位置，能够找到[i][j]
     * 的上方及左边部分的最优解；
     * 从右下方开始查找，从第[m-1][n-1]位置开始，m-1行，m-2行……，直到第i-1行第j-1列的位置，能够找到[i][j]
     * 的下方及右边部分的最优解；综合两者的最优解，即得到了最优解。
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // 初始化动态数组，matrix[i][j]=0时，dp[i][j]=0;matrix[i][j]=1时，dp[i][j]=10000，设置其为最大可能值;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (matrix[i][j] == 0) ? 0 : 10000;
            }
        }
        // 左上方，从第一个位置开始。比较dp[i-1][j]，dp[i][j-1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                }
            }
        }
        // 右下方，从最后一个位置开始。比较dp[i+1][j]，dp[i][j+1]
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n -1; j >= 0; j--) {
                if (i + 1 < m) {
                    // 综合二者的最优解，得到最优的结果
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        int[][] updateMatrix = new Matrix().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        String deepToString = Arrays.deepToString(updateMatrix);
        System.out.println(deepToString);
    }
}
