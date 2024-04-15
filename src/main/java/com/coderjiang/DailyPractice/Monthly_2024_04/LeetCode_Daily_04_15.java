package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024/4/15</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_15 {

    public static void main(String[] args) {
    }

    static class MyHashMap {

        private static final int MAX_KEY = 1000000;
        private final int[] data = new int[MAX_KEY + 1];
        private static final int NOT_EXIST = -1;

        public MyHashMap() {
            Arrays.fill(data, NOT_EXIST);
        }

        public void put(int key, int value) {
            data[key] = value;
        }

        public int get(int key) {
            return data[key];
        }

        public void remove(int key) {
            data[key] = NOT_EXIST;
        }
    }

}
