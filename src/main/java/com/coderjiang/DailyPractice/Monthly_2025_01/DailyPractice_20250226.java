package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-26 19:05:10</p>
 */
public class DailyPractice_20250226 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        class BrowserHistory {

            private HistoryNode historyNode;

            class HistoryNode {
                private String url;
                private HistoryNode prev;
                private HistoryNode next;

                public HistoryNode(String url) {
                    this.url = url;
                    this.prev = null;
                    this.next = null;
                }
            }

            public BrowserHistory(String homepage) {
                this.historyNode = new HistoryNode(homepage);
            }

            public void visit(String url) {
                HistoryNode node = new HistoryNode(url);
                this.historyNode.next = node;
                node.prev = this.historyNode;
                this.historyNode = node;
            }

            public String back(int steps) {
                while (this.historyNode.prev != null && steps > 0) {
                    this.historyNode = this.historyNode.prev;
                    steps--;
                }
                return this.historyNode.url;
            }

            public String forward(int steps) {
                while (this.historyNode.next != null && steps > 0) {
                    this.historyNode = this.historyNode.next;
                    steps--;
                }
                return this.historyNode.url;
            }
        }
    }

}
