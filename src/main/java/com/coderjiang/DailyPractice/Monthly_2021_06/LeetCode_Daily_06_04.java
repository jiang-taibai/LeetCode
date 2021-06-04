package com.coderjiang.DailyPractice.Monthly_2021_06;


import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>创建时间：2021/6/4 12:39</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_06_04 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            ListNode node = headA;
            while (node != null) {
                set.add(node);
                node = node.next;
            }
            node = headB;
            while (node != null) {
                if (set.contains(node)) return node;
                node = node.next;
            }
            return null;
        }
    }

}
