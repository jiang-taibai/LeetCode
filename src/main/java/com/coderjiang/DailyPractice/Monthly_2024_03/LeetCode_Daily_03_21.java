package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/28</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_21 {

    public static void main(String[] args) {
    }

    static class FrequencyTracker {

        private final int[] count = new int[(int) 1e5 + 10];
        private final int[] frequency = new int[(int) 1e5 + 10];

        public FrequencyTracker() {

        }

        public void add(int number) {
            int curNumberFrequency = count[number];
            if (curNumberFrequency != 0) frequency[curNumberFrequency]--;
            count[number] = ++curNumberFrequency;
            frequency[curNumberFrequency]++;
        }

        public void deleteOne(int number) {
            int curNumberFrequency = count[number];
            if (curNumberFrequency != 0) {
                frequency[curNumberFrequency]--;
                count[number] = --curNumberFrequency;
                frequency[curNumberFrequency]++;
            }
        }

        public boolean hasFrequency(int frequency) {
            return this.frequency[frequency] > 0;
        }
    }

}