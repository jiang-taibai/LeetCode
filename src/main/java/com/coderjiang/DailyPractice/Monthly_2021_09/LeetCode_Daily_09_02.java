package com.coderjiang.DailyPractice.Monthly_2021_09;



import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Creation Time: 2021-09-02 20:35:05</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_02 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd_slow(ListNode head, int k) {
            Queue<ListNode> nodes = new LinkedList<>();
            while (head != null) {
                nodes.offer(head);
                if (nodes.size() > k) nodes.poll();
                head = head.next;
            }
            return nodes.poll();
        }

        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            while (k-- >= 0) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

}
