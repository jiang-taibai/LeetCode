package com.coderjiang.RegularPractice;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/22 20:55
 * @description: TODO
 */
public class LeetCode_1598 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int minOperations(String[] logs) {
            int res = 0;
            for (String log : logs) {
                if(log.equals("./")) {
                    continue;
                } else if(log.equals("../")) {
                    if(res>0){
                        res--;
                    }
                } else {
                    res++;
                }
            }
            return res;
        }
    }
}
