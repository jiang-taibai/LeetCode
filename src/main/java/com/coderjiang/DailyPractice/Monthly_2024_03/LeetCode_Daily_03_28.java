package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/28</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_28 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nextVisit = new int[]{0, 0, 2};
        int[] nextVisit2 = new int[]{0, 0};
        System.out.println("solution.firstDayBeenInAllRooms(nextVisit) = " + solution.firstDayBeenInAllRooms(nextVisit));
        System.out.println("============================");
        System.out.println("solution.firstDayBeenInAllRooms(nextVisit) = " + solution.firstDayBeenInAllRooms(nextVisit2));
    }

    static class Solution {

        private static final long MOD = (long) (1e9 + 7);

        public int firstDayBeenInAllRooms(int[] nextVisit) {
            int n = nextVisit.length;
            int curVisit = 0;
            long[] step = new long[n];
            boolean[] vis = new boolean[n];
            boolean[] even = new boolean[n];
            int count = 0;
            long sumOfStep = 0;
            while (count != n) {
                sumOfStep = (sumOfStep + 1) % MOD;
//                System.out.printf("访问%d; 次数为偶数: %b; 总步数: %d\n", curVisit, even[curVisit], sumOfStep);
//                System.out.println(Arrays.toString(step));
                if (!vis[curVisit]) {
                    count++;
                    vis[curVisit] = true;
                }
                if (count == n) break;
                int preVisit = curVisit;
                if (even[curVisit]) {
                    step[curVisit] = sumOfStep;
                    curVisit = (curVisit + 1) % n;
                } else {
                    if (nextVisit[curVisit] < curVisit) {
                        if (nextVisit[curVisit] == 0) {
                            sumOfStep = (sumOfStep + step[curVisit - 1]) % MOD;
                        } else {
                            sumOfStep = (sumOfStep + step[curVisit - 1] + MOD - step[nextVisit[curVisit] - 1]) % MOD;
                        }
                    } else {
                        curVisit = nextVisit[curVisit];
                    }
                }
                even[preVisit] = !even[preVisit];
            }
            return (int) ((sumOfStep - 1 + MOD) % MOD);
        }
    }

}
/*
0,0,2
如果nextVisit[i]不指向自己
比如nextVisit[i]=j,则从i->i+1需要重新走一遍j->i
那么我可以记录从0->i每一步所花的步数

 */
