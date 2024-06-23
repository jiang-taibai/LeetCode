package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-24 00:41:10</p>
 */
public class T50_滑动窗口_重复的DNA序列 {

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() <= 10) return res;
            Set<Integer> set = new HashSet<>();
            Set<String> sequences = new HashSet<>();
            int hashcode = 0;
            for (int i = 0; i < 10; i++) {
                hashcode <<= 2;
                hashcode += dnaCode(s.charAt(i));
            }
            set.add(hashcode);
            int highFactor = 1 << 18;
            for (int i = 10; i < s.length(); i++) {
                hashcode -= highFactor * dnaCode(s.charAt(i - 10));
                hashcode <<= 2;
                hashcode += dnaCode(s.charAt(i));
                if (set.contains(hashcode)) {
                    sequences.add(s.substring(i - 9, i + 1));
                }
//                System.out.printf("%s: %d\n", s.substring(i - 9, i + 1), hashcode);
                set.add(hashcode);
            }
            return new ArrayList<>(sequences);
        }

        private int dnaCode(char c) {
            switch (c) {
                case 'A':
                    return 0;
                case 'C':
                    return 1;
                case 'G':
                    return 2;
                case 'T':
                    return 3;
            }
            return -1;
        }
    }

}
