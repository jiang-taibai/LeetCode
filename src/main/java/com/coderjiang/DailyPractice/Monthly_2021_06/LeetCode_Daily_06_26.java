package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_Daily_06_26 {

    static class Solution {
        final static int MAX_SIZE = 1000000;

        public int slidingPuzzle(int[][] board) {
            int num = board[0][0] * 100000 + board[0][1] * 10000 + board[0][2] * 1000 + board[1][0] * 100 + board[1][1] * 10 + board[1][2];
            return bfs(num);
        }

        private int bfs(int start) {
            List<Integer> que = new LinkedList<>();
            boolean[] vis = new boolean[MAX_SIZE];
            vis[start] = true;
            que.add(start);
            int level = 0;
            while (!que.isEmpty()) {
                List<Integer> next = new LinkedList<>();
                level++;
                while (!que.isEmpty()) {
                    int cur = que.get(que.size() - 1);
                    que.remove(que.size() - 1);

                    int[][] arr = {
                            {
                                    cur / 100000,
                                    (cur % 100000) / 10000,
                                    (cur % 10000) / 1000,
                            },
                            {
                                    (cur % 1000) / 100,
                                    (cur % 100) / 10,
                                    cur % 10
                            }
                    };

                    int x = 0, y = 0;
                    for (int i = 0; i < 2; ++i) {
                        for (int j = 0; j < 3; ++j) {
                            if (arr[i][j] == 0) {
                                x = i;
                                y = j;
                                break;
                            }
                        }
                    }

                    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                    for (int i = 0; i < 4; i++) {
                        int newX = x + direction[i][0];
                        int newY = y + direction[i][1];
                        if (newX < 0 || newX >= 2 || newY < 0 || newY >= 3) continue;
                        arr[x][y] = arr[newX][newY];
                        arr[newX][newY] = 0;
                        int num = arr[0][0] * 100000 + arr[0][1] * 10000 + arr[0][2] * 1000 + arr[1][0] * 100 + arr[1][1] * 10 + arr[1][2];
                        arr[newX][newY] = arr[x][y];
                        arr[x][y] = 0;
                        if (vis[num]) continue;
                        next.add(num);
                        vis[num] = true;
                        if(num == 123450) return level;
                    }
                }
                que = next;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{4, 1, 2}, {5, 0, 3}};
        solution.slidingPuzzle(arr);
    }

}