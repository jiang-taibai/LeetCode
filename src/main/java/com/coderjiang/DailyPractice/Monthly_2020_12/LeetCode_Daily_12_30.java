package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.ArrayList;

/**
 * @author 刘江
 * @modifyTime 2020/12/30 12:35
 * @description TODO
 */
public class LeetCode_Daily_12_30 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testArr = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println("result: " + solution.lastStoneWeight(testArr));
    }

    static class Solution {
        public int lastStoneWeight(int[] stones) {
            ArrayList<Integer> stonesArray = new ArrayList<>();
            for (int stone : stones) {
                stonesArray.add(stone);
            }
            int loss = 0;
            while (loss < stones.length - 2) {
                stonesArray.sort((Integer i1, Integer i2) -> (i2.compareTo(i1)));
                //System.out.println(Arrays.toString(stonesArray.toArray()));
                int s1 = stonesArray.get(0);
                int s2 = stonesArray.get(1);
                int sub = s1 - s2;
                if (sub == 0) {
                    stonesArray.set(0, -1);
                    stonesArray.set(1, -1);
                    loss += 2;
                } else {
                    stonesArray.set(0, sub);
                    stonesArray.set(1, -1);
                    loss += 1;
                }
                System.out.println("loss: " + loss);
                //System.out.println(Arrays.toString(stonesArray.toArray()));
            }
            stonesArray.sort((Integer i1, Integer i2) -> (i2.compareTo(i1)));
            if (loss == stones.length) return 0;
            else return stonesArray.get(0);
        }
    }
}
