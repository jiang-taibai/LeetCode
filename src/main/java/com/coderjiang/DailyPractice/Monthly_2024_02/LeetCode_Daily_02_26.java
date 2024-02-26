package com.coderjiang.DailyPractice.Monthly_2024_02;

import com.coderjiang.LeetCodeUtil.TreeNode;


/**
 * <p>Creation Time: 2024/2/26</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_26 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            boolean inRange = low <= root.val && root.val <= high;
            int res = inRange ? root.val : 0;
            if (inRange || root.val < low) res += rangeSumBST(root.right, low, high);
            if (inRange || root.val > high) res += rangeSumBST(root.left, low, high);
            return res;
        }

    }

}
