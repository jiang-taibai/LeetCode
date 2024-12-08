package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-08 10:43:09</p>
 */
public class DailyPractice_20241208 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int movesToChessboard(int[][] board) {
            int n = board.length;
            int res = 0;
            // 首先列移动
            int[] cols = new int[n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (board[i][j] == 1) cols[j] += 1 << i;
                }
            }
//            System.out.println("cols = " + Arrays.toString(cols));
            int moveCols = move(cols);
            if (moveCols == -1) return -1;
            res += moveCols;
//            System.out.println("cols = " + Arrays.toString(cols));
            // 然后行移动
            int[] rows = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rows[i] += ((cols[j] >> i) & 1) << j;
                }
            }
//            System.out.println("rows = " + Arrays.toString(rows));
            int moveRows = move(rows);
            if (moveRows == -1) return -1;
            res += moveCols;
//            System.out.println("moveCols = " + moveCols);
//            System.out.println("moveRows = " + moveRows);
            return res;
        }

        private int move(int[] nums) {
            int res = 0;
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.size() != 2) return -1;
            int[] conditions = map.keySet().stream().mapToInt(i -> i).toArray();
            if ((conditions[0] & conditions[1]) != 0) return -1;
            if ((n & 1) == 1) {
                int num1, num2;
                if(map.get(conditions[0]) > n/2) {
                    num1 = conditions[0];
                    num2 = conditions[1];
                } else {
                    num1 = conditions[1];
                    num2 = conditions[0];
                }
            }
            return res;
        }

    }

}

/*
[1,1,0]
[0,0,1]
[0,0,1]

[1,0,1]
[0,1,0]
[0,1,0]

[0,0,1,1]
[0,0,0,1,1,1]
[0,1,0,1,0,1]
[0,1,0,0,1,1]
 */