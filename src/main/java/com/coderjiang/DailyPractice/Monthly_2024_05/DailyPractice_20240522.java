package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-22 05:24:20</p>
 */
public class DailyPractice_20240522 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            Set<Integer> ids = new HashSet<>();
            Map<Integer, Integer> counts = new HashMap<>();
            for (int[] match : matches) {
                int winner = match[0], loser = match[1];
                ids.add(winner);
                ids.add(loser);
                counts.put(loser, counts.getOrDefault(loser, 0) + 1);
            }
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            res.add(new ArrayList<>());
            for (Integer id : Arrays.stream(ids.toArray()).sorted().mapToInt(i -> (int) i).toArray()) {
                if (!counts.containsKey(id)) res.get(0).add(id);
                else if (counts.get(id) == 1) {
                    res.get(1).add(id);
                }
            }
            return res;
        }
    }

}
