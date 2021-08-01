package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.*;

/**
 * <p>Creation Time: 2021-08-01 08:43:30</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_01 {

    class Solution {

        private class TeamLine implements Comparable<TeamLine> {
            int rows;
            int combat;

            @Override
            public int compareTo(TeamLine o) {
                if (this.combat != o.combat) return this.combat - o.combat;
                return this.rows - o.rows;
            }

            public TeamLine(int rows, int combat) {
                this.rows = rows;
                this.combat = combat;
            }
        }

        public int[] kWeakestRows(int[][] mat, int k) {
            List<TeamLine> lines = new ArrayList<>();
            int line = 0;
            for (int[] ints : mat) {
                lines.add(new TeamLine(line++, Arrays.stream(ints).sum()));
            }
            Collections.sort(lines);
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = lines.get(i).rows;
            }
            return res;
        }
    }

}
