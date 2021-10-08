package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.*;

/**
 * <p>Creation Time: 2021-10-08 21:51:41</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_08 {

    class Solution {

        private List<String> res = new ArrayList<>();

        public List<String> findRepeatedDnaSequences(String s) {
            char[] dna = s.toCharArray();
            TireTree tireTree = new TireTree();
            for (int i = 0; i < dna.length - 10; ++i) {
                tireTree.insert(dna, i);
            }
            return res;
        }

        class TireTree {
            TireTree root;
            int cnt = 0;
            Map<Character, TireTree> next = new HashMap<>();

            public void insert(char[] s, int l) {
                if (root == null) root = new TireTree();
                TireTree cur = root;
                for (int i = l; i < l + 10; ++i) {
                    if (!cur.next.containsKey(s[i])) cur.next.put(s[i], new TireTree());
                    cur = cur.next.get(s[i]);
                }
                cur.cnt++;
                System.out.println(String.valueOf(s, l, 10));
                System.out.println(cur.cnt);
                if (cur.cnt == 2) res.add(String.valueOf(s, l, 10));
            }
        }

    }


}
