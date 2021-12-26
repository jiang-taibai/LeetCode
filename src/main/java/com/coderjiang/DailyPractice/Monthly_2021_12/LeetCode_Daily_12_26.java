package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2021-12-26 23:14:32</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_26 {

    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] words = text.split(" ");
            int n = words.length;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n - 2; ++i) {
                if (words[i].equals(first) && words[i + 1].equals(second)) {
                    list.add(words[i + 2]);
                }
            }
            return list.toArray(new String[list.size()]);
        }
    }

}
