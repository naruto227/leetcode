package array.surfaceareaof3Dshapes;

/**
 * 892. Surface Area of 3D Shapes
 * On a N * N grid, we place some 1 * 1 * 1 cubes.

 Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

 Return the total surface area of the resulting shapes.

 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * Created by Michael Allan on 2020/3/25.
 */
public class SurfaceAreaof3DShapes {
    public static void main(String[] args) {
       int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
//        int[][] grid = {{1,0},{0,2}};
        int surfaceArea = new Solution().surfaceArea(grid);
        System.out.println(surfaceArea);
    }

    static class Solution {
        public int surfaceArea(int[][] grid) {
            int total = 0;
            int overlap = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int val = grid[i][j];
                    if (val == 0) {
                        continue;
                    }
                    total += val * 4 + 2;
                    if (j + 1 < grid[i].length && grid[i][j + 1] > 0) {
                        overlap += Math.min(grid[i][j], grid[i][j + 1]);
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] > 0) {
                        overlap += Math.min(grid[i][j], grid[i + 1][j]);
                    }
                }
            }
            return total - overlap * 2;
        }
    }
}
