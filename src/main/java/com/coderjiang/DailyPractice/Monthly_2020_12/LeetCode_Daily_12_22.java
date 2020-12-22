package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/22 12:54
 * @description: TODO
 */
public class LeetCode_Daily_12_22 {
    public static void main(String[] args) {

    }
    //Definition for a binary tree node.
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            List<List<Integer>> res = new LinkedList<List<Integer>>();
            if(root==null) return res;
            boolean lr = true;
            deque.add(root);
            while(!deque.isEmpty()) {
                Deque son = new LinkedList<TreeNode>();
                List<Integer> line = new LinkedList<Integer>();
                while(!deque.isEmpty()) {
                    TreeNode treeNode = deque.pollFirst();
                    if(treeNode.left != null) {
                        son.add(treeNode.left);
                    }
                    if(treeNode.right != null) {
                        son.add(treeNode.right);
                    }
                    line.add(treeNode.val);
                }
                deque=son;
                if(!lr) {
                    Collections.reverse(line);
                }
                res.add(line);
                lr = !lr;
            }
            return res;
        }
    }
}
