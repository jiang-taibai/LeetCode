package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-01-26 09:59:21</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_26 {

    class DetectSquares {

        private static final int MAXN = 1000 + 10;
        private final int[][] matrix;

        public DetectSquares() {
            matrix = new int[MAXN][MAXN];
        }

        public void add(int[] point) {
            matrix[point[0]][point[1]]++;
        }

        private void delete(int[] point) {
            if (matrix[point[0]][point[1]] > 0)
                matrix[point[0]][point[1]]--;
        }

        public int count(int[] point) {
            add(point);
            int x = point[0], y = point[1];
            int res = 0;
            for (int i = 1; i <= 1000; ++i) {
                int xx, yy;
                // 左上的正方形
                xx = x - i;
                yy = y + i;
                res += count(xx, yy, i) / matrix[x][y];

                // 左下的正方形
                xx = x - i;
                yy = y;
                res += count(xx, yy, i) / matrix[x][y];

                // 右上的正方形
                xx = x;
                yy = y + i;
                res += count(xx, yy, i) / matrix[x][y];

                // 右下的正方形
                xx = x;
                yy = y;
                res += count(xx, yy, i) / matrix[x][y];
            }
            delete(point);
            return res;
        }

        private int count(int x, int y, int size) {
            int lu_x = x, lu_y = y,
                    ru_x = x + size, ru_y = y,
                    ld_x = x, ld_y = y - size,
                    ud_x = x + size, ud_y = y - size;
            if (lu_x < 0 || lu_y < 0 || ru_x < 0 || ru_y < 0 || ld_x < 0 || ld_y < 0 || ud_x < 0 || ud_y < 0) return 0;
            if (lu_x >= MAXN || lu_y >= MAXN || ru_x >= MAXN ||
                    ru_y >= MAXN || ld_x >= MAXN || ld_y >= MAXN || ud_x >= MAXN || ud_y >= MAXN) return 0;
            return matrix[lu_x][lu_y] * matrix[ru_x][ru_y] * matrix[ld_x][ld_y] * matrix[ud_x][ud_y];
        }
    }

}
