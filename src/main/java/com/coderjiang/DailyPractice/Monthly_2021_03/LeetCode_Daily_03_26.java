package com.coderjiang.DailyPractice.Monthly_2021_03;

import com.coderjiang.LeetCodeUtil.ListNode;

/**
 * <p>创建时间：2021/3/26 9:17</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_26 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode preNode = null;
            ListNode curNode = head;
            while (curNode != null) {
                if (preNode != null && preNode.val == curNode.val) {
                    preNode.next = curNode.next;
                } else {
                    preNode = curNode;
                }
                curNode = curNode.next;
            }
            return head;
        }
    }

}
