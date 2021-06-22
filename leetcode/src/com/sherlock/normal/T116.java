package com.sherlock.normal;

import com.sherlock.data_structure.Node;

import java.util.HashMap;

public class T116 {
    public Node connect(Node root) {
        HashMap<Integer, Node> preNodes = new HashMap<>();
        levelOrder(root, 0, preNodes);
        return root;
    }

    public void levelOrder(Node root, int level, HashMap<Integer, Node> preNodes) {
        if (root == null) return;
        Node pre = preNodes.getOrDefault(level, null);
        if (pre != null) pre.next = root;
        preNodes.put(level, root);
        levelOrder(root.left, level + 1, preNodes);
        levelOrder(root.right, level + 1, preNodes);
    }
}
