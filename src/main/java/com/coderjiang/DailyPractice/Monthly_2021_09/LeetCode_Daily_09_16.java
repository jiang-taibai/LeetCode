package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.*;

/**
 * <p>Creation Time: 2021-09-16 08:42:18</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_16 {

    class Solution {

        public List<String> findWords(char[][] board, String[] words) {
            Tire tire = new Tire();
            for (String word : words) {
                tire.insert(tire, word);
            }
            Set<String> set = new HashSet<>();
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    dfs(board, tire, i, j, set);
                }
            }
            return new ArrayList<>(set);
        }

        private void dfs(char[][] board, Tire now, int i, int j, Set<String> set) {
            char ch = board[i][j];
            if (!now.next.containsKey(ch)) return;
            now = now.next.get(ch);
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            if (!now.word.equals("")) set.add(now.word);
            board[i][j] = '#';
            for (int[] direction : directions) {
                int i2 = i + direction[0];
                int j2 = j + direction[1];
                if (i2 >= 0 && j2 >= 0 && i2 < board.length && j2 < board[i2].length) {
                    dfs(board, now, i2, j2, set);
                }
            }
            board[i][j] = ch;
        }

        class Tire {
            public String word = "";
            public Map<Character, Tire> next = new HashMap<>();

            private void insert(Tire root, String word) {
                Tire cur = root;
                for (char c : word.toCharArray()) {
                    if (!cur.next.containsKey(c)) cur.next.put(c, new Tire());
                    cur = cur.next.get(c);
                }
                cur.word = word;
            }
        }
    }

}
