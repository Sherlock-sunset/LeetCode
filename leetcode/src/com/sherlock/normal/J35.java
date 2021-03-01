package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class J35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node copyHead = new Node(head.val);

            Node node = head;
            Node copyNode = copyHead;
            List<Node> nodes = new ArrayList<>();
            List<Node> copies = new ArrayList<>();
            while (node != null) {
                nodes.add(node);
                copies.add(copyNode);
                if (node.next != null) {
                    copyNode.next = new Node(node.next.val);
                }
                if (node.random != null) {
                    if (node.random == node)
                        copyNode.random = copyNode;
                    else if (node.random == node.next)
                        copyNode.random = copyNode.next;
//                    else
//                        copyNode.random = new Node(node.random.val);
                }
                node = node.next;
                copyNode = copyNode.next;
            }

            node = head;
            copyNode = copyHead;
            while (node != null) {

                if (node.random != null && node.random != node && node.random != node.next) {
                    copyNode.random = copies.get(nodes.indexOf(node.random));
                }
                node = node.next;
                copyNode = copyNode.next;
            }
            return copyHead;
        }


    }
}
