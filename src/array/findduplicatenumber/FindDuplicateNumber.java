package array.findduplicatenumber;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/5/26.
 */
public class FindDuplicateNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Solution solution = new FindDuplicateNumber().new Solution();
        while ((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int duplicate = solution.findDuplicate(nums);
            System.out.println(duplicate);
        }
    }

    class Solution {
        public int findDuplicate(int[] nums) {
            int slowRunner = 0;
            int fastRunner = 0;
            do{
                slowRunner = nums[slowRunner];
                fastRunner = nums[nums[fastRunner]];
            }while (slowRunner != fastRunner);

            slowRunner = 0;
            while (slowRunner != fastRunner) {
                slowRunner = nums[slowRunner];
                fastRunner = nums[fastRunner];
            }

            return fastRunner;
        }
    }
}
