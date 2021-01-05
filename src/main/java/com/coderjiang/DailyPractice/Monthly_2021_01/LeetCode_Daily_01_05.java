package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘江
 * @modifyTime 2021/1/5 18:51
 * @description TODO
 */
public class LeetCode_Daily_01_05 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> ans = new ArrayList<>();
            int preIndex = 0;
            boolean isSuccessive = false;
            int count = 0;
            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
                    preIndex = i;
                    while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                        ++i;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(preIndex);
                    list.add(i);
                    ans.add(list);
                }
            }
            return ans;
        }
    }
}
