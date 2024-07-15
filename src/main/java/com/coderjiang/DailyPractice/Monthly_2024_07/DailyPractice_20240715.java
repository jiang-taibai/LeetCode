package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-15 09:40:18</p>
 */
public class DailyPractice_20240715 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final Map<String, Integer> email2Index = new HashMap<>();
        private final Map<Integer, String> index2Email = new HashMap<>();
        private final Map<Integer, String> index2Nickname = new HashMap<>();
        private int nextEmailIndex = 0;

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            UnionSet unionSet = new UnionSet(10 * 1000);
            for (List<String> account : accounts) {
                String nickname = account.get(0);
                String firstEmail = account.get(1);
                int firstEmailIndex = getEmailIndex(firstEmail);
                index2Nickname.put(firstEmailIndex, nickname);
                for (int i = 2; i < account.size(); i++) {
                    String email = account.get(i);
                    int emailIndex = getEmailIndex(email);
                    index2Nickname.put(emailIndex, nickname);
                    unionSet.merge(firstEmailIndex, emailIndex);
                }
            }
            Map<Integer, List<Integer>> emailTree = new HashMap<>();
            for (int i = 0; i < nextEmailIndex; ++i) {
                Integer fatherEmailIndex = unionSet.find(i);
                emailTree.putIfAbsent(fatherEmailIndex, new ArrayList<>());
                emailTree.get(fatherEmailIndex).add(i);
            }
            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : emailTree.entrySet()) {
                Integer fatherEmailIndex = entry.getKey();
                List<Integer> emailIndexes = entry.getValue();
                // 姓名
                String nickname = index2Nickname.get(fatherEmailIndex);
                List<String> nicknameAndEmails = new ArrayList<>();
                nicknameAndEmails.add(nickname);
                // 排序后的邮箱
                List<String> emails = new ArrayList<>();
                for (Integer emailIndex : emailIndexes) {
                    emails.add(index2Email.get(emailIndex));
                };
                Collections.sort(emails);
                nicknameAndEmails.addAll(emails);

                res.add(nicknameAndEmails);
            }
            return res;
        }

        private int getEmailIndex(String email) {
            if (!email2Index.containsKey(email)) {
                email2Index.put(email, nextEmailIndex);
                index2Email.put(nextEmailIndex, email);
                nextEmailIndex++;
            }
            return email2Index.get(email);
        }

        static class UnionSet {

            int size;
            int[] arr;

            UnionSet(int _size) {
                this.size = _size;
                this.arr = new int[this.size];
                for (int i = 0; i < this.size; i++) {
                    this.arr[i] = i;
                }
            }

            private int find(int son) {
                return arr[son] == son ? son : (arr[son] = find(arr[son]));
            }

            private int merge(int son1, int son2) {
                return arr[find(son2)] = find(son1);
            }
        }
    }

}
