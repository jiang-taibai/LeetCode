package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.*;

/**
 * <p>创建时间：2021/1/18 11:58</p>
 * <p>主要功能：给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_18 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Integer> emailToIndex = new HashMap<>();
            Map<String, String> emailToName = new HashMap<>();
            int emailCount = 0;
            for (List<String> list : accounts) {
                String name = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    if (!emailToIndex.containsKey(list.get(i))) {
                        emailToIndex.put(list.get(i), emailCount++);
                        emailToName.put(list.get(i), name);
                    }
                }
            }
            UnionFind unionFind = new UnionFind(emailCount);
            for (List<String> list : accounts) {
                String firstEmail = list.get(1);
                for (int i = 2; i < list.size(); i++) {
                    unionFind.union(emailToIndex.get(firstEmail), emailToIndex.get(list.get(i)));
                }
            }
            Map<Integer, List<String>> emailCollections = new HashMap<>();
            for (String email : emailToIndex.keySet()) {
                int father = unionFind.find(emailToIndex.get(email));
                List<String> currList = emailCollections.getOrDefault(father, new ArrayList<>());
                currList.add(email);
                emailCollections.put(unionFind.find(emailToIndex.get(email)), currList);
            }
            List<List<String>> answer = new ArrayList<>();
            for (Integer index : emailCollections.keySet()) {
                List<String> list = emailCollections.get(index);
                List<String> perData = new ArrayList<>();
                perData.add(emailToName.get(list.get(0)));
                Collections.sort(list);
                perData.addAll(list);
                answer.add(perData);
            }
            return answer;
        }

        class UnionFind {
            int[] arr;

            public UnionFind(int size) {
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
            }

            public int find(int son) {
                int father = arr[son];
                while (father != arr[father]) {
                    father = arr[father];
                }
                int next = son;
                while (arr[son] != father) {
                    next = arr[son];
                    arr[son] = father;
                    son = father;
                }
                return father;
            }

            public void union(int son1, int son2) {
                arr[find(son2)] = find(son1);
            }
        }
    }
}
