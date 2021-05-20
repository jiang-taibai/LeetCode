package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.*;

/**
 * <p>创建时间：2021/5/20 11:59</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_20 {

    class Solution {

        class Word implements Comparable<Word> {
            public String val;
            public Integer nums;

            public Word(String val, Integer nums) {
                this.val = val;
                this.nums = nums;
            }

            @Override
            public int compareTo(Word o) {
                if(o.nums.equals(this.nums)) {
                    return this.val.compareTo(o.val);
                }
                return o.nums.compareTo(this.nums);
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<Word> priorityQueue = new PriorityQueue<>();
            for(Map.Entry<String, Integer> entry: map.entrySet()) {
                priorityQueue.add(new Word(entry.getKey(), entry.getValue()));
            }
            List<String> res = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                res.add(priorityQueue.poll().val);
            }
            return res;
        }

    }

}
