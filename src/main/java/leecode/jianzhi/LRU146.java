package leecode.jianzhi;

import java.util.HashMap;

public class LRU146 {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size;
    HashMap<Integer, Node> map;
    Node head;

    Node tail;

    public LRU146(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node res = map.getOrDefault(key, null);
        if (res != null) {
            moveToFirst(res);
            return res.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (!map.containsKey(key)) { //不存在该值
            Node node = new Node(key, value);
            addFirst(node);
            if (size > capacity) {
                removeLast();
            }

        } else {// 存在此值
            Node node = map.get(key);
            node.value = value;
            moveToFirst(node);
        }


    }

    void moveToFirst(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    void removeLast() {
        map.remove(tail.pre.key);
        Node removeNode = tail.pre;
        removeNode.pre.next = removeNode.next;
        removeNode.next.pre = removeNode.pre;

        size--;
    }

    void addFirst(Node node) {
        size++;
        map.put(node.key,node);
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
}
