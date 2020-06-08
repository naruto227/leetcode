package uf.soee;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 990
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * Created by Michael Allan on 2020/6/8.
 */
public class SatisfiabilityEqualityEquations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            Solution solution = new SatisfiabilityEqualityEquations().new Solution();
            String[] strArr = ArrayUtil.stringToStrArray(line);
            boolean equationsPossible = solution.equationsPossible(strArr);
            System.out.println(equationsPossible);
        }
    }

    class Solution {
        private int[] parent = new int[26];
        private int[] rank = new int[26];

        public Solution() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 如：["a==b","b!=a"] false
         * @param equations
         * @return
         */
        public boolean equationsPossible(String[] equations) {
            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    int p = equation.charAt(0) - 'a';
                    int q = equation.charAt(3) - 'a';
                    if (p != q) {
                        unionElements(p, q);
                    }
                }
            }

            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    int p = equation.charAt(0) - 'a';
                    int q = equation.charAt(3) - 'a';
                    if (find(p) == find(q)) {
                        return false;
                    }
                }
            }

            return true;
        }

        private void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (rank[pRoot] < rank[qRoot]) {
                // p所在联通分量的根节点指向q所在联通分量的根节点，这样两个联通分量就连接到一起了，p和q自然也就联通了
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }

        }

        private int find(int p) {
            if(p < 0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");
            while (parent[p] != p) {
                // 路径压缩，本来p指向其父亲，现在指向其爷爷
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            
            return p;
        }
    }
}
