package com.coderjiang.RegularPractice;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/22 21:04
 * @description: TODO
 */
public class LeetCode_1441 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<String> buildArray(int[] target, int n) {
            int max = target[target.length - 1];
            int target_index = 0;
            List<String> list = new LinkedList<>();
            for(int i=1;i<=max;++i) {
                list.add("Push");
                if(target[target_index] != i) {
                    list.add("Pop");
                } else {
                    target_index++;
                }
            }
            return list;
        }
    }
}
