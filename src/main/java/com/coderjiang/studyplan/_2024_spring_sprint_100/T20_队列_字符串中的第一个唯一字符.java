package com.coderjiang.StudyPlan._2024_spring_sprint_100;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-21 17:54:38</p>
 */
public class T20_队列_字符串中的第一个唯一字符 {

    static class Solution {
        public int firstUniqChar(String s) {
            int[] count = new int[300];
            for (char c : s.toCharArray()) {
                count[(int) c]++;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (count[(int) c] == 1) return i;
            }
            return -1;
        }
    }

}
