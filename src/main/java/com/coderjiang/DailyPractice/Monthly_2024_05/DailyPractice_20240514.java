package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-14 22:50:37</p>
 */
public class DailyPractice_20240514 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumRounds(int[] tasks) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int task : tasks) {
                map.put(task, map.getOrDefault(task, 0) + 1);
            }
            int res = 0;
            for (int value : map.values()) {
                if (value == 1) return -1;
                res += calMinTurns(value);
            }
            return res;
        }

        private int calMinTurns(int times) {
            int res = times / 3;
            times -= res * 3;
            if (times == 0) return res;
            else if (times == 1) return res - 1 + 2;
            else return res + 1;
        }
    }

}

/*
如果一个任务有n次，设需要分x次2个一组、y次3个一组
即在条件 2x+3y-n=0 下，x+y最小值问题
也就是说，
 */