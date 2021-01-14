package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>创建时间：2021/1/14 12:44</p>
 * <h3>1018. 可被 5 整除的二进制前缀</h3>
 * <p>主要功能：给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_14 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> ans = new ArrayList<Boolean>();
            int num = 0;
            for (int a : A) {
                num = num * 2 + a;
                num %= 5;
                ans.add(num == 0);
            }
            return ans;
        }
    }
}
