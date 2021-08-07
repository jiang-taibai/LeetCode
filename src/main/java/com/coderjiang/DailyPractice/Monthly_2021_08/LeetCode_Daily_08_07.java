package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2021-08-07 11:34:33</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_07 {

    static class Solution {
        public boolean circularArrayLoop(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (circularArrayLoop_per(nums, i)) return true;
            }
            return false;
        }

        private boolean circularArrayLoop_per(int[] nums, int curIndex) {
            List<Integer> chain = new ArrayList<>();    // 保存一路走过去所经坐标
            int n = nums.length;
            boolean[] vis = new boolean[n];
            while (!vis[curIndex]) {
                chain.add(curIndex);
                vis[curIndex] = true;
                curIndex = (curIndex + nums[curIndex] + n) % n;
            }
            int start = chain.indexOf(curIndex);
            int end = chain.size() - 1;
            if (start != 0 || start == end) return false;
            for (int i = start + 1; i < end; i++) {
                if (nums[chain.get(i - 1)] * nums[chain.get(i)] < 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2, 1, -1, -2, -2};
        System.out.println(solution.circularArrayLoop(arr));
    }

}
