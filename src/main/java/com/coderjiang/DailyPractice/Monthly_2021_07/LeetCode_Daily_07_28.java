package com.coderjiang.DailyPractice.Monthly_2021_07;



import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Creation Time: 2021-07-28 10:18:39</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_28 {

    class Solution {

        private Map<Integer, TreeNode> map = new HashMap<>();
        private List<Integer> ans = new ArrayList<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            findFatherOfAllNode(root);
            findNodeInDistance(target, k, -1);
            return ans;
        }

        private void findFatherOfAllNode(TreeNode root) {
            if (root == null) return;
            if (root.left != null) {
                map.put(root.left.val, root);
                findFatherOfAllNode(root.left);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
                findFatherOfAllNode(root.right);
            }
        }

        private void findNodeInDistance(TreeNode root, int restDepth, int from) {
            if (root == null) return;
            if (restDepth == 0) {
                ans.add(root.val);
                return;
            }
            // 三个方向去找
            if (map.containsKey(root.val) && map.get(root.val).val != from) {
                findNodeInDistance(map.get(root.val), restDepth - 1, root.val);
            }
            if (root.left != null && root.left.val != from) {
                findNodeInDistance(root.left, restDepth - 1, root.val);
            }
            if (root.right != null && root.right.val != from) {
                findNodeInDistance(root.right, restDepth - 1, root.val);
            }
        }
    }

}
