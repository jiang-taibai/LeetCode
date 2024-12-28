package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-29 00:09:15</p>
 */
public class DailyPractice_20241229 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class Candidate {
            char name;
            int[] tickets;

            Candidate(char name, int size) {
                this.name = name;
                this.tickets = new int[size];
            }
        }

        public String rankTeams(String[] votes) {
            ArrayList<Candidate> candidates = new ArrayList<>();
            Map<Character, Candidate> map = new HashMap<>();
            int n = votes[0].length();
            for (char c : votes[0].toCharArray()) {
                Candidate candidate = new Candidate(c, n);
                candidates.add(candidate);
                map.put(c, candidate);
            }
            for (String vote : votes) {
                char[] chars = vote.toCharArray();
                for (int i = 0; i < n; i++) {
                    map.get(chars[i]).tickets[i]++;
                }
            }
            candidates.sort((a, b) -> {
                for (int i = 0; i < n; i++) {
                    if (a.tickets[i] != b.tickets[i]) return b.tickets[i] - a.tickets[i];
                }
                return a.name - b.name;
            });
            StringBuilder sb = new StringBuilder();
            for (Candidate candidate : candidates) {
                sb.append(candidate.name);
            }
            return sb.toString();
        }
    }

}
