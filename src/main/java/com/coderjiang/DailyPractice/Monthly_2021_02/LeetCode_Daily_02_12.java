package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>创建时间：2021/2/12 12:48</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_12 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            for (int i = 0; i < rowIndex; i++) {
                Queue<Integer> next = new LinkedList<>();
                next.add(1);
                while (queue.size() >= 2) {
                    int lhs = queue.poll();
                    int rhs = queue.peek();
                    next.add(lhs + rhs);
                }
                next.add(1);
                queue = next;
            }
            List<Integer> ans = new ArrayList<Integer>();
            ans.addAll(queue);
            return ans;
        }
    }
}
