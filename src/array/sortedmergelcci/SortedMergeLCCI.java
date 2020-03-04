package array.sortedmergelcci;

/**
 * 面试题 10.01
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.

 Initially the number of elements in A and B are m and n respectively.

 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * Created by Michael Allan on 2020/3/3.
 */
public class SortedMergeLCCI {
    public static void main(String[] args) {

    }

    private class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int newLen = m + n;
            int k = newLen - 1;
            for (int i = m - 1, j = n - 1; i > -1 && j > -1;) {
                if (A[i] > B[j]) {
                    A[k--] = A[i--];
                }else {
                    A[k--] = B[j--];
                }
            }
        }
    }
}
