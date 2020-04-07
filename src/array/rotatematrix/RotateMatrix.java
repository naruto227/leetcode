package array.rotatematrix;

import java.util.Arrays;

/**
 * 面试题 01.07. Rotate Matrix LCCI
 * Created by Michael Allan on 2020/4/7.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = { {1,2,3}, {4,5,6}, {7,8,9} };
//        int[][] matrix = { { 5, 1, 9,11}, { 2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16} };
        System.out.println(Arrays.deepToString(matrix));
        new Solution().rotate1(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int N = matrix.length;
            int[][] copyArr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copyArr[i][j] = matrix[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int row = j;
                    int col = N - 1 - i;
                    matrix[row][col] = copyArr[i][j];
                }
            }
        }
        // 该方法有问题
        public void rotate1(int[][] matrix) {
            int N = matrix.length;
            if(N == 0) {
                return;
            }
            /**存储前一个状态的值*/
            int i = 0;
            int j = 0;
            int prev = matrix[0][0];
            /**存储被替换状态的值，作为下一次更新的值使用*/
            int row;
            int col;
            int cur;
            int total = N*N;
            while (total-- != 0) {
                row = j;
                col = N - 1 - i;

                cur = matrix[row][col];
                matrix[row][col] = prev;

                i = row;
                j = col;
                prev = cur;
            }
        }
    }
}
