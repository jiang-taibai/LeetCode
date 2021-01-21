package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.*;

/**
 * <p>创建时间：2021/1/21 9:02</p>
 * <p>主要功能：给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_21 {
    public static void main(String[] args) {

    }

    class Solution {
        private List<List<Integer>> allTreeEdge = new ArrayList<>();

        /**
         * 解题思路：
         * 1. 先找到每一种最小生成树的子集，得到所包含边的集合，加入到list链表中
         * 2. 将所有最小生成树的边集合进行交运算得到【关建边】
         * 3. 将每个集合减去【关建边】得到伪关建边
         *
         * @param n
         * @param edges
         * @return
         */
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
            int count = 0;
            for (int[] edge : edges) {
                edgeQueue.add(new Edge(edge[0], edge[1], edge[2], count++));
            }
            UnionFind uf = new UnionFind(n);    // n个点的并查集
            generateMinTree(edgeQueue, uf, new ArrayList<>());
            return handle();
        }

        private List<List<Integer>> handle() {
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            if (allTreeEdge.size() == 0) return ans;
            for (int i = 0; i < allTreeEdge.size(); i++) {
                for (int index : allTreeEdge.get(i)) {
                    map.putIfAbsent(index, 0);
                    map.put(index, map.get(index) + 1);
                }
            }
            List<Integer> keyEdge = new ArrayList<>();
            List<Integer> fakeKeyEdge = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == allTreeEdge.size()) {
                    keyEdge.add(entry.getKey());
                } else {
                    fakeKeyEdge.add(entry.getKey());
                }
            }
            ans.add(keyEdge);
            ans.add(fakeKeyEdge);
            return ans;
        }

        // 递归地生成每一种树，当uf.getCategory()==1时，说明所有节点只有一个祖先
        private void generateMinTree(PriorityQueue<Edge> edges, UnionFind uf, ArrayList<Integer> edgeIndex) {
            // 如果已经找到了，那么就加入到队列中
            if (uf.getCategory() == 1) {
                allTreeEdge.add(edgeIndex);
                System.out.println(Arrays.toString(edgeIndex.toArray()));
                return;
            }
            if (edges.isEmpty()) return;
            Edge edge = edges.peek();
            while (uf.isFamily(edge.getFrom(), edge.getTo()) && !edges.isEmpty()) {
                edges.poll();
                edge = edges.peek();
                
            }
            int weight = edge.getWeight();
            while(!edges.isEmpty() && edges.peek().getWeight() == weight) {
                edge = edges.poll();
                if(!uf.isFamily(edge.getFrom(), edge.getTo())) {
                    PriorityQueue<Edge> copy_edges = new PriorityQueue<>(edges);
                    ArrayList<Integer> copy_index = new ArrayList<>(edgeIndex);
                    UnionFind copy_uf = uf.clone();
                    copy_uf.union(edge.getFrom(), edge.getTo());
                    copy_index.add(edge.getIndex());
                    generateMinTree(copy_edges, copy_uf, copy_index);
                }
            }
        }

        class UnionFind implements Cloneable {
            private int[] arr;

            public UnionFind(int size) {
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
            }

            public UnionFind(int[] arr) {
                this.arr = arr.clone();
            }

            public int find(int son) {
                int father = arr[son];
                while (father != arr[father]) father = arr[father];
                while (father != arr[son]) {
                    int next = arr[son];
                    arr[son] = father;
                    son = next;
                }
                return father;
            }

            public void union(int son1, int son2) {
                arr[find(son1)] = find(son2);
            }

            public boolean isFamily(int son1, int son2) {
                return find(son1) == find(son2);
            }

            public int getCategory() {
                int count = 0;
                for (int i = 0; i < arr.length; ++i) {
                    if (i == find(i)) ++count;
                }
                return count;
            }

            @Override
            public UnionFind clone() {
                return new UnionFind(arr);
            }
        }

        // 带权无向边
        class Edge implements Comparable<Edge> {
            private int from;
            private int to;
            private int weight;
            private int index;  // 边在数组中的坐标

            public Edge(int from, int to, int weight, int index) {
                this.from = from;
                this.to = to;
                this.weight = weight;
                this.index = index;
            }

            public int getFrom() {
                return from;
            }

            public int getTo() {
                return to;
            }

            public int getWeight() {
                return weight;
            }

            public int getIndex() {
                return index;
            }

            @Override
            public int compareTo(Edge o) {
                return weight - o.weight;
            }
        }
    }
}
