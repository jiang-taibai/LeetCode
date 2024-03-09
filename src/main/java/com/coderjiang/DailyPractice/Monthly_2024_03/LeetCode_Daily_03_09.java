package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2024/3/9</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_09 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, -2, 3, 4, -10, 12};
        int k = 16;
        System.out.println(solution.kSum(nums, k));
    }

    static class Solution {
        public long kSum(int[] nums, int k) {
            int n = nums.length;
            long positiveSum = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) positiveSum += nums[i];
                else nums[i] = -nums[i];
            }
            Arrays.sort(nums);
            return positiveSum - minKSumByPriorityQueue(nums, k);
        }

        private long minKSumByPriorityQueue(int[] nums, int k) {
            if (k == 1) return 0;
            int n = nums.length;
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            pq.offer(new long[]{nums[0], 0});
            for (int i = 0; i < k - 2; i++) {
                long[] arr = pq.poll();
                assert arr != null;
                long sum = arr[0];
                int index = (int) arr[1];
                if (index >= n - 1) continue;
                pq.offer(new long[]{sum + nums[index + 1], index + 1});
                pq.offer(new long[]{sum - nums[index] + nums[index + 1], index + 1});
            }
            assert pq.peek() != null;
            return pq.peek()[0];
        }

        private long minKSumByDynamicProgramming(int[] nums, int k) {
            long preMaxK = 1;
            long curMaxK = Math.min(2, k);
            long[] dp1 = new long[k], dp0 = new long[k];
            for (int num : nums) {
                if (dp0[k - 1] != 0 && dp0[k - 1] < num)
                    break; // 如果加上这个数字不影响前 k 小的子序列结果，则直接停止遍历
                int left = 0, right = 0, cur = 0;
                while (cur < curMaxK) {
                    int condition = -1; // 0 为取左边和， 1 为取右边和
                    if (right == preMaxK) {
                        condition = 0;
                    } else if (left == preMaxK) {
                        condition = 1;
                    }
                    if (condition == -1) {
                        condition = (dp0[left] + num >= dp0[right]) ? 1 : 0;
                    }
                    dp1[cur] = (condition == 0) ? dp0[left++] + num : dp0[right++];
                    cur++;
                }
                dp0 = dp1.clone();
                preMaxK = curMaxK;
                curMaxK <<= 1;
                if (curMaxK > k) curMaxK = k;
            }
            return dp1[k - 1];
        }

    }

}

/*
以 nums = [1, -2, 3, 4, -10, 12] 为例
如果把 nums 中所有正数排序，再将负数排序
positiveNums = [1, 3, 4, 12]
negativeNums = [-2, -10]
maxSum = 20
问题转换成 A：
nums = [-1, -2, -3, -4, -10, -12]
从里面取一个子序列（可为空），取第 k 大

全部变成正数，问题继续转换成 B：
nums = [1, 2, 3, 4, 10, 12]
从里面取一个子序列（可为空），取第 k 小，若该子序列和为sum，则最终原问题第 k 大子序列和应为 20-sum

对于问题B，可以使用动态规划求解
dp[i][j][k]为nums[i, j]范围内第k小的和
由于这里i恒为0，故简化为二维数组
转移方程采用双指针求解
left为加上nums[j]的位置，right为没加上nums[j]的位置，应当满足dp[j-1][left]+nums[j]<=dp[j-1][right]
如果 dp[j-1][left]+nums[j] = dp[j-1][right]，则 dp[j][k]=dp[j-1][right], right++, k++
如果 dp[j-1][left]+nums[j] < dp[j-1][right]，则 dp[j][k]=dp[j-1][left], left++, k++
如果 dp[j-1][left]+nums[j] > dp[j-1][right]，则 dp[j][k]=dp[j-1][right], right++, k++
根据转移方程，我们可以进一步地修改为滚动数组

```java
private long minKSumByDynamicProgramming(int[] nums, int k) {
    long preMaxK = 1;
    long curMaxK = Math.min(2, k);
    long[] dp1 = new long[k], dp0 = new long[k];
    for (int num : nums) {
        if (dp0[k - 1] != 0 && dp0[k - 1] < num)
            break; // 如果加上这个数字不影响前 k 小的子序列结果，则直接停止遍历
        int left = 0, right = 0, cur = 0;
        while (cur < curMaxK) {
            int condition = -1; // 0 为取左边和， 1 为取右边和
            if (right == preMaxK) {
                condition = 0;
            } else if (left == preMaxK) {
                condition = 1;
            }
            if (condition == -1) {
                condition = (dp0[left] + num >= dp0[right]) ? 1 : 0;
            }
            dp1[cur] = (condition == 0) ? dp0[left++] + num : dp0[right++];
            cur++;
        }
        dp0 = dp1.clone();
        preMaxK = curMaxK;
        curMaxK <<= 1;
        if (curMaxK > k) curMaxK = k;
    }
    return dp1[k - 1];
}
```

对于问题B，我们还可以使用小顶堆来求解第K小的子序列
```java
private long minKSumByPriorityQueue(int[] nums, int k) {
    if (k == 1) return 0;
    int n = nums.length;
    PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    pq.offer(new long[]{nums[0], 0});
    for (int i = 0; i < k - 2; i++) {
        long[] arr = pq.poll();
        assert arr != null;
        long sum = arr[0];
        int index = (int) arr[1];
        if (index >= n - 1) continue;
        pq.offer(new long[]{sum + nums[index + 1], index + 1});
        pq.offer(new long[]{sum - nums[index] + nums[index + 1], index + 1});
    }
    assert pq.peek() != null;
    return pq.peek()[0];
}
```

 */
