package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 07/01/2025 13:19
 * @Version : V1.0
 * @Description :
 */
public class LRUCache146 {
    class Node{
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node oldest;
    private Node latest;

    public LRUCache146(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.oldest = new Node(0, 0);
        this.latest = new Node(0, 0);
        this.oldest.next = this.latest;
        this.latest.pre = this.oldest;
    }

    private void remove(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void add(Node node){
        Node newest = this.latest.pre;
        newest.next = node;
        node.pre = newest;
        node.next = this.latest;
        this.latest.pre = node;
    }


    public int get(int key) {
        if (!this.cache.containsKey(key)){
            return -1;
        }
        Node node = this.cache.get(key);
        this.remove(node);
        this.add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.remove(this.cache.get(key));
        }
        Node node = new Node(key, value);
        this.add(node);
        this.cache.put(key, node);
        if (this.cache.size() > this.cap){
            Node nodeOldest = this.oldest.next;
            this.remove(nodeOldest);
            this.cache.remove(nodeOldest.key);
        }
    }
}
