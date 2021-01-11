package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.*;

/**
 * <p>创建时间：2021/1/11 14:43</p>
 * <p>主要功能：给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。</p>
 * <p>看官方题解学习到了，一个繁琐的map添加元素的写法可以用一个函数代之：</p>
 * <u>HashMap::computeIfAbsent(): 对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中。</u>
 * @author 刘江
 */
public class LeetCode_Daily_01_11 {
    public static void main(String[] args) {

    }

//    class Solution {
//        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//            char[] chars = s.toCharArray();
//            Collections.sort(pairs, (p1, p2) -> p1.get(1) != p2.get(1) ?
//                    p1.get(1).compareTo(p2.get(1)) :
//                    p2.get(0).compareTo(p1.get(0)));
//            int count = 0;
//            do {
//                count = 0;
//                for (List<Integer> list : pairs) {
//                    int a = list.get(0);
//                    int b = list.get(0);
//                    if (chars[a] > chars[b]) {
//                        char t = chars[a];
//                        chars[a] = chars[b];
//                        chars[b] = t;
//                        count++;
//                    }
//                }
//            } while (count != 0);
//            return String.valueOf(chars);
//        }
//    }

    class Solution {
        /**
         * <p>看了题解，原来是可应用并查集的图论问题</p>
         * <p>简单思路如下</p>
         * <ol>
         *     <others.li>对于[[0,1],[1,2]]pairs数组来说，可进行任意多次交换就意味着坐标0,1,2的元素可以随意排序</others.li>
         *     <others.li>使用并查集将pairs数组进行合并成大集合，对大集合中的元素进行排序即可</others.li>
         * </ol>
         *
         * @param s
         * @param pairs
         * @return
         */
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            UnionFind unionFind = new UnionFind(s.length());
            pairs.forEach(list -> unionFind.union(list.get(0), list.get(1)));
            List<List<Integer>> list = unionFind.getAllGroups();
            // 第 2 步：构建映射关系
            char[] charArray = s.toCharArray();
            // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
            Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(s.length());
            for (int i = 0; i < s.length(); i++) {
                int root = unionFind.find(i);
//            if (hashMap.containsKey(root)) {
//                hashMap.get(root).offer(charArray[i]);
//            } else {
//                PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                minHeap.offer(charArray[i]);
//                hashMap.put(root, minHeap);
//            }
                // 上面六行代码等价于下面一行代码，JDK 1.8 以及以后支持下面的写法
                hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int father = unionFind.find(i);
                sb.append(hashMap.get(father).poll());
            }
            return sb.toString();
//              这是我原排序方法，思想局部冒泡排序，但是原题的局部排序没有相交的地方，所以可以用优先队列进行排序
//            CharArr charArr = new CharArr(s);
//            list.forEach(charArr::SortInPart);
        }

        class UnionFind {
            int[] arr;

            public UnionFind(int length) {
                arr = new int[length];
                for (int i = 0; i < length; i++) {
                    arr[i] = i;
                }
            }

            // 查找父亲并且压缩路径
            public int find(int son) {
                int father = son;
                while (arr[father] != father) {
                    father = arr[father];
                }
                int curr = son;
                int curr_father = arr[son];
                while (arr[curr] != father) {
                    curr_father = arr[curr];
                    arr[curr] = father;
                    curr = curr_father;
                }
                return father;
            }

            // 合并，这里默认最大祖宗为第二个儿子的祖宗
            public int union(int son1, int son2) {
                int father1 = find(son1);
                int father2 = find(son2);
                arr[father1] = father2;
                return father2;
            }

            public List<List<Integer>> getAllGroups() {
                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int i = 0; i < arr.length; i++) {
                    int father = find(i);
                    List<Integer> list;
                    if (map.containsKey(father)) {
                        list = map.get(father);
                        list.add(i);
                    } else {
                        list = new ArrayList<>();
                        list.add(i);
                    }
                    map.put(father, list);
                }
                List<List<Integer>> ans = new ArrayList<>();
                map.forEach((key, value) -> ans.add(value));
                return ans;
            }
        }

        class CharArr {
            private char[] chars;

            public CharArr(char[] chars) {
                this.chars = chars;
            }

            public CharArr(String s) {
                this.chars = s.toCharArray();
            }

            public void SortInPart(List<Integer> list) {
                for (int i = 0; i < list.size(); i++) {
                    int lhs = list.get(i);
                    for (int j = i + 1; j < list.size(); j++) {
                        int rhs = list.get(j);
                        if (chars[lhs] > chars[rhs]) swapChars(lhs, rhs);
                    }
                }
            }

            private void swapChars(int lhs, int rhs) {
                char temp = chars[lhs];
                chars[lhs] = chars[rhs];
                chars[rhs] = temp;
            }

            @Override
            public String toString() {
                return String.valueOf(chars);
            }
        }
    }
}
