package com.coderjiang.DailyPractice.Monthly_2025_04;

import com.coderjiang.LeetCodeUtil.Pair;
import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-04 11:49:53</p>
 */
public class DailyPractice_20250404 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root).getKey();
        }

        private Pair<TreeNode, Integer> dfs(TreeNode root) {
            if (root == null) {
                return new Pair<>(null, 0);
            }
            Pair<TreeNode, Integer> left = dfs(root.left), right = dfs(root.right);
            if (left.getValue() > right.getValue()) {
                return new Pair<>(left.getKey(), left.getValue() + 1);
            } else if (left.getValue() < right.getValue()) {
                return new Pair<>(right.getKey(), right.getValue() + 1);
            } else {
                return new Pair<>(root, left.getValue() + 1);
            }
        }
    }

}
