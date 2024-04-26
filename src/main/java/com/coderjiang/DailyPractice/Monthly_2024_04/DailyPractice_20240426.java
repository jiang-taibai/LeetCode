package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-26 10:36:40</p>
 */
public class DailyPractice_20240426 {

    public static void main(String[] args) {
    }

    static class SnapshotArray {

        private final List<Map<Integer, Integer>> snapshots = new ArrayList<>();
        private final int length;
        private final int[] data;
        private final Set<Integer> dirtyIndexes;
        private int snapId;

        public SnapshotArray(int length) {
            this.length = length;
            this.data = new int[length];
            this.dirtyIndexes = new HashSet<>();
            for (int i = 0; i < length; i++) {
                this.snapshots.add(new HashMap<>());
            }
            this.snapId = -1;
        }

        public void set(int index, int val) {
            this.data[index] = val;
            this.dirtyIndexes.add(index);
        }

        public int snap() {
            this.snapId++;
            for (Integer dirtyIndex : this.dirtyIndexes) {
                this.snapshots.get(dirtyIndex).put(this.snapId, this.data[dirtyIndex]);
            }
            this.dirtyIndexes.clear();
            return this.snapId;
        }

        public int get(int index, int snap_id) {
            Map<Integer, Integer> snapshot = this.snapshots.get(index);
            for (int i = snap_id; i >= 0; i--) {
                if (snapshot.containsKey(i)) return snapshot.get(i);
            }
            return 0;
        }
    }

}
