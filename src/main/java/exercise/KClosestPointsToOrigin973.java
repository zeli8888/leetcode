package exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author : Ze Li
 * @Date : 06/06/2025 00:27
 * @Version : V1.0
 * @Description :
 */
public class KClosestPointsToOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
    //we will declare a maxheap which will sort the points in descending order on the basis of distance,
    //i.e., max distance point would be at top, and we will maintain only k elements in the heap, if heap is having more elements than k, then we will pop out, like that max distance point would be removed from heap,
    //and heap will have only k closest points from origin
    //here we are finding distance by x*x + y*y
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
    //we will add value in heap, and if heap is having more elements than k, then we will pop out
    //This loop will run n times, and add and poll operation in PQ will take log k TC, as k eleements are there in PQ, So total TC is O(nlogk), SC: O(k) as k eleements are there in PQ,
    for(int[] num: points){
        maxHeap.add(num);
        //check if heap size > k, we will pop
        if(maxHeap.size() > k) maxHeap.poll();
    }
    int[][] result = new int[k][2]; //our result array
    //Now as we now heap is having k closest points, we will store all points in our result
    int i=0;
    while(maxHeap.isEmpty() == false){
        result[i++] = maxHeap.poll();
    }
    return result;
    }
//    public int[][] kClosest(int[][] points, int k) {
//        return Arrays.stream(points).sorted(Comparator.comparing(point -> point[0]*point[0] + point[1]*point[1])).limit(k).toArray(int[][]::new);
//    }
}
