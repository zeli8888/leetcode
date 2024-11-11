package exercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            List<TreeNode> parent;
            List<TreeNode> child;
            public TreeNode() {}
        }
        TreeNode[] nodes = new TreeNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new TreeNode();
        }
        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[0]].parent.add(nodes[prerequisite[1]]);
            nodes[prerequisite[1]].child.add(nodes[prerequisite[0]]);
        }
        Stack<TreeNode> rootNodes = null;
        for (int i = 0; i < numCourses; i++) {
            rootNodes = new Stack<>();
            if (nodes[i].parent == null) {
                rootNodes.push(nodes[i]);
            }
        }
        if (rootNodes == null) {
            return false;
        }
        while (!rootNodes.isEmpty()) {
            TreeNode node = rootNodes.pop();
            Set<TreeNode> childNodes = new HashSet<>();
            Stack<TreeNode> loopNodes = new Stack<TreeNode>();
            loopNodes.push(node);
            while (!loopNodes.isEmpty()) {
                TreeNode loopNode = loopNodes.pop();
                if (loopNode.child == null) {
                    continue;
                }
                for (TreeNode childNode : loopNode.child) {
                    if (childNodes.contains(childNode)){
                        return false;
                    }
                    childNodes.add(childNode);
                    loopNodes.push(childNode);
                }
            }
        }
        return true;
    }
}
