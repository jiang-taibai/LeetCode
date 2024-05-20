package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-20 13:41:36</p>
 */
public class DailyPractice_20240520 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestAwesome("12345678");
    }

    static class Solution {
        public int longestAwesome(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            Map<Integer, Integer> prefix = new HashMap<>();
            prefix.put(0, -1);
            int state = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                int c = chars[i] - '0';
                state ^= (1 << c);
                // 偶数的情况
                // 例如 2002, 3和-1
                // 例如 32002, 4和0
                if (prefix.containsKey(state)) {
                    res = Math.max(res, i - prefix.get(state));
                } else {
                    prefix.put(state, i);
                }
                // 奇数的情况
                // 例如 121
                // state 到1时是 001
                // newState 可以构造成 000，也就是考虑把 2 放中间的情况
                // 那么 000 的状态值为 2 和 -1
                // 得到最大回文串长度为 2-(-1)
                // 例如 2303
                // 3和0
                for (int j = 0; j < 10; j++) {
                    int newState = state ^ (1 << j);
                    if (prefix.containsKey(newState)) {
                        res = Math.max(res, i - prefix.get(newState));
                    }
                }
            }
            return res;
        }
    }

}
