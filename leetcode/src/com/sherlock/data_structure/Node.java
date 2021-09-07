package com.sherlock.data_structure;

public class Node {
    public int val;
    public Node next;
    public Node left;
    public Node right;
    public Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node left, Node right) {
        this.val = val;
        this.next = next;
        this.left = left;
        this.right = right;
    }
}
