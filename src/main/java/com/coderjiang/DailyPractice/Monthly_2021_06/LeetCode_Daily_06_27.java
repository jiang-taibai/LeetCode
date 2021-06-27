package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Daily_06_27 {

    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            return bfs(1, n * n, board);
        }

        private int bfs(int start, int target, int[][] board) {
            int n = board.length;
            int level = 0;
            Queue<Integer> que = new LinkedList<>();
            que.offer(start);
            boolean[] vis = new boolean[target + 1];
            while (!que.isEmpty()) {
                Queue<Integer> nextQue = new LinkedList<>();
                level++;
                while (!que.isEmpty()) {
                    int cur = que.poll();
                    // 可以移动 x+1 ... x+6
                    for (int i = 1; i <= 6; i++) {
                        int next = cur + i;
                        if(next > target) continue;
                        int point = next - 1;
                        int x = n - 1 - point / n;
                        int y = (point / n) % 2 == 0 ? point % n : n - 1 - point % n;
//                        System.out.printf("next = %d, x = %d, y = %d\n", next, x, y);
                        if (x < 0 || x >= n || y >= n || y < 0) continue;
                        // 如果不等于-1，说明可以瞬移
                        if (board[x][y] != -1) {
                            vis[next] = true;
                            next = board[x][y];
//                            System.out.println("到了" + next);
                        }
                        if (!vis[next]) {
                            vis[next] = true;
                            nextQue.offer(next);
                            if (next == target) return level;
                        }
                    }
                }
                que = nextQue;
            }
            return -1;
        }
    }

}