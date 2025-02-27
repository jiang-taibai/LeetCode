package com.coderjiang.DailyPractice.Monthly_2025_02;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-27 14:36:54</p>
 */
public class DailyPractice_20250227 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        class TextEditor {

            class CharacterNode {
                char ch;
                CharacterNode prev;
                CharacterNode next;

                CharacterNode(char ch) {
                    this.ch = ch;
                }
            }

            private final CharacterNode head;
            private CharacterNode cursor;

            public TextEditor() {
                head = new CharacterNode('\0');
                cursor = head;
            }

            public void addText(String text) {
                for (char c : text.toCharArray()) {
                    CharacterNode node = new CharacterNode(c);
                    node.next = cursor.next;
                    if (cursor.next != null) {
                        cursor.next.prev = node;
                    }
                    cursor.next = node;
                    node.prev = cursor;
                    cursor = node;
                }
            }

            public int deleteText(int k) {
                int count = 0;
                while (cursor != head && k > 0) {
                    CharacterNode nextNode = cursor.next;
                    cursor = cursor.prev;
                    cursor.next = nextNode;
                    if (nextNode != null) {
                        nextNode.prev = cursor;
                    }
                    count++;
                    k--;
                }
                return count;
            }

            public String cursorLeft(int k) {
                while (cursor != head && k > 0) {
                    cursor = cursor.prev;
                    k--;
                }
                return this.getLeftOfCursorText();
            }

            public String cursorRight(int k) {
                while (cursor.next != null && k > 0) {
                    cursor = cursor.next;
                    k--;
                }
                return this.getLeftOfCursorText();
            }

            private String getLeftOfCursorText() {
                CharacterNode p = cursor;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    if (p == head) break;
                    sb.append(p.ch);
                    p = p.prev;
                }
                return sb.reverse().toString();
            }
        }
    }

}
