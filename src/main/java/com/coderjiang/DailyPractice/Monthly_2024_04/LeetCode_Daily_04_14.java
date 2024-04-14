package com.coderjiang.DailyPractice.Monthly_2024_04;

/**
 * <p>Creation Time: 2024/4/14</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_14 {

    public static void main(String[] args) {
    }

    static class MyHashSet {

        private static final int MAX_KEY = 1000000;
        private final boolean[] data = new boolean[MAX_KEY + 1];

        public MyHashSet() {
        }

        public void add(int key) {
            data[key] = true;
        }

        public void remove(int key) {
            data[key] = false;
        }

        public boolean contains(int key) {
            return data[key];
        }
    }

}
