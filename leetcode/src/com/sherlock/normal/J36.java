package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class J36 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        List<Node> nodes = new ArrayList<>();
        midOrder(root, nodes);
//        Node head = new Node(0);
//        head.right = nodes.get(0);
        if (nodes.size() == 1) return nodes.get(0);
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0)
                nodes.get(i).left = nodes.get(nodes.size() - 1);
            else
                nodes.get(i).left = nodes.get(i - 1);
            if (i == nodes.size() - 1)
                nodes.get(i).right = nodes.get(0);
            else
                nodes.get(i).right = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    public void midOrder(Node root, List<Node> nodes) {
        if (root == null) return;
        if (root.left != null) midOrder(root.left, nodes);
        nodes.add(root);
        if (root.right != null) midOrder(root.right, nodes);

    }
}
