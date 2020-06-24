package array.threesumclosest;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Created by Michael Allan on 2020/6/24.
 */
public class ThreeSumClosest {
    public static void main(String[] args) throws IOException {
        ThreeSumClosest closest = new ThreeSumClosest();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int threeSumClosest = closest.threeSumClosest1(ArrayUtil.stringToIntegerArray(line), Integer.valueOf(br.readLine()));
            System.out.println(threeSumClosest);
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int df = target - sum;
                    if(df < diff) {
                        diff = df;
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int end = len - 1;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < end; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = end;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    int temp = right - 1;
                    while (temp > left && nums[temp] == nums[right]) {
                        temp--;
                    }
                    right = temp;
                }else if (sum < target) {
                    int temp = left + 1;
                    while (temp < right && nums[temp] == nums[left]) {
                        temp++;
                    }
                    left = temp;
                }
            }
        }

        return ans;
    }
}
