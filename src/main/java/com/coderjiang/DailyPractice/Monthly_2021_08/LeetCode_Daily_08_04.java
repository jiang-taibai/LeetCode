package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.*;

/**
 * <p>Creation Time: 2021-08-04 09:27:26</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_04 {

    static class Solution {

        public int triangleNumber(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int left = j + 1, right = n - 1, temp = j;
                    while(left <= right) {
                        int mid = (left + right) / 2;
                        if(nums[mid] < nums[i] + nums[j]) {
                            temp = mid;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    ans += temp - j;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 2, 3, 4};
        System.out.println(solution.triangleNumber(arr));
    }

}
