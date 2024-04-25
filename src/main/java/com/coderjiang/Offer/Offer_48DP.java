package com.coderjiang.Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-12-12 15:17:59</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_48DP {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> preIndexes = new HashMap<>();
            int maxLength = 0;
            int dp = 0;
            int index = 0;
            for (char c : s.toCharArray()) {
                int preIndex = preIndexes.getOrDefault(c, -1);
                preIndexes.put(c, index);
                dp = dp < index - preIndex ? dp + 1 : index - preIndex;
                maxLength = Math.max(maxLength, dp);
                index++;
            }
            return maxLength;
        }
    }

}
