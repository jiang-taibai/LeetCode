package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-10-19 11:25:45</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_19 {

    class WordDictionary {

        private WordDictionary root;
        private Map<Character, WordDictionary> next;
        private boolean end;

        public WordDictionary() {
            next = new HashMap<>();
            end = false;
        }

        public void addWord(String word) {
            if (root == null) {
                root = new WordDictionary();
            }
            char[] arr = word.toCharArray();
            WordDictionary cur = root;
            for (char c : arr) {
                if (!cur.next.containsKey(c)) cur.next.put(c, new WordDictionary());
                cur = cur.next.get(c);
            }
            cur.end = true;
        }

        public boolean search(String word) {
            if (root == null) return false;
            char[] arr = word.toCharArray();
            return dfs(arr, 0, root);
        }

        private boolean dfs(char[] arr, int index, WordDictionary root) {
            if (index >= arr.length) {
                return root.end;
            }
            if (arr[index] == '.') {
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (root.next.containsKey(c) && dfs(arr, index + 1, root.next.get(c))) return true;
                }
                return false;
            } else {
                if (!root.next.containsKey(arr[index])) return false;
                return dfs(arr, index + 1, root.next.get(arr[index]));
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
