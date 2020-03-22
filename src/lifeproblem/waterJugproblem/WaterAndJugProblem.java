package lifeproblem.waterJugproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 365. Water and Jug Problem
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

 If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

 Operations allowed:

 Fill any of the jugs completely with water.
 Empty any of the jugs.
 Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.

 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * Created by Michael Allan on 2020/3/21.
 */
public class WaterAndJugProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int x = Integer.valueOf(line);
            int y = Integer.valueOf(br.readLine());
            int z = Integer.valueOf(br.readLine());
            Solution solution = new Solution();
            int gcd = solution.gcd(x, y);
            boolean canMeasureWater = solution.canMeasureWater(x, y, z);
            System.out.println(gcd + "\t" + canMeasureWater);
        }
    }
    static class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if(z > x + y) return false;
            if(x == 0 || y == 0)
                return z == 0 || x + y == z;
            return z % gcd(x, y) == 0;
        }

        private int gcd(int x, int y) {
            while(y != 0) {
                int temp = x % y;
                x = y;
                y = temp;
            }
            return x;
        }
    }
}
