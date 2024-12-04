package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-04 09:57:53</p>
 */
public class DailyPractice_20241204 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final int ROWS = 8;
        public static final int COLS = 8;

        public int countCombinations(String[] pieces, int[][] positions) {
            int n = positions.length;
            int[][][] pieceDirections = new int[n][][];
            for (int i = 0; i < n; i++) {
                pieceDirections[i] = getDirections(pieces[i]);
                positions[i][0]--;
                positions[i][1]--;
            }
            return dfs(pieceDirections, 0, positions, new int[n][2], new int[n]);
        }

        private boolean checkCombination(final int[][] positions, int[][] directions, int[] steps) {
            int n = positions.length;
            // 首先检查是否出界
            for (int i = 0; i < n; i++) {
                int row = positions[i][0], col = positions[i][1];
                int diffRow = directions[i][0], diffCol = directions[i][1];
                int step = steps[i];
                int finalRow = row + diffRow * step, finalCol = col + diffCol * step;
                if (finalRow < 0 || finalRow >= ROWS || finalCol < 0 || finalCol >= COLS) return false;
            }
            int[][] currentPositions = new int[positions.length][2];
            for (int i = 0; i < positions.length; i++) {
                currentPositions[i][0] = positions[i][0];
                currentPositions[i][1] = positions[i][1];
            }
            int[] currentSteps = new int[steps.length];
            System.arraycopy(steps, 0, currentSteps, 0, steps.length);
            // 再依次检查每一步是否冲突
            int[][] graph = new int[ROWS][COLS];
            for (int[] position : currentPositions) {
                graph[position[0]][position[1]] = 1;
            }
            while (true) {
                boolean moved = false;
                for (int i = 0; i < n; i++) {
                    if (currentSteps[i] <= 0) continue;
                    currentSteps[i]--;
                    moved = true;
                    int row = currentPositions[i][0], col = currentPositions[i][1];
                    int diffRow = directions[i][0], diffCol = directions[i][1];
                    int newRow = row + diffRow, newCol = col + diffCol;
                    graph[row][col]--;
                    graph[newRow][newCol]++;
                    currentPositions[i][0] = newRow;
                    currentPositions[i][1] = newCol;
                }
                // 检查是否存在一个位置上有两个及以上的旗子
                for (int i = 0; i < n; i++) {
                    if (graph[currentPositions[i][0]][currentPositions[i][1]] > 1) return false;
                }
                if (!moved) break;
            }
            System.out.println("可选的方案：");
            System.out.println("directions = " + Arrays.deepToString(directions));
            System.out.println("steps = " + Arrays.toString(steps));
            return true;
        }

        private int[][] getDirections(String piece) {
            switch (piece) {
                case "rook":
                    return new int[][]{
                            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
                    };
                case "queen":
                    return new int[][]{
                            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
                    };
                case "bishop":
                    return new int[][]{
                            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
                    };
            }
            return null;
        }

        private int dfs(int[][][] pieceDirections, int pieceIndex, int[][] positions, int[][] directions, int[] steps) {
            if (pieceIndex >= pieceDirections.length) {
                return checkCombination(positions, directions, steps) ? 1 : 0;
            }
            int res = 0;
            // 走 1-8 步
            for (int directionIndex = 0; directionIndex < pieceDirections[pieceIndex].length; directionIndex++) {
                directions[pieceIndex] = pieceDirections[pieceIndex][directionIndex];
                for (int i = 1; i < 8; i++) {
                    steps[pieceIndex] = i;
                    res += dfs(pieceDirections, pieceIndex + 1, positions, directions, steps);
                }
            }
            // 走 0 步只能有一种方向，因为多个方向走 0 步的状态是一样的
            directions[pieceIndex] = pieceDirections[pieceIndex][0];
            steps[pieceIndex] = 0;
            res += dfs(pieceDirections, pieceIndex + 1, positions, directions, steps);
            return res;
        }
    }

}
