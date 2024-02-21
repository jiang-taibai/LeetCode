package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2024-02-21</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_21 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] postorder, inorder;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            this.inorder = inorder;
            return dfs(0, postorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode dfs(int postLeft, int postRight, int inLeft, int inRight) {
            if (postLeft > postRight || inLeft > inRight) return null;
            TreeNode root = new TreeNode(this.postorder[postRight]);
            if (postLeft == postRight || inLeft == inRight) return root;
            int rootIndexInInorder = inRight + 1;
            for (int i = inLeft; i <= inRight; i++) {
                if (this.inorder[i] == this.postorder[postRight]) {
                    rootIndexInInorder = i;
                    break;
                }
            }
            int leftSubTreeNodeLength = rootIndexInInorder - inLeft;
            int rightSubTreeNodeLength = inRight - rootIndexInInorder;
            root.left = dfs(postLeft, postLeft + leftSubTreeNodeLength - 1, inLeft, rootIndexInInorder - 1);
            root.right = dfs(postLeft + leftSubTreeNodeLength, postRight - 1, rootIndexInInorder + 1, inRight);
            return root;
        }

    }

}
