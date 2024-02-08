package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Creation Time: 2024-02-08</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_08 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> cur = new LinkedList<>();
            cur.offer(root);
            int level = 0;
            int x_level = -1, y_level = -1;
            int x_father = -1, y_father = -1;
            while (!cur.isEmpty()) {
                Queue<TreeNode> next = new LinkedList<>();
                boolean exist = false;
                while (!cur.isEmpty()) {
                    TreeNode node = cur.poll();
                    if (node.left != null) {
                        next.offer(node.left);
                        if (node.left.val == x) {
                            x_level = level;
                            x_father = node.val;
                        } else if (node.left.val == y) {
                            y_level = level;
                            y_father = node.val;
                        }
                    }
                    if (node.right != null) {
                        next.offer(node.right);
                        if (node.right.val == x) {
                            x_level = level;
                            x_father = node.val;
                        } else if (node.right.val == y) {
                            y_level = level;
                            y_father = node.val;
                        }
                    }
                }
                if (x_level != -1 || y_level != -1) {
                    return x_level == y_level && x_father != y_father;
                }
                level++;
                cur = next;
            }
            return false;
        }
    }

}
