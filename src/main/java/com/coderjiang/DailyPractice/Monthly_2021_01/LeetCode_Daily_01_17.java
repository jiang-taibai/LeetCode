package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/17 12:01</p>
 * <p>主要功能：在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_17 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * y1=kx1+b;
         * y2=kx2+b;
         * b=y1-kx1;
         * y1-y2=k(x1-x2)
         * k=(y1-y2)/(x1-x2);
         * b=y1-(x1(y1-y2))/(x1-x2);
         *
         * @param coordinates
         * @return
         */
        public boolean checkStraightLine(int[][] coordinates) {
            int n = coordinates.length;
            if (n == 2) return true;
            double x1 = coordinates[0][0];
            double y1 = coordinates[0][1];
            double x2 = coordinates[1][0];
            double y2 = coordinates[1][1];
            if (x1 == x2) {
                for (int[] coordinate : coordinates) {
                    if (coordinate[0] != x1) return false;
                }
            } else {
                double k = (y1 - y2) / (x1 - x2);
                double b = y1 - (x1 * (y1 - y2)) / (x1 - x2);
                for (int[] coordinate : coordinates) {
                    double x = coordinate[0];
                    double y = coordinate[1];
                    if (y != k * x + b) return false;
                }
            }
            return true;
        }
    }
}
