package array.mergeintervals;

import java.util.*;

/**
 * 56. Merge Intervals
 * 链接：https://leetcode-cn.com/problems/merge-intervals/
 * Created by Michael Allan on 2020/4/16.
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] merge = new MergeIntervals().merge1(new int[][]{{2,6},{8,10},{6,18}});
//        int[][] merge = new MergeIntervals().merge1(new int[][]{{1, 4}, {4, 5}});
//        int[][] merge = new MergeIntervals().merge1(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        String deepToString = Arrays.deepToString(merge);
        System.out.println(deepToString);
    }

    public int[][] merge(int[][] intervals) {
        // 存储合并后的元素
        List<int[]> list = new ArrayList<>();
        for (int[] area : intervals) {
            // 因为在迭代的过程中有删除操作，所以需要使用listIterator
            ListIterator<int[]> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int[] element = listIterator.next();
                // 判断是否存在相交区域
                if (hasIntersection(area, element)) {
                    // 相交时，则先将element从集合中删除，再做合并，取(min(x0, x1)，max(y0, y1))，新的元素重新放入集合中
                    listIterator.remove();
                    area[0] = Math.min(area[0], element[0]);
                    area[1] = Math.max(area[1], element[1]);
                }
            }
            listIterator.add(area);
        }
        // 将list转化为数组
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * 判断两个区域是否有交集，同相交矩阵思想，投影法。两个点(x0,y0)、(x1,y1)，若存在相交部分，
     * 则有max(x0, x1) <= min(y0, y1)
     * @param area
     * @param element
     * @return 存在则返回true
     */
    private boolean hasIntersection(int[] area, int[] element) {
        return Math.max(area[0], element[0]) <= Math.min(area[1], element[1]);
    }

    public int[][] merge1(int[][] intervals) {
        // 按区间起始位置进行排序，升序
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] area : intervals) {
            // 没有相交的部分
            if (index == -1 || res[index][1] < area[0]) {
                res[++index] = area;
            } else {
                // 有相交的部分，取大者res[index][1] = max(area[1], res[index][1])
                res[index][1] = Math.max(area[1], res[index][1]);
            }
        }
        // res的初始化行的长度为intervals.length，合并后只有index + 1个
        return Arrays.copyOf(res, index + 1);
    }
}
