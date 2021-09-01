package com.coderjiang.DailyPractice.Monthly_2021_09;

/**
 * <p>Creation Time: 2021-09-01 08:58:37</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_01 {

    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] version1_s = version1.split("\\.");
            String[] version2_s = version2.split("\\.");
            int i = 0;
            for (; i < Math.min(version1_s.length, version2_s.length); ++i) {
                int cmp = Integer.valueOf(version1_s[i]).compareTo(Integer.valueOf(version2_s[i]));
                if (cmp != 0) {
                    return cmp;
                }
            }
            if (i < version1_s.length) {
                for (; i < version1_s.length; ++i) if (Integer.parseInt(version1_s[i]) != 0) return 1;
                return 0;
            } else if (i < version2_s.length) {
                for (; i < version2_s.length; ++i) if (Integer.parseInt(version2_s[i]) != 0) return -1;
                return 0;
            }
            return 0;
        }
    }

}
