package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/16 15:48
 * @description: 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 *               这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 *               示例1:
 *               输入: pattern = "abba", str = "dog cat cat dog"
 *               输出: true
 * @get:
 * 1. 可以用System.out.println(Arrays.toString(arr)); 输出数组元素来debug
 * 2. boolean[]数组的初始值为false
 * 3. 用String::split(String pattern)来切割字符串
 * 4. 同C++一样，该式子[ int index = 'b' - 'a'; ]的值为 1
 */
public class LeetCode_Daily_12_16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat dogg"));
        System.out.println(solution.wordPattern("aba", "dog cat dog dog"));
        System.out.println(solution.wordPattern("abbaa", "dog cat cat dog"));
    }

    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strs = s.split(" ");
            if(strs.length != pattern.length()) return false;
            // 存储每一个字符串对应的小写字母
            Map<String, Character> map = new HashMap<>();
            boolean[] have = new boolean[26];
            int currIndex = 0;
            for(String str:strs) {
                if(!map.containsKey(str)) {
                    int index = pattern.charAt(currIndex)-'a';
                    if(have[index]) {
                        return false;
                    }
                    have[index] = true;
                    map.put(str, pattern.charAt(currIndex));
                }
                else if(pattern.charAt(currIndex) != map.get(str)) {
                    return false;
                }
                ++currIndex;
            }
            return true;
        }
    }
}


