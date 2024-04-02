package com.coderjiang.DailyPractice.Monthly_2024_04;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>Creation Time: 2024/4/2</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_02 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final HashMap<Integer, List<TreeNode>> memo = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int n) {
            if(memo.containsKey(n)) return memo.get(n);
            n--;
            List<TreeNode> result = new ArrayList<>();
            if (n == 0) {
                result.add(new TreeNode(0));
                return result;
            }
            for (int i = 1; i <= n - 1; i += 2) {
                List<TreeNode> leftResult = allPossibleFBT(i);
                List<TreeNode> rightResult = allPossibleFBT(n - i);
                for (TreeNode lhs : leftResult) {
                    for (TreeNode rhs : rightResult) {
                        TreeNode root = new TreeNode(0);
                        root.left = lhs;
                        root.right = rhs;
                        result.add(root);
                    }
                }
            }
            memo.put(n, result);
            return result;
        }

    }

}
