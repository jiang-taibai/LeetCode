package com.coderjiang.DailyPractice.Monthly_2024_01;

import java.util.*;

/**
 * <p>Creation Time: 2024-01-29</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_01_29 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ring = "godding", key = "godding";
        int result = solution.findRotateSteps(ring, key);
        System.out.println(result);
    }

    static class Solution {

        private String ring;
        private String key;
        private final HashMap<Character, List<Integer>> map = new HashMap<>();
        private int[][] memo;

        public int findRotateSteps(String ring, String key) {
            this.ring = ring;
            this.key = key;
            char[] ringCharArray = ring.toCharArray();
            for (int i = 0; i < ringCharArray.length; i++) {
                char ringChar = ringCharArray[i];
                List<Integer> list = map.getOrDefault(ringChar, new LinkedList<>());
                list.add(i);
                map.put(ringChar, list);
            }
            this.memo = new int[ring.length() + 1][key.length() + 1];
            return dfs(0, 0);
        }

        private int getBetterTargetIndexDistance(int ringIndex, int targetIndex) {
            // 不超越边界的正反转
            int dis1 = Math.abs(ringIndex - targetIndex);
            // ring 突破上边界，回到起点的转动
            int dis2 = Math.abs(targetIndex + ring.length() - ringIndex);
            // ring 突破下边界，回到终点的转动
            int dis3 = Math.abs(ringIndex + ring.length() - targetIndex);
            return Math.min(dis1, Math.min(dis2, dis3));
        }

        private int dfs(int ringIndex, int keyIndex) {
            if (keyIndex >= this.key.length()) return 0;
            if (this.memo[ringIndex][keyIndex] != 0) return this.memo[ringIndex][keyIndex];
            List<Integer> list = this.map.get(this.key.charAt(keyIndex));
            int minResult = 0xfffffff;
            for (Integer targetIndex : list) {
                int minDis = this.getBetterTargetIndexDistance(ringIndex, targetIndex);
                int result = minDis + 1 + dfs(targetIndex, keyIndex + 1);
                minResult = Math.min(result, minResult);
            }
            return this.memo[ringIndex][keyIndex] = minResult;
        }
    }

}
