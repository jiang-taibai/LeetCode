package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-07-08 10:30:47</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_14 {

    class Solution {
        public String intToRoman(int num) {
            Map<Integer, String> map = new HashMap<Integer, String>() {{
                put(1, "I");
                put(4, "IV");
                put(5, "V");
                put(9, "IX");
                put(10, "X");
                put(40, "XL");
                put(50, "L");
                put(90, "XC");
                put(100, "C");
                put(400, "CD");
                put(500, "D");
                put(900, "CM");
                put(1000, "M");
            }};
            int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            StringBuilder sb = new StringBuilder();
            for (int i = nums.length - 1; i >= 0; --i) {
                int cur = nums[i];
                String curStr = map.get(cur);
                while (cur <= num) {
                    sb.append(curStr);
                    num -= cur;
                }
            }
            return sb.toString();
        }
    }

}
