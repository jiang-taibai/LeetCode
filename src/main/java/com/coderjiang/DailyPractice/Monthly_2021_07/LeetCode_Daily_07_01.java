package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_Daily_07_01 {

    class Solution {

        private int k;
        private final List<List<Integer>> map = new ArrayList<>();;
        private int n;
        private final Map<Integer, Integer> mark = new HashMap<>();

        public int numWays(int n, int[][] relation, int k) {
            this.k = k;
            this.n = n;
            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }
            for (int[] pair : relation) {
                map.get(pair[0]).add(pair[1]);
            }
            return dfs(0, 0);
        }

        // level初始值为1
        private int dfs(int curIndex, int level) {
            int markIndex = curIndex * 10 + level;
            if(mark.containsKey(markIndex)) {
                return mark.get(markIndex);
            }
            if (level == k) {
                return curIndex == n - 1 ? 1 : 0;
            }
            int res = 0;
            for (Integer next : map.get(curIndex)) {
                res += dfs(next, level + 1);
            }
            mark.put(markIndex, res);
            return res;
        }
    }

}