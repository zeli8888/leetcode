package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 11/11/2024 13:24
 * @Version : V1.0
 * @Description :
 */
public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        class TreeNode {
//            many parents, many children
            TreeNode parent;
            TreeNode child;

            public TreeNode() {
            }
        }
        TreeNode[] nodes = new TreeNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new TreeNode();
        }
        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[0]].parent = nodes[prerequisite[1]];
            nodes[prerequisite[1]].child = nodes[prerequisite[0]];
        }
        Stack<TreeNode> rootNodes = null;
        for (int i = 0; i < numCourses; i++) {
            rootNodes = new Stack<>();
            if (nodes[i].parent == null) {
                rootNodes.push(nodes[i]);
            }
        }
        if (rootNodes.isEmpty()) {
            return false;
        }
        while (!rootNodes.isEmpty()) {
            TreeNode node = rootNodes.pop();

        }
    }
}
