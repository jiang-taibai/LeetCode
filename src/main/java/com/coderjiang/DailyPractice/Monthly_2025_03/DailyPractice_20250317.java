package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-17 14:31:09</p>
 */
public class DailyPractice_20250317 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minSwaps(String s) {
            char[] chars = s.toCharArray();
            int banlance = 0;
            int res = 0;
            for (char ch : chars) {
                if (ch == '[') {
                    banlance--;
                } else {
                    if (banlance >= 0) {
                        // ] 多了，向后面借一个 [ 来换
                        res++;
                        banlance--;
                    } else {
                        // ] 能够弥补平衡
                        banlance++;
                    }
                }
            }
            return res;
        }
    }

/*
]]][[[
[] ][[[ - [ + ]
[][ [[[ - [[ + ]]
[][] [[ - [ + ]
[][][ [ - [ + ]
[[[]]]
*/

}
