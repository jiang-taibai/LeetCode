package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/31 8:45</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_31 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (isSame(strs[i], strs[j])) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.getCategory();
        }

        private boolean isSame(String s1, String s2) {
            int count = 0;
            char firstCharInS1 = 0, secondCharInS1 = 0;
            char firstCharInS2 = 0, secondCharInS2 = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (count == 0) {
                        firstCharInS1 = s1.charAt(i);
                        firstCharInS2 = s2.charAt(i);
                    } else if (count == 1) {
                        secondCharInS1 = s1.charAt(i);
                        secondCharInS2 = s2.charAt(i);
                    } else return false;
                    count++;
                }
            }
            return count == 0 ||
                    (count == 2 && firstCharInS1 == secondCharInS2 &&
                            secondCharInS1 == firstCharInS2);
        }

        class UnionFind {
            private int[] arr;

            public UnionFind(int size) {
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
            }

            public int find(int son) {
                int father = arr[son];
                while (father != arr[father]) father = arr[father];
                while (father != arr[son]) {
                    int next = arr[son];
                    arr[son] = father;
                    son = next;
                }
                return father;
            }

            public int union(int son1, int son2) {
                return arr[find(son1)] = find(son2);
            }

            public int getCategory() {
                int count = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (find(i) == i) count++;
                }
                return count;
            }
        }
    }
}
