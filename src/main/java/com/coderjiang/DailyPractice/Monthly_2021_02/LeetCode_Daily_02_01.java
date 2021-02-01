package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.Arrays;

/**
 * <p>创建时间：2021/2/1 11:49</p>
 * <p>主要功能：爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_01 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();
            int sub = Math.abs(sumA - sumB);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (Math.abs(-A[i] + B[i]) + Math.abs(-B[i] + A[i]) == sub) {
                        return new int[]{A[i], B[i]};
                    }
                }
            }
            return new int[]{0};
        }
    }
}
