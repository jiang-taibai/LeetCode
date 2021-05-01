package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.*;

/**
 * <p>创建时间：2021/5/6 10:18</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_01 {


    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    class Solution {

        private Map<Integer, Employee> map = new TreeMap<>();

        public int getImportance(List<Employee> employees, int id) {
            for (Employee employee : employees) {
                map.put(employee.id, employee);
            }
            int sum = bfs(id);
            return sum;
        }

        int bfs(int root) {
            int res = 0;
            Stack<Employee> sta = new Stack<>();
            Set<Integer> vis = new HashSet<>();
            sta.push(map.get(root));
            vis.add(root);
            while (!sta.empty()) {
                Stack<Employee> next = new Stack<>();
                while (!sta.empty()) {
                    Employee employee = sta.pop();
                    res += employee.importance;
                    for (Integer subIndex : employee.subordinates) {
                        if (!vis.contains(subIndex)) {
                            next.add(map.get(subIndex));
                            vis.add(subIndex);
                        }
                    }
                }
                sta = next;
            }
            return res;
        }
    }

}
