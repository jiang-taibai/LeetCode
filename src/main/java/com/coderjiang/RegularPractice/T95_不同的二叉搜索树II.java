package com.coderjiang.RegularPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2023-03-13 16:51:24</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T95_不同的二叉搜索树II {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int l, int r) {
            if (r < l) {
                List<TreeNode> res = new ArrayList<>();
                res.add(null);
                return res;
            }
            List<TreeNode> res = new ArrayList<>(), leftSubTrees, rightSubTrees;
            for (int i = l; i <= r; ++i) {
                leftSubTrees = generateTrees(l, i - 1);
                rightSubTrees = generateTrees(i + 1, r);

                for (TreeNode leftSubTree : leftSubTrees) {
                    for (TreeNode rightSubTree : rightSubTrees) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = leftSubTree;
                        treeNode.right = rightSubTree;
                        res.add(treeNode);
                    }
                }
            }
            return res;
        }

    }

}
