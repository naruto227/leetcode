package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Allan on 2021/1/31.
 */
public class SetTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}});
        System.out.println(Arrays.toString(res));
    }

    private static class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            int[] res = new int[adjacentPairs.length + 1];
            Map<Integer, Integer> hashmap = new HashMap();
            for (int i = 0; i < adjacentPairs.length; i++) {
                for (int j = 0; j < 2; j++) {
                    hashmap.put(adjacentPairs[i][j], hashmap.getOrDefault(adjacentPairs[i][j], 0) + 1);
                }
            }
            int[] output = new int[2];
            int idx = 0;
            for (Map.Entry<Integer, Integer> item : hashmap.entrySet())
                if (item.getValue() == 1) output[idx++] = item.getKey();
            res[0] = output[0];
            res[res.length - 1] = output[1];

            boolean[][] visited = new boolean[adjacentPairs.length][2];
            int curIndex = 0;
            int curVal = res[0];
            while (curIndex != res.length - 1) {
                for (int i = 0; i < adjacentPairs.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (adjacentPairs[i][j] == curVal) {
                            visited[i][j] = true;
                            if (j == 0 && !visited[i][j + 1]) {
                                curVal = res[++curIndex] = adjacentPairs[i][j + 1];
                                visited[i][j + 1] = true;
                            } else if (j == 1 && !visited[i][j - 1]) {
                                curVal = res[++curIndex] = adjacentPairs[i][j - 1];
                                visited[i][j - 1] = true;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
