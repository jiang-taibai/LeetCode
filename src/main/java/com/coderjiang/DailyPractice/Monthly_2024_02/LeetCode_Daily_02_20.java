package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2024-02-20</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_20 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] preorder, inorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            return dfs(0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) return null;
            TreeNode root = new TreeNode(this.preorder[preLeft]);
            if (preLeft == preRight || inLeft == inRight) return root;
            int rootIndexInInorder = inRight + 1;
            for (int i = inLeft; i <= inRight; i++) {
                if (this.inorder[i] == this.preorder[preLeft]) {
                    rootIndexInInorder = i;
                    break;
                }
            }
            int leftSubTreeNodeLength = rootIndexInInorder - inLeft;
            root.left = dfs(preLeft + 1, preLeft + leftSubTreeNodeLength, inLeft, rootIndexInInorder - 1);
            root.right = dfs(preLeft + leftSubTreeNodeLength + 1, preRight, rootIndexInInorder + 1, inRight);
            return root;
        }
    }

}
