package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-26 00:30:51</p>
 */
public class DailyPractice_20240826 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int getImportance(List<Employee> employees, int id) {
            final Employee[] employeeArray = new Employee[2000 + 1];
            employees.forEach(e -> employeeArray[e.id] = e);
            int res = 0;
            Queue<Employee> que = new LinkedList<>();
            que.add(employeeArray[id]);
            while (!que.isEmpty()) {
                Employee employee = que.poll();
                res += employee.importance;
                employee.subordinates.forEach(subId -> que.add(employeeArray[subId]));
            }
            return res;
        }
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
