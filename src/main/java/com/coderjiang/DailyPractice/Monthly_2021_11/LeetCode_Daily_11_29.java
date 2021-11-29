package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Creation Time: 2021-11-29 11:19:20</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_29 {

    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            List<int[]> fracs = new ArrayList<int[]>();
            for (int i = 0; i < arr.length; ++i) {
                for (int j = i + 1; j < arr.length; ++j) {
                    fracs.add(new int[]{arr[i], arr[j]});
                }
            }
            Collections.sort(fracs, (int[] a, int[] b) -> -a[1] * b[0] + a[0] * b[1]);
            return fracs.get(k-1);
        }
    }

}
