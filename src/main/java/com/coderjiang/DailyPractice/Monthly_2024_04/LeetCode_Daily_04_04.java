package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.*;

/**
 * <p>Creation Time: 2024/4/4</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_04 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final List<Set<Integer>> allNodeFathers = new ArrayList<>();

        private final List<List<Integer>> graph = new ArrayList<>();

        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            boolean[] isRoot = new boolean[n];
            Arrays.fill(isRoot, true);
            for (int i = 0; i < n; i++) {
                allNodeFathers.add(new HashSet<>());
                this.graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                isRoot[u] = false;
                this.graph.get(v).add(u);
            }
            for (int i = 0; i < n; i++) {
                if (isRoot[i]) {
                    dfs(i);
                }
            }
            List<List<Integer>> answers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> answer = new ArrayList<>(allNodeFathers.get(i));
                Collections.sort(answer);
                answers.add(answer);
            }
            return answers;
        }

        private void dfs(int node) {
            List<Integer> fatherNodes = this.graph.get(node);
            Set<Integer> fathers = new HashSet<>();
            for (Integer fatherNode : fatherNodes) {
                fathers.add(fatherNode);
                if(allNodeFathers.get(fatherNode).isEmpty()) {
                    dfs(fatherNode);
                }
                fathers.addAll(allNodeFathers.get(fatherNode));
            }
            allNodeFathers.set(node, fathers);
        }
    }

}
