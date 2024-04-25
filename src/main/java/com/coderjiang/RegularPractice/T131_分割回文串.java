package com.coderjiang.RegularPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Creation Time: 2023-03-14 04:58:58</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T131_分割回文串 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tests = {
                "aab",
                "aabaca"
        };
        for (String test : tests) {
            System.out.println(test);
            List<List<String>> res = solution.partition(test);
            System.out.println(Arrays.toString(res.toArray()));
        }
    }

    static class Solution {
        public List<List<String>> partition(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                dp[i][i] = true;
            }
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    boolean isEqual = s.charAt(i) == s.charAt(j);
                    if (j == i + 1) dp[i][j] = isEqual;
                    else dp[i][j] = dp[i + 1][j - 1] && isEqual;
                }
            }
            // for (int i = 0; i < n; ++i) {
            //     for (int j = 0; j < n; ++j) {
            //         if (i <= j)
            //             System.out.printf("%s[%s]%s: %s\t\t",
            //                     i - 1 >= 0 ? s.substring(0, i) : "",
            //                     s.substring(i, j + 1),
            //                     j + 1 < n ? s.substring(j + 1, n) : "",
            //                     dp[i][j]);
            //         else System.out.printf("#%s#: None\t\t", s);
            //     }
            //     System.out.println();
            // }
            List<List<String>> res = new ArrayList<>();
            generatePartition(res, dp, new ArrayList<>(), 0, s);
            return res;
        }

        private void generatePartition(List<List<String>> res,
                                       boolean[][] dp,
                                       List<String> curList,
                                       int startIndex,
                                       String s) {
            if (startIndex == s.length()) {
                // List<String> list = new ArrayList<>(curList.size());
                // list.addAll(curList);
                List<String> list = new ArrayList<>(curList);
                res.add(list);
            }
            for (int i = startIndex; i < s.length(); ++i) {
                if (dp[startIndex][i]) {
                    curList.add(s.substring(startIndex, i + 1));
                    generatePartition(res, dp, curList, i + 1, s);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }

}
