package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-03 15:01:31</p>
 */
public class TB0_搜索_二叉树的最大深度 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

}
