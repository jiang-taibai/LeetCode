package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-15 20:45:36</p>
 */
public class DailyPractice_20250715 {

    class Solution {
        public boolean isValid(String word) {
            List<CheckLinkedListNode> checkList = new ArrayList<>();
            checkList.add(new AtLeastThreeCharactersNode());
            checkList.add(new OnlyExistNumberAndLetterNode());
            checkList.add(new AtLeastExistOneVowelLetter());
            checkList.add(new AtLeastExistOneConsonantLetter());
            CheckLinkedListNode head = null;
            CheckLinkedListNode current = null;
            for (CheckLinkedListNode node : checkList) {
                if (head == null) {
                    head = node;
                } else {
                    current.next = node;
                }
                current = node;
            }
            current.next = null;
            current = head;
            while (current != null) {
                System.out.println("正在检查: " + current.desc);
                if (!current.check(word)) {
                    System.out.println("检查失败: " + current.desc);
                    return false;
                }
                current = current.next;
            }
            System.out.println("检查通过");
            return true;
        }
    }

    class CheckLinkedListNode {
        protected String desc;
        protected CheckLinkedListNode next;

        protected boolean check(String word) {
            return true;
        }
    }

    class AtLeastThreeCharactersNode extends CheckLinkedListNode {

        public AtLeastThreeCharactersNode() {
            this.desc = "至少有三个字符";
        }

        @Override
        protected boolean check(String word) {
            return word != null && word.length() >= 3;
        }
    }

    class OnlyExistNumberAndLetterNode extends CheckLinkedListNode {

        public OnlyExistNumberAndLetterNode() {
            this.desc = "只包含数字和字母";
        }

        @Override
        protected boolean check(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            for (char c : word.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    class AtLeastExistOneVowelLetter extends CheckLinkedListNode {
        public AtLeastExistOneVowelLetter() {
            this.desc = "至少包含一个元音字母";
        }

        @Override
        protected boolean check(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            for (char c : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) {
                    return true;
                }
            }
            return false;
        }
    }

    class AtLeastExistOneConsonantLetter extends CheckLinkedListNode {
        public AtLeastExistOneConsonantLetter() {
            this.desc = "至少包含一个辅音字母";
        }

        @Override
        protected boolean check(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            for (char c : word.toLowerCase().toCharArray()) {
                if ("bcdfghjklmnpqrstvwxyz".indexOf(c) >= 0) {
                    return true;
                }
            }
            return false;
        }
    }

}
