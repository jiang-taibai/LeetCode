package com.coderjiang.DailyPractice.Monthly_2021_12;

/**
 * <p>Creation Time: 2021-12-22 18:06:00</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_22 {

    class Solution {
        public int repeatedStringMatch(String a, String b) {
            int n = a.length();
            int m = b.length();
            StringBuilder sb = new StringBuilder();
            int items = m / n + 2;
            for (int i = 0; i < items; ++i) {
                sb.append(a);
            }
            String maxStr = sb.toString();
            int index = maxStr.indexOf(b);
            if (index == -1) return -1;
            if (index == 0) {
                // 说明是从a[0]开始的
                if (m % n == 0) {
                    return m / n;
                } else {
                    return m / n + 1;
                }
            } else {
                int aInb = b.indexOf(a);
                if (aInb == -1) {
                    // abcdaabcda
                    //   cda
                    for (int i = 0; i < b.length(); ++i) {
                        if (a.startsWith(b.substring(i)) && a.endsWith(b.substring(0, i))) {
                            return 2;
                        }
                    }
                    return 1;
                } else {
                    // a在b里面
                    // 说明不是从a[0]开始的，那么
                    if ((m - aInb) % n == 0) {
                        return (m - aInb) / n + 1;
                    } else {
                        return (m - aInb) / n + 2;
                    }
                }
            }
        }
    }

}
