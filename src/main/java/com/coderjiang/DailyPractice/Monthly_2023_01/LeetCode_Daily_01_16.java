package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-16 12:23:39</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_16 {

    // 时间O(n^2)，空间O(n)
    static class Solution_1 {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] words1 = sentence1.split(" ");
            String[] words2 = sentence2.split(" ");
            if (words1.length < words2.length) return areSentencesSimilarAfterAdd(words1, words2);
            else return areSentencesSimilarAfterAdd(words2, words1);
        }

        private boolean areSentencesSimilarAfterAdd(final String[] words1, final String[] words2) {
            // words1.length < words2.length
            // add in words1
            int n1 = words1.length, n2 = words2.length;
            for (int i = -1; i < n1; ++i) {
                if (i >= 0 && !words1[i].equals(words2[i])) return false;
                boolean match = true;
                for (int j = n1 - 1; j > i; --j) {
                    if (!words1[j].equals(words2[n2 + j - n1])) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
            return false;
        }
    }

    // 双指针法，T=O(n)，S=O(n)
    static class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] words1 = sentence1.split(" ");
            String[] words2 = sentence2.split(" ");
            if (words1.length < words2.length) return cmp(words1, words2);
            else return cmp(words2, words1);
        }

        private boolean cmp(String[] words1, String[] words2) {
            int n1 = words1.length, n2 = words2.length, i = 0, j = n1 - 1;
            while (i < n1 && i < n2 && words1[i].equals(words2[i])) ++i;
            while (j >= i && words1[j].equals(words2[n2 + j - n1])) --j;
            return i + (n1 - j - 1) == Math.min(n1, n2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] tests = {
                {"My name is Haley", "My Haley"},
                {"of", "A lot of words"},
                {"Eating right now", "Eating"},
                {"Lucy", "Luccccy"},
                {"xD iP tqchblXgqvNVdi", "FmtdCzv Gp YZf UYJ xD iP tqchblXgqvNVdi"},
                {"b b", "b"},
        };
        for (String[] test : tests) {
            System.out.printf("[%b]: \"%s\" \"%s\"\n", solution.areSentencesSimilar(test[0], test[1]), test[0], test[1]);
        }
    }

}
