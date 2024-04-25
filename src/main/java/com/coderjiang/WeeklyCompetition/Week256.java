package com.coderjiang.WeeklyCompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>Creation Time: 2021-08-29 10:31:13</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Week256 {

    class Solution1 {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            if (k == nums.length) {
                return nums[nums.length - 1] - nums[0];
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i + k - 1 < nums.length; ++i) {
                System.out.println(nums[i + k - 1] + " " + nums[i]);
                res = Math.min(res, nums[i + k - 1] - nums[i]);
            }
            return res;
        }
    }

    class Solution2 {
        public String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums, (a, b) -> {
                if (a.length() != b.length()) return a.length() - b.length();
                return a.compareTo(b);
            });
            return nums[nums.length - k];
        }
    }

    class Solution {

        private int maxTime = 0;
        private List<Integer> curMaxChose;
        private Stack<Integer> curChose;
        boolean[] vis = new boolean[15];

        public int minSessions(int[] tasks, int sessionTime) {
            Arrays.sort(tasks);
            int res = 0;
            int n = tasks.length;
            for (int i = n - 1; i >= 0; --i) {
                if (vis[i]) continue;
                curChose = new Stack<>();
                curChose.push(i);
                maxTime = 0;
                dfs(tasks, sessionTime, i - 1, tasks[i]);
                System.out.println(Arrays.toString(curMaxChose.toArray()));
                for (Integer chose : curMaxChose) {
                    vis[chose] = true;
                }
                res++;
            }
            return res;
        }

        private void dfs(int[] tasks, int target, int curIndex, int curTime) {
            if (curIndex < 0) {
                if (curTime > maxTime) {
                    curMaxChose = new ArrayList<>(curChose);
                    maxTime = curTime;
                }
            } else {
                if (vis[curIndex]) {
                    dfs(tasks, target, curIndex - 1, curTime);
                } else {
                    dfs(tasks, target, curIndex - 1, curTime);
                    if (curTime + tasks[curIndex] <= target) {
                        curChose.push(curIndex);
                        dfs(tasks, target, curIndex - 1, curTime + tasks[curIndex]);
                        curChose.pop();
                    }
                }
            }
        }
    }
    //[2,3,3,4,4,4,5,6,7,10]
    // 10 2
    // 7 5
    // 6 3 3
    // 4 4 4

    // [1,2,3]
    // 3
    // [3,1,3,1,1]
    // 8
    // [1,2,3,4,5]
    // 15
    // [2,3,3,4,4,4,5,6,7,10]
    // 12
    // [5,6]
    // 13

}
