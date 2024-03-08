package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/8</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_08 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumPossibleSum(100000, 100000));
    }

    static class Solution {

        public final static long MOD = (long) (1e9 + 7);

        public int minimumPossibleSum(int n, int target) {
            if ((target & 1) == 0) {
                // ∑[1, (target/2-1)] + (target/2) + Σ[target, target+(n-(target/2-1)-1)-1]
                int mid = target / 2 - 1;
                if (n <= mid) {
                    return (int) sumOfSequence(1, n);
                } else if (n == mid + 1) {
                    return (int) ((sumOfSequence(1, mid) + mid + 1) % MOD);
                } else {
                    return (int) (((sumOfSequence(1, mid) + mid + 1) % MOD +
                            sumOfSequence(target, target + (n - mid - 1) - 1)) % MOD);
                }
            } else {
                // ∑[1, (target/2)] + ∑[target, target+(n-(target/2))-1]
                int mid = target / 2;
                if (n <= mid) {
                    return (int) sumOfSequence(1, n);
                } else {
                    return (int) ((sumOfSequence(1, mid) + sumOfSequence(target, target + (n - mid) - 1)) % MOD);
                }
            }
        }

        private long sumOfSequence(long begin, long end) {
            if (((begin + end) & 1) == 0) {
                return ((begin + end) / 2 * (end - begin + 1)) % MOD;
            } else {
                return ((begin + end) * (end - begin + 1) / 2) % MOD;
            }
            // 1,3 => 4*3/2=6
            // 1,4 => 5*4/2=10
            // 1,1 => 2*0=0
        }
    }

}
/*
如果 target=100
那么存在以下互相干扰的链条
1-99
2-98
...
49-51
50
100
...
显然，取 1~49 而舍弃 51~99 是最优解
之后的数字就是 50+100~无穷
---
如果 target=99
那么存在以下互相干扰的链条
1-98
2-97
...
49-50
99
...
显然，取 1~49 而舍弃 50~98 是最优解
之后的数字就是 99~无穷
---
那么可以用数学公式
如果 target 是偶数，取 ∑[1, (target/2-1)] + (target/2) + Σ[target, target+(n-(target/2-1)-1)-1]
如果 target 是奇数，取 ∑[1, (target/2)] + ∑[target, target+(n-(target/2))-1]



 */
