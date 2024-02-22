package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2024-02-22</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_22 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] preorder, postorder;
        private final Map<Integer, Integer> preIndex = new HashMap<>(), postIndex = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            this.preorder = preorder;
            this.postorder = postorder;
            for (int i = 0; i < preorder.length; i++) {
                preIndex.put(preorder[i], i);
                postIndex.put(postorder[i], i);
            }
            return dfs(0, preorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode dfs(int preL, int preR, int postL, int postR) {
            if (preL > preR || postL > postR) return null;
            TreeNode node = new TreeNode(this.preorder[preL]);
            if (preL == preR || postL == postR) return node;
            // 至少有一个子节点
            // 如果该节点有两个子节点：
            if (this.preorder[preL + 1] != this.postorder[postR - 1]) {
                int lhs = this.preorder[preL + 1];
                int rhs = this.postorder[postR - 1];
                node.left = dfs(preL + 1, this.preIndex.get(rhs) - 1, postL, this.postIndex.get(lhs));
                node.right = dfs(this.preIndex.get(rhs), preR, this.postIndex.get(lhs) + 1, postR - 1);
            }
            // 如果只有一个节点，默认放在左子节点上
            else {
                node.left = dfs(preL + 1, preR, postL, postR - 1);
            }
            return node;
        }
    }

}
