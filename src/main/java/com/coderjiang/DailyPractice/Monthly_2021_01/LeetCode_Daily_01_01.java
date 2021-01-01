package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * @author 刘江
 * @modifyTime 2021/1/1 00:21
 * @description TODO
 */
public class LeetCode_Daily_01_01 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            for(int i=0;i<flowerbed.length;i++) {
                if(flowerbed[i]==0) {
                    if((i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
                        flowerbed[i]=1;
                        count++;
                    }
                }
            }
            return count>=n;
        }
    }
}
