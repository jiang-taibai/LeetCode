package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-07 15:04:47</p>
 */
public class T21_队列_你可以安排的最多任务数目 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            Arrays.sort(tasks);
            Arrays.sort(workers);
            int taskIndex = tasks.length - 1;
            int workerIndex = workers.length - 1;
            int res = 0;
            while (taskIndex >= 0 && workerIndex >= 0) {
                if (workers[workerIndex] >= tasks[taskIndex]) {
                    workerIndex--;
                    taskIndex--;
                    res++;
                } else if (pills > 0 && workers[workerIndex] + strength >= tasks[taskIndex]) {
                    pills--;
                    workerIndex--;
                    taskIndex--;
                    res++;
                } else {
                    taskIndex--;
                }
            }
            return res;
        }
    }

}
