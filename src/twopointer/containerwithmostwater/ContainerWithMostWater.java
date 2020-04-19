package twopointer.containerwithmostwater;

/**
 * 11. Container With Most Water
 * 链接：https://leetcode-cn.com/problems/container-with-most-water/
 * Created by Michael Allan on 2020/4/19.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while(i < j) {
            res = Math.max(res, calculate(i, j, height));
            if (height[i] <= height[j]) {
                i++;
            }else {
                j--;
            }
            // System.out.println("i = " + i + ", j = " + j + ", res = " + res);
        }
        return res;
    }

    private int calculate(int i, int j, int[] height) {
        return (j - i) * Math.min(height[i], height[j]);
    }
}
