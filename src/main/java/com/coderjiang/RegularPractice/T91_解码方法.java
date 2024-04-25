package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 11:22:18</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T91_解码方法 {

    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            // 优化：特判，'0'开头则不可能有映射方案
            if (s.charAt(0) == '0') return 0;
            // 优化：滚动数组
            int a = 0, b = 1, c = 0;
            for (int i = 1; i < n; ++i) {
                char pre = s.charAt(i - 1);
                char cur = s.charAt(i);
                if (cur != '0') c = b;
                if ((pre == '1' && cur <= '9') || (pre == '2' && cur <= '6')) {
                    if (i == 1) c++;
                    else c += a;
                }
                // 优化：剪纸
                if (c == 0) return 0;
                a = b;
                b = c;
                c = 0;
            }
            return b;
        }
    }

}
/*
12138
1 2 1
12 1
1 21

1 2 1 3
12 1

*/
