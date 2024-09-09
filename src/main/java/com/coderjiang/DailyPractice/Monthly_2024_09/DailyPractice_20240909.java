package com.coderjiang.DailyPractice.Monthly_2024_09;

import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-09 14:59:55</p>
 */
public class DailyPractice_20240909 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode p1 = head, p2 = head.next;
            while (p2 != null) {
                int sum = 0;
                while (p2.val != 0) {
                    sum += p2.val;
                    p2 = p2.next;
                }
                p1.val = sum;
                p2 = p2.next;
                if (p2 == null) p1.next = null;
                else p1 = p1.next;
            }
            return head;
        }
    }

}
