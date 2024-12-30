package com.coderjiang.DailyPractice.Monthly_2024_12;

import com.coderjiang.LeetCodeUtil.ListNode;
import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-30 10:26:49</p>
 */
public class DailyPractice_20241230 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public boolean isSubPath(ListNode head, TreeNode root) {
            if (root == null) return false;
            boolean res = false;
            if (head.val == root.val) {
                res = check(head, root);
            }
            return res || isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        private boolean check(ListNode head, TreeNode root) {
            if (head == null) return true;
            if (root == null) return false;
            if (head.val != root.val) return false;
            return check(head.next, root.left) || check(head.next, root.right);
        }
    }

}
