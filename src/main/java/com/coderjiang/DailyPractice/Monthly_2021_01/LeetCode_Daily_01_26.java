package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间：2021/1/26 10:10</p>
 * <p>主要功能：给你一个由一些多米诺骨牌组成的列表 dominoes。
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_26 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numEquivDominoPairs_map(int[][] dominoes) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] dominoe : dominoes) {
                int a = dominoe[0];
                int b = dominoe[1];
                int count = map.getOrDefault(a * 10 + b, 0) + 1;
                map.put(a * 10 + b, count);
                if (a != b) {
                    map.put(b * 10 + a, count);
                }
            }
            int countPair = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() / 10 == entry.getKey() % 10) {
                    countPair += entry.getValue() * (entry.getValue() - 1) / 2;
                }
                countPair += entry.getValue() * (entry.getValue() - 1) / 2;

            }
            return countPair / 2;
        }

        public int numEquivDominoPairs(int[][] dominoes) {
            int[] num = new int[100];
            int count = 0;
            for (int[] dominoe : dominoes) {
                int index = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
                count += num[index]++;
            }
            return count;
        }
    }
}
