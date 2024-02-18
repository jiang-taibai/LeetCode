package com.coderjiang.DailyPractice.Monthly_2024_02;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Creation Time: 2024-02-18</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_18 {

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

        private final List<Integer> res = new LinkedList<>();

        public List<Integer> preorder(Node root) {
            dfs(root);
            return res;
        }

        private void dfs(Node root) {
            if (root == null) return;
            res.add(root.val);
            root.children.forEach(this::dfs);
        }
    }

}
