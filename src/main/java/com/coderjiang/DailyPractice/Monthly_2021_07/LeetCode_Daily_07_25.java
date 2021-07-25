package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Creation Time: 2021-07-25 22:34:13</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_25 {

    class Solution {

        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] adjacentPair : adjacentPairs) {
                int n1 = adjacentPair[0];
                int n2 = adjacentPair[1];
                List<Integer> nearN1 = map.getOrDefault(n1, new ArrayList<>());
                List<Integer> nearN2 = map.getOrDefault(n2, new ArrayList<>());
                nearN1.add(n2);
                nearN2.add(n1);
                map.put(n1, nearN1);
                map.put(n2, nearN2);
            }
            int start = 0;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == 1) {
                    start = entry.getKey();
                    break;
                }
            }
            int pre = start;
            int cur = map.get(pre).get(0);
            List<Integer> nearCur;
            List<Integer> res = new ArrayList<>();
            res.add(start);
            while (true) {
                res.add(cur);
                nearCur = map.get(cur);
                if (nearCur.size() == 1) {
                    break;
                }

                int next = 0;
                if (nearCur.get(0) != pre) {
                    next = nearCur.get(0);
                }
                if (nearCur.get(1) != pre) {
                    next = nearCur.get(1);
                }
                pre = cur;
                cur = next;
            }
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
    }

}
