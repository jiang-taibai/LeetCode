package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2021/1/10 0:17
 * 主要功能：TODO
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_10 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<String>();
            int n = nums.length;
            if (n == 0) {
                return ans;
            }
            int start = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] != nums[i] - 1) {
                    if (start == nums[i - 1]) {
                        ans.add("" + start);
                    } else {
                        ans.add(start + "->" + nums[i - 1]);
                    }
                    start = nums[i];
                }
            }
            if (start == nums[n - 1]) {
                ans.add("" + start);
            } else {
                ans.add(start + "->" + nums[n - 1]);
            }
            return ans;
        }
    }
}
