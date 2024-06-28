package com.coderjiang.StudyPlan._2024_spring_sprint_100;


import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-28 22:19:58</p>
 */
public class T90_图_克隆图 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private Map<Integer, Node> memo = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;
            if(memo.containsKey(node.val)) return memo.get(node.val);
            Node clonedNode = new Node(node.val);
            memo.put(node.val, clonedNode);
            for (Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(cloneGraph(neighbor));
            }
            return clonedNode;
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
