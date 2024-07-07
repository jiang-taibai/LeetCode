package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-07 15:02:43</p>
 */
public class T11_栈_二叉树的中序遍历 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
            return res;
        }
    }

}
