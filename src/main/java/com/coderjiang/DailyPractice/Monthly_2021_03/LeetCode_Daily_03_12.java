package com.coderjiang.DailyPractice.Monthly_2021_03;

/**
 * <p>创建时间：2021/3/12 10:16</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_12 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();
            int i = 0;
            int count = 1;
            while(i < n) {
                if(count == 0) {
                    return false;
                } else if(preorder.charAt(i) == ',') {
                    ++i;
                } else if(preorder.charAt(i) == '#') {
                    count--;
                    ++i;
                } else {
                    while(i < n && preorder.charAt(i) != ',') {
                        ++i;
                    }
                    count++;
                    ++i;
                }
            }
            return count == 0;
        }
    }
}
