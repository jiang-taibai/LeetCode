package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-02 09:36:47</p>
 */
public class DailyPractice_20240502 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class Worker {
            int idx;
            int quality;
            int wage;
            int numOfLessThanMe;

            Worker(int idx, int quality, int wage) {
                this.idx = idx;
                this.quality = quality;
                this.wage = wage;
            }

            double getWQ() {
                return 1.0 * this.wage / this.quality;
            }

            @Override
            public String toString() {
                return "Worker{" +
                        "idx=" + idx +
                        ", quality=" + quality +
                        ", wage=" + wage +
                        ", numOfLessThanMe=" + numOfLessThanMe +
                        '}';
            }
        }

        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            List<Worker> workers = new ArrayList<>();
            int n = quality.length;
            for (int i = 0; i < n; i++) {
                workers.add(new Worker(i, quality[i], wage[i]));
            }
            workers.sort((a, b) -> a.wage * b.quality - b.wage * a.quality);
            double minWage = Double.MAX_VALUE;
            PriorityQueue<Integer> minQ = new PriorityQueue<>(Collections.reverseOrder());
            int sumOfQ = 0;
            for (int i = 0; i < k - 1; i++) {
                sumOfQ += workers.get(i).quality;
                minQ.add(workers.get(i).quality);
            }
            for (int i = k - 1; i < n; i++) {
                Worker worker = workers.get(i);
                minWage = Double.min(minWage, sumOfQ * worker.getWQ() + worker.wage);
                if (!minQ.isEmpty() && minQ.peek() > worker.quality) {
                    sumOfQ -= minQ.poll();
                    sumOfQ += worker.quality;
                    minQ.add(worker.quality);
                }
            }
            return minWage;
        }
    }

}
/*
quality = [10,20,5], wage = [70,50,30], k = 2
q/w = [0.1428571, 0.4, 0.1666667]
w/q = [7, 2.5, 6]

quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
q/w = [0.75, 0.125, 5., 5., 0.14285714]
w/q = [1.33333333, 8.        , 0.2       , 0.2       , 7.        ]

什么情况下雇佣了A，雇佣不了B
设A的质量qa，工资wa
B的质量qb，工资wb
当wa/qa*qb<wb，也就是wa/qa<wb/qb时，如果以A为基准付钱，那么B是不够的
那么如果以A为基准，要付wa/qa*qb工资给B
也就是说，如果选择了A，那么首先筛选w/q因子小于wa/qa的工人，再按照qb选取k-1个最小的

在排序时，按照wa/qa<wb/qb也就是wa*qb<wb*qa
 */
