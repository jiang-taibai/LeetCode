package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-25 09:28:50</p>
 */
public class DailyPractice_20240925 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long distinctNames(String[] ideas) {
            List<Set<String>> ideaPosts = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                ideaPosts.add(new HashSet<>());
            }
            for (String idea : ideas) {
                int index = idea.charAt(0) - 'a';
                String post = idea.substring(1);
                ideaPosts.get(index).add(post);
            }
            long res = 0;
            for (int i = 0; i < 26; i++) {
                if(ideaPosts.get(i).isEmpty()) continue;
                Set<String> postLeft = ideaPosts.get(i);
                for (int j = 0; j < 26; j++) {
                    if(ideaPosts.get(j).isEmpty()) continue;
                    Set<String> postRight = ideaPosts.get(j);
                    long uniqueLeft = postLeft.size();
                    long uniqueRight = postRight.size();
                    for (String post : postLeft) {
                        if(postRight.contains(post)) {
                            uniqueLeft--;
                            uniqueRight--;
                        }
                    }
                    res += uniqueLeft * uniqueRight;
                }
            }
            return res;
        }
    }

}
