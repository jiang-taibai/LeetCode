package com.coderjiang.StudyPlan._2024_spring_sprint_100;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-23 09:08:26</p>
 */
public class T40_双指针_删除有序数组中的重复项 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int l = 0, r = 0;
            int n = nums.length;
            while (r < n) {
                nums[l] = nums[r];
                while (r < n && nums[r] == nums[l]) r++;
                l++;
            }
            return l;
        }
    }

}
