package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/25 11:11</p>
 * <p>主要功能：在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * 返回区域的数目。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_25 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            UnionFind uf = new UnionFind(n * n * 4);
            for (int i = 0; i < n; i++) {
                grid[i] = grid[i].replaceAll("\\\\", "*");
                System.out.println(grid[i] + ", " + grid[i].length());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char ch = grid[i].charAt(j);
                    int u = getCode(i, j, n, Local.UP);
                    int r = getCode(i, j, n, Local.RIGHT);
                    int d = getCode(i, j, n, Local.DOWN);
                    int l = getCode(i, j, n, Local.LEFT);

                    if (ch == ' ') {
                        uf.union(u, r);
                        uf.union(u, d);
                        uf.union(u, l);
                    } else if (ch == '/') {
                        uf.union(u, l);
                        uf.union(r, d);
                    } else {
                        uf.union(u, r);
                        uf.union(l, d);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j + 1 < n) {
                        int r = getCode(i, j, n, Local.RIGHT);
                        int l_next = getCode(i, j + 1, n, Local.LEFT);
                        uf.union(r, l_next);
                    }
                    if (i + 1 < n) {
                        int u = getCode(i, j, n, Local.UP);
                        int d_next = getCode(i + 1, j, n, Local.DOWN);
                        uf.union(u, d_next);
                    }
                }
            }
            return uf.getCategory();
        }

        private int getCode(int i, int j, int cols, Local local) {
            int code = i * cols * 4 + j * 4;
            switch (local) {
                case UP:
                    return code;
                case RIGHT:
                    return code + 1;
                case DOWN:
                    return code + 2;
                case LEFT:
                    return code + 3;
            }
            return -1;
        }

        enum Local {
            UP, DOWN, RIGHT, LEFT;
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
                System.out.println("尝试合并 " + son1 + " & " + son2);
                return arr[find(son1)] = find(son2);
            }

            public int getCategory() {
                int count = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i == find(i)) count++;
                }
                return count;
            }
        }
    }
}
