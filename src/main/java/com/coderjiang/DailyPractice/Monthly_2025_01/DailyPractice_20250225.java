package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-25 21:08:59</p>
 */
public class DailyPractice_20250225 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        class Allocator {

            private final int[] set;
            private final int n;

            public Allocator(int n) {
                this.set = new int[n];
                this.n = n;
            }

            public int allocate(int size, int mID) {
                for (int i = 0; i + size - 1 < n; i++) {
                    if (set[i] == 0) {
                        boolean valid = true;
                        for (int j = 0; j < size; j++) {
                            if (set[i + j] != 0) {
                                valid = false;
                                break;
                            }
                        }
                        if (!valid) continue;
                        for (int j = 0; j < size; j++) {
                            set[i + j] = mID;
                        }
                        return i;
                    }
                }
                return -1;
            }

            public int freeMemory(int mID) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (set[i] == mID) {
                        set[i] = 0;
                        count++;
                    }
                }
                return count;
            }
        }
    }

}
