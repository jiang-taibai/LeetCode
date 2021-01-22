package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>创建时间：2021/1/22 10:11</p>
 * <p>主要功能：对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_22 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> nums = new ArrayList<Integer>();
            for (int i = 0; i < A.length; i++) {
                nums.add(A[i]);
            }
            Collections.reverse(nums);
            // 此时nums为A的倒序，即1234表示为[4,3,2,1]
            int index = 0;
            while (K > 0) {
                addToUnitNumber(nums, K % 10, index++);
                K /= 10;
            }
            Collections.reverse(nums);
            return nums;
        }

        // 从index加起一个一位数, index取值从0开始
        private List<Integer> addToUnitNumber(List<Integer> nums, int num, int index) {
            int n = nums.size();
            // 如果坐标大于当前数字的最高位，例如[1,2,3,4]+100000(表现为nums=[4,3,2,1], num=1, index=6-1),则添加index-n-1+1个零
            // 最后再添加一个num即可
            if (index >= n) {
                //nums.add(index - n - 1 + 1, 0);   // 为了代码的可读性，这里不省略-1+1了
                nums.add(num);
            } else {
                int sum = nums.get(index) + num;
                nums.set(index++, sum % 10);
                boolean up = sum >= 10;  //是否要进位
                while (up) {
                    if (index >= n) break;
                    sum = nums.get(index) + 1;
                    nums.set(index++, sum % 10);
                    up = sum >= 10;
                }
                // 如果不是因为不需要进位了而停止的话，则还需进位，只需添加末尾1即可
                if (up) {
                    nums.add(1);
                    up = false;
                }
            }
            System.out.println(Arrays.toString(nums.toArray()));
            return nums;
        }
    }
}
