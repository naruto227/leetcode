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

        /**
         * 每四项会进入一次循环；枚举矩阵左上角高为 \lfloor n/2 \rfloor⌊n/2⌋，宽为 \lfloor (n+1)/2 \rfloor⌊(n+1)/2⌋ 的子矩阵，保证不重复
         * @param matrix
         */
        public void rotate1(int[][] matrix) {
            int N = matrix.length;
            int row = N >> 1;
            int col = (N + 1) >> 1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[N - 1 - j][i];
                    matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                    matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                    matrix[j][N - 1 - i] = temp;
                }

            }
        }

        // 方法三：由公式：旋转90度结果为：matrix[i][j] --> matrix[j][N - 1 - i]。
        // 等效于：matrix[i][j] -水平轴翻转-> matrix[N - 1 - i][j] -对角线翻转-> matrix[j][N - 1 - i]
    }
}
