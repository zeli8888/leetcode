package exercise;

import java.util.Hashtable;

/**
 * @Author : Ze Li
 * @Date : 04/01/2025 12:55
 * @Version : V1.0
 * @Description :
 */
public class DegreeOfAnArray697 {
    public static void main(String[] args) {
        int[] ints = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        DegreeOfAnArray697 degreeOfAnArray697 = new DegreeOfAnArray697();
        System.out.println(degreeOfAnArray697.findShortestSubArray(ints));
    }
    public int findShortestSubArray(int[] nums) {
        Hashtable<Integer, Integer> count = new Hashtable<>();
        Hashtable<Integer, Integer> start = new Hashtable<>();
        Hashtable<Integer, Integer> end = new Hashtable<>();
        int maxOccur = 0;
        int maxOccurNum = -1;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (start.containsKey(num)){
                count.put(num, count.get(num)+1);
                end.put(num, i);
            }else{
                start.put(num, i);
                end.put(num, i);
                count.put(num, 1);
            }
            if (count.get(num) > maxOccur ||
                    (count.get(num) == maxOccur && end.get(num) - start.get(num) < end.get(maxOccurNum) - start.get(maxOccurNum))
            ) {
                maxOccur = count.get(num);
                maxOccurNum = num;
            }
        }
        return end.get(maxOccurNum) - start.get(maxOccurNum) + 1;
    }
}
