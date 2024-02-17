package com.coderjiang.DailyPractice.Monthly_2024_02;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Creation Time: 2024-02-17</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_17 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class Node {
            public int val;
            public List<Node> children;

            public Node() {
            }

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, List<Node> _children) {
                val = _val;
                children = _children;
            }
        }

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            Queue<Node> cur = new LinkedList<>();
            cur.add(root);
            while (!cur.isEmpty()) {
                Queue<Node> next = new LinkedList<>();
                List<Integer> list = new LinkedList<>();
                while (!cur.isEmpty()) {
                    Node node = cur.poll();
                    list.add(node.val);
                    if (node.children != null) {
                        next.addAll(node.children);
                    }
                }
                cur = next;
                res.add(list);
            }
            return res;
        }
    }

}
