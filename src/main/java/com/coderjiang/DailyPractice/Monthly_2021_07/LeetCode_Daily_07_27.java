package com.coderjiang.DailyPractice.Monthly_2021_07;



import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Creation Time: 2021-07-27 15:51:44</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_27 {

    class Solution {

        private final Set<Integer> set = new TreeSet<>();

        public int findSecondMinimumValue(TreeNode root) {
            dfs(root);
            if (set.size() <= 1) return -1;
            List<Integer> list = new ArrayList<>(set);
            return list.get(1);
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            set.add(root.val);
            if (root.left == null || root.right == null) return;
            dfs(root.left);
            dfs(root.right);
        }
    }

}
