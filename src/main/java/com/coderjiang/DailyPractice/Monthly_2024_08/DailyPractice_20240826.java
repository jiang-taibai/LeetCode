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
            final Map<Integer, Employee> id2employee = new HashMap<>();
            employees.forEach(e -> id2employee.put(e.id, e));
            int res = 0;
            Queue<Employee> que = new LinkedList<>();
            que.add(id2employee.get(id));
            while(!que.isEmpty()) {
                Employee employee = que.poll();
                res += employee.importance;
                employee.subordinates.forEach(subId -> que.add(id2employee.get(subId)));
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
