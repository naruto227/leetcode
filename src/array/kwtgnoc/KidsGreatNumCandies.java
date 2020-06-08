package array.kwtgnoc;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 * Created by Michael Allan on 2020/6/1.
 */
public class KidsGreatNumCandies {
    public static void main(String[] args) throws IOException {
        Solution solution = new KidsGreatNumCandies().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            List<Boolean> res = solution.kidsWithCandies(ArrayUtil.stringToIntegerArray(line), Integer.parseInt(br.readLine()));
            System.out.println(res);
        }
    }

    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> res = new ArrayList<>();
            int max = 0;
            for (int candie : candies) {
                max = Math.max(max, candie);
            }

            for (int candie : candies) {
                res.add(candie + extraCandies >= max);
            }
            return res;
        }
    }
}
