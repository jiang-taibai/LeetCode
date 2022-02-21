package com.coderjiang.DailyPractice.Monthly_2022_02;

/**
 * <p>Creation Time: 2022-02-21 08:37:45</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_21 {

    class Solution {
        public String pushDominoes(String dominoes) {
            // 当前是否正在向右倒
            boolean isRight = false;
            // 施加向右的作用力，最后一张牌的坐标
            int lastR = -1;
            int n = dominoes.length();
            char[] chars = dominoes.toCharArray();
            for (int i = 0; i < n; ++i) {
                if (chars[i] == 'R') {
                    // 如果当前牌向右倒去
                    if (isRight) {
                        // 如果已经在向右倒了，那么说明从开始向右倒到现在都得倒下
                        for (int j = lastR + 1; j <= i; ++j) chars[j] = 'R';
                    }
                    isRight = true;
                    lastR = i;
                } else if (chars[i] == 'L') {
                    if (isRight) {
                        // 如果当前牌向左倒，但是当前牌的趋势是向右倒
                        int l = lastR, r = i;
                        while (l < r) {
                            chars[l++] = 'R';
                            chars[r--] = 'L';
                        }
                        // 消除向右倒的状态
                        isRight = false;
                    } else {
                        // 如果当前牌向左倒，但是牌并不向右倒，那么牌一直往左倒，直到遇到L（不可能遇到R）或者到开头
                        for (int j = i - 1; j >= 0 && chars[j] == '.'; --j) chars[j] = 'L';
                    }
                }
            }
            // 如果到末尾了牌处于向右倒的趋势，那么将剩下这些牌置于向右倒的状态
            if (isRight) {
                for (int i = lastR + 1; i < n; ++i) chars[i] = 'R';
            }
            return new String(chars);
        }
    }

}
