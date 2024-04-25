package com.coderjiang.Offer;

import com.coderjiang.LeetCodeUtil.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Creation Time: 2021-12-04 20:11:23</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_35 {

    class Solution {
        public Node copyRandomList_bad(Node head) {
            if (head == null) return null;
            Map<Node, Integer> map = new HashMap<>();
            List<Node> nodes = new ArrayList<>();
            Node cur = head;
            int index = 0;
            while (cur != null) {
                nodes.add(new Node(cur.val));
                if (index != 0) nodes.get(index - 1).next = nodes.get(index);
                map.put(cur, index++);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    nodes.get(map.get(cur)).random = nodes.get(map.get(cur.random));
                }
                cur = cur.next;
            }
            return nodes.get(0);
        }

        private Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            else if (!map.containsKey(head)) {
                Node node = new Node(head.val);
                map.put(head, node);
                node.next = copyRandomList(head.next);
                node.random = copyRandomList(head.random);
            }
            return map.get(head);
        }
    }

}
