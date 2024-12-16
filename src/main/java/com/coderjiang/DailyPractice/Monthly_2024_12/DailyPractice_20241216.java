package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-16 09:11:33</p>
 */
public class DailyPractice_20241216 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class Event implements Comparable<Event> {
            private final int preferred;
            private final int minSize;
            private final int eventIndex;

            public Event(int preferred, int minSize, int eventIndex) {
                this.preferred = preferred;
                this.minSize = minSize;
                this.eventIndex = eventIndex;
            }

            @Override
            public int compareTo(Event o) {
                if (this.minSize != o.minSize) {
                    return o.minSize - this.minSize;
                }
                return this.preferred - o.preferred;
            }

            @Override
            public String toString() {
                return "Event{" +
                        "preferred=" + preferred +
                        ", minSize=" + minSize +
                        ", eventIndex=" + eventIndex +
                        '}';
            }
        }

        public int[] closestRoom(int[][] rooms, int[][] queries) {
            int n = rooms.length;
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                events.add(new Event(queries[i][0], queries[i][1], i));
            }
            Collections.sort(events);
//            events.forEach(System.out::println);
            // 最大的房间放前面
            Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
            int roomIndex = 0;
            TreeSet<Integer> roomIds = new TreeSet<>();
            int[] answer = new int[queries.length];
            for (Event event : events) {
                while (roomIndex < n && rooms[roomIndex][1] >= event.minSize) {
                    roomIds.add(rooms[roomIndex][0]);
                    roomIndex++;
                }
                Integer ceilRoomId = roomIds.ceiling(event.preferred);
                Integer floorRoomId = roomIds.floor(event.preferred);
//                System.out.println("ceilRoomId = " + ceilRoomId);
//                System.out.println("floorRoomId = " + floorRoomId);
                int dis = Integer.MAX_VALUE;
                int res = -1;
                if (ceilRoomId != null && Math.abs(event.preferred - ceilRoomId) < dis) {
                    dis = Math.abs(event.preferred - ceilRoomId);
                    res = ceilRoomId;
                }
                if (floorRoomId != null && Math.abs(event.preferred - floorRoomId) <= dis) {
                    res = floorRoomId;
                }
                answer[event.eventIndex] = res;
            }
            return answer;
        }
    }

}
