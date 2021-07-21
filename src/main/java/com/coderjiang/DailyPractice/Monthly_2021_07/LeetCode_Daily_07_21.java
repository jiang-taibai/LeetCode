package com.coderjiang.DailyPractice.Monthly_2021_07;



import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Creation Time: 2021-07-20 08:35:55</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_21 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            ListNode cur = headA;
            while (cur != null) {
                set.add(cur);
                cur = cur.next;
            }
            cur = headB;
            while (cur != null) {
                if (set.contains(cur)) break;
                cur = cur.next;
            }
            return cur;
        }

        public ListNode getIntersectionNode_TowPoint(ListNode headA, ListNode headB) {
            ListNode pa = headA, pb = headB;
            while (pa != pb) {
                pa = pa == null ? headB : pa.next;
                pb = pb == null ? headA : pb.next;
            }
            return pa;
        }
    }

}
