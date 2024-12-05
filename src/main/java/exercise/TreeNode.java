package exercise;

import java.util.*;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
     public TreeNode(Object[] array){
         Queue<Object> nodes = new LinkedList<>();
         this.val = (int) array[0];
         nodes.add(this);
         int i = 1;
         while (i < array.length){
             Object object = nodes.poll();
             if (object == null) {
                 i += 2;
                 if (i >= array.length) break;
                 continue;
             }

             TreeNode node = (TreeNode) object;
             object = array[i];
             if (object != null){
                 node.left = new TreeNode((int) object);
                 nodes.add(node.left);
             }else {
                 nodes.add(null);
             }
             i++;
             if (i == array.length) break;

             object = array[i];
             if (object != null){
                 node.right = new TreeNode((int) object);
                 nodes.add(node.right);
             }else {
                 nodes.add(null);
             }
             i++;
             if (i == array.length) break;
         }
     }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.val);
        buffer.append('\n');
        List<TreeNode> children = new ArrayList<>(List.of());
        if (this.left != null) children.add(this.left);
        if (this.left == null && this.right != null){
            buffer.append(childrenPrefix + "├── null \n");
        }

        if (this.right != null) children.add(this.right);
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
        // doesn't look good with noting right is null
//        if (this.left != null && this.right == null){
//            buffer.append(childrenPrefix + "└── null \n");
//        }
    }
 }
