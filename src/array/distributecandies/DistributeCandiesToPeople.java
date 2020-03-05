package array.distributecandies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * We distribute some number of candies, to a row of n = num_people people in the following way:

 We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.

 Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.

 This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).

 Return an array (of length num_people and sum candies) that represents the final distribution of candies.

 链接：https://leetcode-cn.com/problems/distribute-candies-to-people
 * Created by Michael Allan on 2020/3/5.
 */
public class DistributeCandiesToPeople {
    public static void main(String[] args) throws IOException {
        int i = 5;
        while (i > 0) {
            int j = 5;
            for (; j > 0;) {
                if(j == 4) {
                    break;
                }
                System.out.println(j--);
            }
            i--;
            if(i == 3) {
                break;
            }
        }
        System.out.println("end");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int candies = new Integer(line);
            int num_people = new Integer(br.readLine());
            int[] arr = new Solution().distributeCandies(candies, num_people);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private  static class Solution {
        /**
         * 找到倒霉孩子的行号及列号，然后用数学公式计算结果
         * @param candies
         * @param num_people
         * @return
         */
        public int[] distributeCandies(int candies, int num_people) {
            int[] arr = new int[num_people];
            int row = 0;
            int col = 0;
            int remain = 0;
            while(candies > 0) {
                for (int i = 0; i < num_people; i++) {
                    candies -= (i + row * num_people + 1); // 先发糖果
                    if(candies <= 0) {
                        // 找到未发足量的倒霉孩子
                        col = i;
                        remain = candies + i + row * num_people + 1;
                        break;
                    }
                }
                if(candies > 0) {
                    row++;
                }
            }

            for (int i = 0; i < col; i++) {
                arr[i] = (2 * (i + 1) + row * num_people) * (row + 1) / 2;
            }
            arr[col] = (2 * (col + 1) + (row - 1) * num_people) * (row - 1 + 1) / 2 + remain;
            row -= 1; // 上一行
            for (int i = col + 1; i < num_people; i++) {
                arr[i] = (2 * (i + 1) + row * num_people) * (row + 1) / 2;
            }
            return arr;
        }

        public int[] distributeCandies1(int candies, int num_people) {
            int[] arr = new int[num_people];
            int cur = 0;
            while (candies > 0) {
                arr[cur % num_people] += Math.min(candies, ++cur);
                candies -= cur;
            }
            return arr;
        }
    }
}
