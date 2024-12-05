package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 05/12/2024 21:46
 * @Version : V1.0
 * @Description :
 */
public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        int[] degrees = new int[numCourses];
        for (int[] edge : prerequisites){
            int parent = edge[1];
            int child = edge[0];
            edges.get(parent).add(child);
            degrees[child] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (degrees[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            Integer parent = queue.poll();
            answer.offer(parent);
            for (int child : edges.get(parent)){
                degrees[child] -= 1;
                if (degrees[child] == 0) queue.offer(child);
            }
        }
        return (answer.size() == numCourses)? answer.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
