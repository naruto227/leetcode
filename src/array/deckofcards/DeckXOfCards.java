package array.deckofcards;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * Created by Michael Allan on 2020/3/27.
 */
public class DeckXOfCards {
    public static void main(String[] args) throws IOException {
//        System.out.println(gcd(0, 6));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] deck = ArrayUtil.stringToIntegerArray(line);
            boolean hasGroupsSizeX = new Solution().hasGroupsSizeX(deck);
            System.out.println(hasGroupsSizeX);
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int[] counter = new int[10000];
            int max = 0;
            int min = 10000;
            for (int num : deck) {
                counter[num]++;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            boolean has = true;
            int x = counter[min];

            for (int i = min; i <= max; i++) {
                if (counter[i] == 1) {
                    has = false;
                    break;
                }
                if (counter[i] > 1) {
                    x = gcd(x, counter[i]);
                    if(x == 1) {
                        has = false;
                        break;
                    }
                }
            }
            return has;
        }

        public boolean hasGroupsSizeX1(int[] deck) {
            // 计数
            int[] counter = new int[10000];
            for (int num: deck) {
                counter[num]++;
            }
            // 迭代求多个数的最大公约数
            int x = 0;
            for(int cnt: counter) {
                if (cnt > 0) {
                    x = gcd(x, cnt);
                    if (x == 1) { // 如果某步中gcd是1，直接返回false
                        return false;
                    }
                }
            }
            return x >= 2;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
