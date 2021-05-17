package com.coderjiang.DailyPractice.Monthly_2021_05;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>创建时间：2021/5/17 23:46</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_17 {

    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            return bfs(root, x, y);
        }

        public boolean dfs(TreeNode root, int x, int y) {
            if (root != null) {
                if (root.left != null && root.right != null) {
                    if ((root.left.val == x && root.right.val == y) ||
                            (root.right.val == x && root.left.val == y)) {
                        return true;
                    }
                }
                return dfs(root.left, x, y) || dfs(root.right, x, y);
            }
            return false;
        }

        public boolean bfs(TreeNode root, int x, int y) {
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            boolean hadFind = false;
            while (!que.isEmpty()) {
                Queue<TreeNode> next = new LinkedList<>();
                while (!que.isEmpty()) {
                    TreeNode node = que.poll();
                    if (node.left != null) {
                        if (node.left.val == x || node.left.val == y) hadFind = true;
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        if (node.right.val == x || node.right.val == y) hadFind = true;
                        if (hadFind) {
                            if (node.left != null) {
                                if ((node.right.val == x && node.left.val == y) || (node.right.val == y && node.left.val == x)) {
                                    return false;
                                }
                            }
                        }
                        next.add(node.right);
                    }
                }

                que = next;
                if (hadFind) {
                    // 如果找到了，那么不存在则返回false
                    boolean flag = false;
                    for (TreeNode treeNode : next) {
                        if (treeNode.val == x || treeNode.val == y) {
                            if (flag) return true;
                            flag = true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }

}
