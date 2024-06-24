package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-25 00:45:45</p>
 */
public class DailyPractice_20240625 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int types = 1 << cols;
            int[] indexes = new int[types];
            Arrays.fill(indexes, -1);
            for (int i = 0; i < rows; i++) {
                int num = 0;
                for (int j = 0; j < cols; j++) {
                    num <<= 1;
                    num += grid[i][j];
                }
                indexes[num] = i;
            }
            List<Integer> res = new ArrayList<>();
            if (indexes[0] != -1) {
                res.add(indexes[0]);
                return res;
            }
//            System.out.println(Arrays.toString(indexes));
            for (int i = 0; i < types; i++) {
                if (indexes[i] == -1) continue;
                for (int j = i + 1; j < types; j++) {
//                    System.out.printf("%d & %d = %s & %s = %d\n",
//                            i, j,
//                            Integer.toBinaryString(i),
//                            Integer.toBinaryString(j),
//                            i & j);
                    if (indexes[j] == -1) continue;
                    if ((i & j) == 0) {
                        res.add(indexes[i]);
                        res.add(indexes[j]);
                        Collections.sort(res);
                        return res;
                    }
                }
            }
            return res;
        }
    }

}

/*
如果要保证列之和少于为行的一半

首先看有没有全0的，如果有那全零行的行号就是答案
如果没有全0行，由于列数长度为 1-5，那么就可以用 Map<Integer, List<Integer>> 保存对应关系
如果取x1，那么遍历如果有数字x2使得 x1^x2=0，那么取这两个数字对应的行号即可
如果始终没有，那此题无解（有猜的嫌疑，但看看能不能过）
 */
