package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-25 01:32:03</p>
 */
public class T60_链表_两数相加 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode cur = res;
            int upper = 0;
            while (l1 != null && l2 != null) {
                int num = l1.val + l2.val + upper;
                upper = num / 10;
                num %= 10;
                cur.next = new ListNode(num);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int num = l1.val + upper;
                upper = num / 10;
                num %= 10;
                cur.next = new ListNode(num);
                cur = cur.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int num = l2.val + upper;
                upper = num / 10;
                num %= 10;
                cur.next = new ListNode(num);
                cur = cur.next;
                l2 = l2.next;
            }
            if(upper!=0) {
                cur.next = new ListNode(upper);
            }
            return res.next;
        }
    }

}
