package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-24 22:51:22</p>
 */
public class DailyPractice_20240724 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
            final Set<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);
            for (int i = 0; i < moveFrom.length; i++) {
                set.remove(moveFrom[i]);
                set.add(moveTo[i]);
            }
            return Arrays.stream(set.toArray())
                    .mapToInt(i -> (int) i).boxed()
                    .sorted().collect(Collectors.toList());
        }
    }

}
