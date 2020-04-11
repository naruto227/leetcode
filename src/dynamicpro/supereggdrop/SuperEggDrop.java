package dynamicpro.supereggdrop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/super-egg-drop/submissions/
 * 参考题解：https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
 * Created by Michael Allan on 2020/4/11.
 */
public class SuperEggDrop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.print("please input K = ");
        while ((line = br.readLine()) != null) {
            int K = Integer.valueOf(line);
            System.out.print("please input N = ");
            int N = Integer.valueOf(br.readLine());
            int superEggDrop = new Solution().superEggDrop(K, N);
            System.out.println(superEggDrop);
            System.out.print("please input K = ");
        }
    }
    static class Solution {
        public int superEggDrop(int K, int N) {
            return getDropStep(K, N);
        }

        /**
         * 状态：求解一个问题所处的阶段
         * dp[i][j]，i表示需要搜索的楼层数，j表示有多少个鸡蛋
         * 推导状态转移方程：
         * 假设从 x 层扔下鸡蛋，分类讨论：
         * 1、鸡蛋碎，那么就应该从 x - 1 层往下找，鸡蛋碎了一个，还剩 j - 1;因此需要求解的结果转化为：dp[x - 1][j - 1]
         * 2、鸡蛋未碎，那么就应该从 [x + 1, j]层之间测试，鸡蛋未碎，仍有 j 个；因此需要求解的结果转化为：dp[i - x][j]
         * 由于题目需要求解的是最坏的情况，取二者的最大值 max(dp[x - 1][j - 1], dp[i - x][j])。
         * x 的取值范围为：[1, i]; 可搜索的情况有 i 种，按题目要求的，至少的结果应该为：min(1 <= x <= i){max(dp[x - 1][j - 1], dp[i - x][j])};
         * 遍历 x 的所有可能性，取最小的结果;
         *
         * 按照以上的思路，时间复杂度为 O(K*N*N)，复杂度较高; 仔细观察状态转移方程：max(dp[x - 1][j - 1], dp[i - x][j])，楼层数 i
         * 越大，结果越大，当 i, j 固定时，dp[x - 1][j - 1]（鸡蛋碎的情况）随 x 单调递增，记为函数：Tb(x)，
         * dp[i - x][j]（鸡蛋未碎的情况）,随 x 单调递减，记为函数：Tnb(x)。实际Tb(x)与Tnb(x)均为离散函数
         * 可以简单绘制草图，大概是一个叉号的图形，假设相交点位 x0，假设靠近 x0 的左边点为：x1，靠近 x0 的右边点为：x2，由上述公式：
         * 分别取 max(Tb(x1), Tnb(x1))（很明显Tnb(x1)更大），max(Tb(x2), Tnb(x2))（很明显Tb(x2)更大），
         * 然后再取二者中的最小值，min（Tnb(x1)，Tb(x2)），得到的小值作为 x。从图形可以看出，其实就是求叉号的上半部分，即 V 形能
         * 得到的最小值（“山谷”）。所以可以使用二分法找到这样的“山谷”
         *
         * @param K 可使用的鸡蛋数
         * @param N 需要搜索的楼层数，
         * @return
         */
        private int getDropStep(int K, int N) {
            int[][] dp = new int[N + 1][K + 1];
            // 由于求的是最小值，因此初始化的时候赋值为一个较大的数，使用楼层数：i
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], i);
            }
            // 初始化：第0行、第1行、第0列、第1列
            dp[1][0] = 0;

            for (int i = 0; i < N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= K; j++) {
                    int low = 1;
                    int high = i;
                    // 此处二分的写法仍需理解，为什么这种写法是可行的呢？
                    while (low < high) {
                        int mid = (low + high + 1) >> 1;
                        int brokenNum = dp[mid - 1][j - 1];
                        int notBrokenNum = dp[i - mid][j];
                        if (brokenNum > notBrokenNum) {
                            high = mid - 1;
                        }else {
                            low = mid;
                        }
                    }

                    dp[i][j] = 1 + Math.max(dp[low - 1][j - 1], dp[i - low][j]);
                }
            }
            return dp[N][K];
        }
    }
}
