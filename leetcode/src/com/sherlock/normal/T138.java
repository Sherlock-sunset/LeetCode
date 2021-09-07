package com.sherlock.normal;

import com.sherlock.data_structure.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class T138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> indexs = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        Node ans = head;
        int sum = 0;

        // 复制链表但是不管指针
        while (ans != null) {
            nodes.add(new Node(ans.val));
            indexs.put(ans, sum++);
            ans = ans.next;
        }
        //设置指针
        for (int i = 0; i < nodes.size(); i++, head = head.next) {
            Node node = nodes.get(i);
            if (i < nodes.size() - 1) {
                node.next = nodes.get(i + 1);
            }
            if (head.random != null) {
                node.random = nodes.get(indexs.get(head.random));
            }
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }

}
