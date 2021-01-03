package com.coderjiang.DailyPractice.Monthly_2021_01;


import com.coderjiang.LeetCodeUtil.ListNode;

import java.util.ArrayList;

/**
 * @author 刘江
 * @modifyTime 2021/1/3 17:32
 * @description TODO
 */
public class LeetCode_Daily_01_03 {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ArrayList<Integer> min_arr = new ArrayList<>();
            ArrayList<Integer> max_arr = new ArrayList<>();
            ListNode root = head;
            ListNode curr = head;
            while (curr != null) {
                if(curr.val<x) {
                    min_arr.add(curr.val);
                } else {
                    max_arr.add(curr.val);
                }
                curr = curr.next;
            }
            for(int i=0;i<min_arr.size();++i) {
                head.val = min_arr.get(i);
                head = head.next;
            }
            for(int i=0;i<max_arr.size(); ++i) {
                head.val = max_arr.get(i);
                head = head.next;
            }
            return root;
        }
    }
}