package binarysearch.findinmountainarray;

/**
 * 1095. Find in Mountain Array
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array/
 * Created by Michael Allan on 2020/4/29.
 */
public class FindinMountainArray {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int mountainTop = findMountainTop(0, mountainArr.length() - 1, mountainArr);
            int res = findLeftRoad(0, mountainTop, target, mountainArr);
            if (res != -1) {
                return res;
            }
            return findRightRoad(mountainTop + 1, mountainArr.length() - 1, target, mountainArr);
        }

        private int findRightRoad(int low, int high, int target, MountainArray mountainArr) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mountainArr.get(mid) > target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (mountainArr.get(low) == target) {
                return low;
            }
            return -1;
        }

        private int findLeftRoad(int low, int high, int target, MountainArray mountainArr) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mountainArr.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (mountainArr.get(low) == target) {
                return low;
            }
            return -1;
        }

        private int findMountainTop(int low, int high, MountainArray mountainArr) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                // 取左中位数，因为进入循环，数组一定至少有 2 个元素
                // 因此，左中位数一定有右边元素，数组下标不会发生越界：mid + 1
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }
    }

    interface MountainArray {
        public int get(int index);
        public int length();
    }
}
