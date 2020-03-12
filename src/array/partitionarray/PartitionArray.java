package array.partitionarray;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1013
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

 Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])

 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * Created by Michael Allan on 2020/3/11.
 */
public class PartitionArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] arr = ArrayUtil.stringToIntegerArray(line);
            boolean feasibility = new Solution().canThreePartsEqualSum1(arr);
            System.out.println(feasibility);
        }
    }

    private static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            if(sum % 3 != 0) {
                return false;
            }
            int avg = sum / 3;
            int slow = 0;
            int fast = A.length - 1;
            int leftSum = A[slow];
            int rightSum = A[fast];
            boolean res = false;
            while (slow < fast) {
                if(leftSum != avg) {
                    leftSum += A[++slow];
                }
                if(rightSum != avg) {
                    rightSum += A[--fast];
                }
                if(leftSum == avg && rightSum == avg) {
                    res = true;
                    break;
                }
            }

            return res && (slow + 1) < fast;
        }

        public boolean canThreePartsEqualSum1(int[] A) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            if(sum % 3 != 0) {
                return false;
            }
            int avg = sum / 3;
            int i = 0;
            int curSum = A[i];
            int end = A.length - 1;
            while (i < end) {
                if(curSum == avg) {
                    break;
                }
                curSum += A[++i];
            }
            if(curSum != avg) {
                return false;
            }
            int j = i + 1;
            curSum = A[j];
            while (j < end) {
                if(curSum == avg) {
                    return true;
                }
                curSum += A[++j];
            }

            return false;
        }
    }

}
