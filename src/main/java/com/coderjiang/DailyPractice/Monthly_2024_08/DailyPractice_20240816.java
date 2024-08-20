package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-16 21:37:58</p>
 */
public class DailyPractice_20240816 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int[] nums;
        int[] andValues;
        int lenOfNums, lenOfAndValues;
        static final int INIT_AND_VALUE = (1 << 20) - 1;
        static final int INF = (1 << 20) - 1;
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

        public int minimumValueSum(int[] nums, int[] andValues) {
            this.nums = nums;
            this.andValues = andValues;
            this.lenOfNums = nums.length;
            this.lenOfAndValues = andValues.length;
            int res = dfs(INF, 0, 0);
            return res >= INF ? -1 : res;
        }

        private int dfs(int curAnd, int numsIndex, int andValuesIndex) {
            if (numsIndex == lenOfNums && andValuesIndex == lenOfAndValues) return 0;
            if (numsIndex == lenOfNums || andValuesIndex == lenOfAndValues) return INF;
            if ((curAnd & nums[numsIndex]) < andValues[andValuesIndex]) return INF;
            final int key = numsIndex * 100 + andValuesIndex;
            if (memo.containsKey(key) && memo.get(key).containsKey(curAnd)) return memo.get(key).get(curAnd);
            int res = dfs(curAnd & nums[numsIndex], numsIndex + 1, andValuesIndex);
            if ((curAnd & nums[numsIndex]) == andValues[andValuesIndex]) {
                res = Math.min(res, dfs(INIT_AND_VALUE, numsIndex + 1, andValuesIndex + 1) + nums[numsIndex]);
            }
            memo.putIfAbsent(key, new HashMap<>());
            memo.get(key).put(curAnd, res);
            return res;
        }
    }

}
