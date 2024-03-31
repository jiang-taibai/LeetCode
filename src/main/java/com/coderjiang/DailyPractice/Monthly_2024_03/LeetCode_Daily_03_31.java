package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/31</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_31 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] preorders = new String[]{
                "9,#,93,#,9,9,#,#,#",
                "9,#,1,#,#",
                "9,3,4,#,#,1,#,#,2,#,6,#,#",
                "1,#",
                "9,#,#,1",
                "9,#,#,1,#,#",
        };
        for (String preorder : preorders) {
            System.out.println(preorder + ": " + solution.isValidSerialization(preorder));
        }
    }

    static class Solution {
        public boolean isValidSerialization(String preorder) {
            if (preorder.equalsIgnoreCase("#")) return false;
            String[] nodes = preorder.split(",");
            char[] chars = new char[nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                chars[i] = nodes[i].charAt(0);
            }
            return dfs(chars, 0) == chars.length - 1;
        }

        private int dfs(char[] nodes, int cur) {
            int n = nodes.length;
            if (nodes[cur] != '#') {
                if (cur + 1 > n - 1) return -1;
                if (nodes[cur + 1] != '#') {
                    // 情况一：后面是普通节点
                    int left_bound = dfs(nodes, cur + 1);
                    if (left_bound == -1) return -1;
                    return dfs(nodes, left_bound + 1);
                } else {
                    // 情况二：后面是空节点
                    int left_bound = cur + 1;
                    // 如果是两个空节点
                    if (cur + 2 > n - 1) return -1;
                    if (nodes[cur + 2] == '#') return cur + 2;
                    else return dfs(nodes, cur + 2);
                }
            } else {
                return cur;
            }
        }
    }

}
