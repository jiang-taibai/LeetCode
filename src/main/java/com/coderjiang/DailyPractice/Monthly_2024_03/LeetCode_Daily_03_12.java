package com.coderjiang.DailyPractice.Monthly_2024_03;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2024/3/12</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_12 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        FindElements findElements = new FindElements(root);
    }

    static class FindElements {

        private final TreeNode root;

        private TreeNode node;

        public FindElements(TreeNode root) {
            this.root = root;
        }

        public boolean find(int target) {
            if (target == 0) {
                node = root;
                return true;
            }
            // 自底向上
            boolean resultOfFindFather = find((target + 1) / 2 - 1);
            if (resultOfFindFather) {
                if ((target & 1) == 0 && node.right != null) {
                    node = node.right;
                    return true;
                } else if ((target & 1) == 1 && node.left != null) {
                    node = node.left;
                    return true;
                }
            }
            return false;
        }
    }

}
/*
     0
   1   2
  3 4 5 6
 7 8
 */
