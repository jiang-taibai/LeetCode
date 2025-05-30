package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-30 11:41:57</p>
 */
public class DailyPractice_20250530 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int n = edges.length;
            int[] distance1 = bfs(edges, node1);
            int[] distance2 = bfs(edges, node2);
            int minDistance = n;
            int node = -1;
            for (int i = 0; i < n; ++i) {
                if (distance1[i] == -1 || distance2[i] == -1) continue;
                int distance = Math.max(distance1[i], distance2[i]);
                if (distance < minDistance) {
                    minDistance = distance;
                    node = i;
                }
            }
            return node;
        }

        private int[] bfs(int[] edges, int root) {
            int n = edges.length;

            int[] res = new int[n];
            Arrays.fill(res, -1);

            boolean[] vis = new boolean[n];
            Queue<Integer> que = new LinkedList<>();
            int depth = 0;

            que.offer(root);
            vis[root] = true;
            res[root] = depth;

            while (!que.isEmpty()) {
                Queue<Integer> nextQue = new LinkedList<>();
                ++depth;
                while (!que.isEmpty()) {
                    int node = que.poll();
                    int nextNode = edges[node];
                    if (nextNode != -1 && !vis[nextNode]) {
                        vis[nextNode] = true;
                        nextQue.offer(nextNode);
                        res[nextNode] = depth;
                    }
                }
                que = nextQue;
            }

            return res;
        }
    }

}
