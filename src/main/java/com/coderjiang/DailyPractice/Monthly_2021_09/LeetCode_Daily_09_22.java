package com.coderjiang.DailyPractice.Monthly_2021_09;


import com.coderjiang.LeetCodeUtil.ListNode;

/**
 * <p>Creation Time: 2021-09-22 10:39:56</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_22 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode[] res = new ListNode[k];
            if (head == null) return res;
            ListNode cur = head;
            int cnt = 0;
            while (cur != null) {
                cur = cur.next;
                cnt++;
            }
            int perPartLength = cnt / k;
            int leftPart = cnt % k; // 左边部分意思是这部分要比右边多一个
            cur = head;
            ListNode pre = null;
            for (int i = 0; i < leftPart; ++i) {
                res[i] = cur;
                for (int j = 0; j < perPartLength + 1; ++j) {
                    pre = cur;
                    cur = cur.next;
                }
                pre.next = null;
            }
            for (int i = leftPart; i < k; ++i) {
                res[i] = cur;
                for (int j = 0; j < perPartLength; ++j) {
                    pre = cur;
                    cur = cur.next;
                }
                pre.next = null;
            }
            return res;
        }
    }

}
