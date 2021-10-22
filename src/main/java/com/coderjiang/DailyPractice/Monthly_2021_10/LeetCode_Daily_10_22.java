package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Creation Time: 2021-10-22 11:17:43</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_22 {

    class Solution {
        public List<Integer> majorityElement_ONLogN(int[] nums) {
            List<Integer> res = new ArrayList<>();
            Arrays.sort(nums);
            int cnt = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] != nums[i - 1]) {
                    if (cnt > nums.length / 3) res.add(nums[i - 1]);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            if (cnt > nums.length / 3) res.add(nums[nums.length - 1]);
            return res;
        }

        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int element1 = 0, element2 = 0;
            int vot1 = 0, vot2 = 0;
            for (int num : nums) {
                if (vot1 > 0 && element1 == num) {
                    vot1++;
                } else if (vot2 > 0 && element2 == num) {
                    vot2++;
                } else if (vot1 == 0) {
                    vot1 = 1;
                    element1 = num;
                } else if (vot2 == 0) {
                    vot2 = 1;
                    element2 = num;
                } else {
                    vot1--;
                    vot2--;
                }
            }

            int cnt1 = 0, cnt2 = 0;
            for (int num : nums) {
                if (element1 == num) cnt1++;
                if (element2 == num) cnt2++;
            }
            if (vot1 > 0 && cnt1 > nums.length / 3) res.add(element1);
            if (vot2 > 0 && cnt2 > nums.length / 3) res.add(element2);
            return res;
        }
    }

}
