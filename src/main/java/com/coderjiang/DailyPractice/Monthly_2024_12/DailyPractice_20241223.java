package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-23 11:43:31</p>
 */
public class DailyPractice_20241223 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        class ExamRoom {

            class ListNode {
                private int seat;
                private ListNode pre = null;
                private ListNode next = null;

                private void insert(ListNode node) {
                    node.next = next;
                    node.pre = this;
                    if (next != null) {
                        next.pre = node;
                    }
                    next = node;
                }

                private void remove() {
                    if (pre != null) pre.next = next;
                    if (next != null) next.pre = pre;
                }
            }

            private final ListNode head = new ListNode();
            private final int n;

            public ExamRoom(int n) {
                this.n = n;
            }

            public int seat() {
                ListNode node = new ListNode();
                if (head.next == null) {
                    node.seat = 0;
                    head.insert(node);
                } else {
                    int maxDistance = -1;
                    ListNode target = head.next;
                    ListNode p = head;
                    while (p != null) {
                        int distance = getDistance(p);
                        if (distance > maxDistance) {
                            maxDistance = distance;
                            target = p;
                            if (p == head) {
                                node.seat = 0;
                            } else if (p.next == null) {
                                node.seat = n - 1;
                            } else {
                                node.seat = p.seat + maxDistance;
                            }
                        }
                        p = p.next;
                    }
                    target.insert(node);
                }
//                debug();
                return node.seat;
            }

            private int getDistance(ListNode p) {
                int distance;
                if (p == head) {
                    distance = p.next.seat;
                } else if (p.next == null) {
                    distance = (n - 1) - p.seat;
                } else {
                    // countOfSeats 表示这两个位置之间有多少个位子
                    // 那么如果坐到这两个之间，离自己最近的距离应该是 (countOfSeats+1) / 2
                    int countOfSeats = p.next.seat - p.seat - 1;
                    distance = (countOfSeats + 1) / 2;
                }
                return distance;
            }

            public void leave(int p) {
                ListNode node = head.next;
                while (node != null) {
                    if (node.seat == p) {
                        node.remove();
                        break;
                    }
                    node = node.next;
                }
//                debug();
            }

            private void debug() {
                ListNode node = head.next;
                while (node != null) {
                    System.out.printf("%d,", node.seat);
                    node = node.next;
                }
                System.out.println();
            }
        }
    }

}
