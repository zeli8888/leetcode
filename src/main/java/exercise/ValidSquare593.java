package exercise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author : Ze Li
 * @Date : 15/07/2025 23:04
 * @Version : V1.0
 * @Description :
 */
public class ValidSquare593 {
    public static void main(String[] args) {
        Solution solution = new ValidSquare593().new Solution();
        System.out.println(solution.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}));
    }
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            HashSet<Double> distanceSet = new HashSet<>();
            distanceSet.add(calculateDis(p1,p2));
            distanceSet.add(calculateDis(p1,p3));
            distanceSet.add(calculateDis(p1,p4));
            distanceSet.add(calculateDis(p2,p3));
            distanceSet.add(calculateDis(p2,p4));
            distanceSet.add(calculateDis(p3,p4));
            if (distanceSet.size() != 2) return false;
            List<Double> distanceList = new ArrayList<>(distanceSet);
            distanceList.sort(Comparator.naturalOrder());
            return  distanceList.get(1) == 2 * distanceList.get(0);
        }

        private double calculateDis(int[] p1, int[] p2) {
            return Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2);
        }
    }
}
