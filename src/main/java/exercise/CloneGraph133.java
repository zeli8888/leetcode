package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 15/03/2025 23:29
 * @Version : V1.0
 * @Description :
 */
public class CloneGraph133 {
    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Integer, Node> cloneMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if (cloneMap.containsKey(node.val)) {
            return cloneMap.get(node.val);
        }

        Node copy = new Node(node.val);
        cloneMap.putIfAbsent(copy.val, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }

//    public Node cloneGraph(Node node) {
//        if (node == null){
//            return null;
//        }
//        Node[] copiedNodes = new Node[100];
//        Node copiedNode = new Node(node.val);
//        copiedNodes[node.val-1] = copiedNode;
//        cloneGraph(node, copiedNode, copiedNodes);
//        return copiedNode;
//    }
//
//    public void cloneGraph(Node node, Node copiedNode, Node[] copiedNodes) {
//        for (Node neighbor : node.neighbors){
//            if (copiedNodes[neighbor.val-1] == null){
//                Node copiedNeighbor = new Node(neighbor.val);
//                copiedNode.neighbors.add(copiedNeighbor);
//                copiedNodes[neighbor.val-1] = copiedNeighbor;
//                cloneGraph(neighbor, copiedNeighbor, copiedNodes);
//            }else{
//                copiedNode.neighbors.add(copiedNodes[neighbor.val-1]);
//            }
//        }
//    }
}

