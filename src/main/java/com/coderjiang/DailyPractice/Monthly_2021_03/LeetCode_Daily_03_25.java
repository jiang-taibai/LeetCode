package com.coderjiang.DailyPractice.Monthly_2021_03;


import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.*;

/**
 * <p>创建时间：2021/3/25 13:49</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_25 {

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode preNode = null;
            ListNode curNode = head;
            Set<Integer> set = new HashSet<>();
            while (curNode != null) {
                if (preNode != null && preNode.val == curNode.val) {
                    set.add(preNode.val);
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            curNode = head;
            List<ListNode> list = new ArrayList<>();
            while (curNode != null) {
                if (!set.contains(curNode.val)) {
                    list.add(curNode);
                }
                curNode = curNode.next;
            }
            if (list.size() == 0) {
                return null;
            } else {
                for (int i = 0; i < list.size() - 1; ++i) {
                    list.get(i).next = list.get(i + 1).next;
                }
                list.get(list.size() - 1).next = null;
                return list.get(0);
            }
        }
    }

}
