package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-12 13:19:19</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_48TP {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0, r = 1;
            char[] c = s.toCharArray();
            int maxLength = 1;
            boolean[] exits = new boolean[26];
            exits[c[0] - 'a'] = true;
            while (r < c.length) {
                if (exits[c[r] - 'a']) {
                    do {
                        exits[c[l] - 'a'] = false;
                    } while (c[l++] != c[r]);
                }
                exits[c[r] - 'a'] = true;
                maxLength = Math.max(maxLength, r - l + 1);
            }
            return maxLength;
        }
    }

}
