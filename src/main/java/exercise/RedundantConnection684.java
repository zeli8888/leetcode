package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 24/08/2025 16:31
 * @Version : V1.0
 * @Description :
 */
public class RedundantConnection684 {
    public static void main(String[] args) {
        Solution solution = new RedundantConnection684().new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 5}, {3, 4}, {3, 5}, {4, 5}, {2, 4}})));
    }
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            par = new int[edges.length+1];
            for (int i = 0; i < par.length; i++)
                par[i] = i;
            for (int[] e : edges)
                if (find(e[0]) == find(e[1])) return e;
                else union(e[0],e[1]);
            return edges[0];
        }
        private int[] par;
        private int find(int x) {
            if (x != par[x]) par[x] = find(par[x]);
            return par[x];
        }
        private void union(int x, int y) {
            par[find(y)] = find(x);
        }
    }
}
