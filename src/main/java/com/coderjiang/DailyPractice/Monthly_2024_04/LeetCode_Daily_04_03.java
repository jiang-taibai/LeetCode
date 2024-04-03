package com.coderjiang.DailyPractice.Monthly_2024_04;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2024/4/3</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_03 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (cloned == null) return null;
            if (cloned.val == target.val) return cloned;
            TreeNode lhs = getTargetCopy(original, cloned.left, target);
            if (lhs != null) return lhs;
            return getTargetCopy(original, cloned.right, target);
        }
    }

}
