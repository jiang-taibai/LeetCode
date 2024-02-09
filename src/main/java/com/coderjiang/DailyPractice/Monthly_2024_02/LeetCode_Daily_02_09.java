package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2024-02-09</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_09 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(solution.lowestCommonAncestor(root, q, p).val);
    }

    static class Solution {

        private final List<TreeNode> pPath = new ArrayList<>();
        private final List<TreeNode> qPath = new ArrayList<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, pPath, p);
            dfs(root, qPath, q);
            int pPathSize = pPath.size(), qPathSize = qPath.size();
            for (int i = 0; i < Math.min(pPathSize, qPathSize); i++) {
                if (pPath.get(pPathSize - i - 1).val != qPath.get(qPathSize - i - 1).val) {
                    return pPath.get(pPathSize - i);
                }
            }
            if (pPath.size() < qPath.size()) return p;
            else return q;
        }

        private boolean dfs(TreeNode root, List<TreeNode> path, TreeNode target) {
            if (root == null) return false;
            if (root.val == target.val) {
                path.add(root);
                return true;
            }
            boolean exist = dfs(root.left, path, target);
            exist = exist || dfs(root.right, path, target);
            if (exist) path.add(root);
            return exist;
        }
    }

    static class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null && right == null) return null;
            else if (left != null && right == null) return left;
            else if (left == null && right != null) return right;
            else if (left != null && right != null) return root;
            else return root;
        }
    }

}
