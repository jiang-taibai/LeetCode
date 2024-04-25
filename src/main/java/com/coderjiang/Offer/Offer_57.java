package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-15 11:31:46</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_57 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int p1 = 0, p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[p1] + nums[p2] < target) p1++;
                else if (nums[p1] + nums[p2] > target) p2--;
                else return new int[]{nums[p1], nums[p2]};
            }
            return null;
        }
    }

}
