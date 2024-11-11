package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 11/11/2024 13:24
 * @Version : V1.0
 * @Description :
 */
public class CourseSchedule207 {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(new CourseSchedule207().canFinish(numCourses, prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int counter = 0;
        if (numCourses <= 0) {
            return true;
        }

        // Initialize inDegree array and adjacency list
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and update inDegree for each node
        for (int[] edge : prerequisites) {
            int parent = edge[1];
            int child = edge[0];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        // Initialize the queue with courses having no prerequisites (inDegree = 0)
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                sources.offer(i);
            }
        }

        // Process nodes with no prerequisites
        while (!sources.isEmpty()) {
            int course = sources.poll(); // dequeue
            counter++;

            // Process all the children of the current course
            for (int child : graph.get(course)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    sources.offer(child); // enqueue child if inDegree becomes 0
                }
            }
        }
        // If we processed all courses, return true
        return counter == numCourses;
    }
}
