package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>创建时间：2021/5/10 10:45</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_10 {


    public class TreeNode {
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
            getLeafList(root1, list1);
            getLeafList(root2, list2);
            return isSameList(list1, list2);
        }

        void getLeafList(TreeNode root, List<Integer> list) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            if (root.left != null) {
                getLeafList(root.left, list);
            }
            if (root.right != null) {
                getLeafList(root.right, list);
            }
        }

        boolean isSameList(List<Integer> l1, List<Integer> l2) {
            if (l1.size() != l2.size()) return false;
            for (int i = 0; i < l1.size(); i++) {
                if (l1.get(i) != l2.get(i)) return false;
            }
            return true;
        }
    }

}
