package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 03/05/2025 15:44
 * @Version : V1.0
 * @Description :
 */
public class CheapestFlightsWithinKStops787 {

//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        int[] dp = new int[n];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[src] = 0;
//
//        for (int i = 0; i <= k; i++) {
//            int[] temp = Arrays.copyOf(dp, n);
//            for (int[] flight : flights) {
//                if (dp[flight[0]] != Integer.MAX_VALUE) {
//                    temp[flight[1]] = Math.min(temp[flight[1]], dp[flight[0]] + flight[2]);
//                }
//            }
//            dp = temp;
//        }
//
//        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
//    }
    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };
        CheapestFlightsWithinKStops787 cheapestFlightsWithinKStops787 = new CheapestFlightsWithinKStops787();
        System.out.println(cheapestFlightsWithinKStops787.findCheapestPrice(4, array, 0, 3, 1));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode]) continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
