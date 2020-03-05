package array.distributecandies;

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
    public static void main(String[] args) {
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
    }

    private  static class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] arr = new int[num_people];
            int row = 0;
            int col = 0;
            int remain = 0;
            while(candies > 0) {
                for (int i = 0; i < num_people; i++) {
                    if(candies <= 0) {
                        col = i;
                        remain = candies + i + row * num_people + 1;
                        break;
                    }
                    candies -= (i + row * num_people + 1);
                }
                if(candies > 0) {
                    row++;
                }
            }

            for (int i = 0; i < col - 1; i++) {

            }
            return arr;
        }
    }
}
