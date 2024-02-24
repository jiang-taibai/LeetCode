package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Creation Time: 2024-02-24</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_24 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private Integer[] values;
        private int n = 0;

        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> valsList = new ArrayList<>();
            dfs(root, valsList);
            values = valsList.toArray(new Integer[0]);
            n = values.length;
            for (Integer query : queries) {
                List<Integer> arr = new ArrayList<>(2);
                arr.add(findMaxMin(query));
                arr.add(findMinMax(query));
                res.add(arr);
            }
            return res;
        }

        private void dfs(TreeNode root, List<Integer> valsList) {
            if (root == null) return;
            dfs(root.left, valsList);
            valsList.add(root.val);
            dfs(root.right, valsList);
        }

        private int findMaxMin(int target) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (values[mid] == target) return target;
                else if (values[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return values[l];
        }

        private int findMinMax(int target) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (values[mid] == target) return target;
                else if (values[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return values[r];
        }

    }

}
