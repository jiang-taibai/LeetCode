package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>创建时间：2021/2/13 22:32</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_13 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            boolean[] appear = new boolean[n];
            for (int i = 0; i < n; i++) {
                appear[nums[i] - 1] = true;
            }

            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (!appear[i]) {
                    list.add(i + 1);
                }
            }

            return list;
        }
    }
}
