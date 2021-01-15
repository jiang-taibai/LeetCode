package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间：2021/1/15 20:39</p>
 * <p>主要功能：n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。</p>
 *
 * <p>见识到并查集的第二种用法，太绝了，学到了，将key看做横坐标，将value看做纵坐标，再合并即可</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_15 {
    public static void main(String[] args) {

    }

    class Solution {
        public int removeStones(int[][] stones) {
            UnionFind unionFind = new UnionFind();
            for (int[] i : stones) {
                unionFind.union(i[0] - 10001, i[1]);
            }
            return stones.length - unionFind.getCount();
        }

        class UnionFind {
            private Map<Integer, Integer> map;
            private int count;

            public UnionFind() {
                this.map = new HashMap<>();
                this.count = 0;
            }

            public int find(int son) {
                if (!map.containsKey(son)) {
                    map.put(son, son);
                    count++;
                }

                if (map.get(son) != son) {
                    map.put(son, find(map.get(son)));
                }
                return map.get(son);
            }

            public void union(int son1, int son2) {
                int father1 = find(son1);
                int father2 = find(son2);
                if (father1 == father2) return;
                map.put(father1, map.get(father2));
                count--;
            }

            public int getCount() {
                return count;
            }
        }
    }
}
