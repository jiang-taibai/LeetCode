package com.coderjiang.DailyPractice.Monthly_2025_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-08-06 21:49:04</p>
 */
public class DailyPractice_20250806 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int n = fruits.length;
            Node root = buildTree(baskets, 0, n - 1);
            int res = 0;
            for (int fruit : fruits) {
                if (!trySetFruit(fruit, root)) {
                    ++res;
                }
            }
            return res;
        }

        class Node {
            int maxBasket = -1;
            int rangeLeft;
            int rangeRight;
            Node father;
            Node left;
            Node right;

            Node(int rangeLeft, int rangeRight) {
                this.rangeLeft = rangeLeft;
                this.rangeRight = rangeRight;
            }

            boolean isLeaf() {
                return rangeLeft == rangeRight;
            }
        }

        private Node buildTree(int[] baskets, int left, int right) {
            // System.out.printf("%d,%d\n", left, right);
            int n = baskets.length;
            if (left > right) return null;
            Node root = new Node(left, right);
            if (left == right) {
                root.maxBasket = baskets[left];
            } else {
                int mid = (left + right) / 2;
                root.left = buildTree(baskets, left, mid);
                root.right = buildTree(baskets, mid + 1, right);
                if (root.left != null) {
                    root.left.father = root;
                    root.maxBasket = Math.max(root.maxBasket, root.left.maxBasket);
                }
                if (root.right != null) {
                    root.right.father = root;
                    root.maxBasket = Math.max(root.maxBasket, root.right.maxBasket);
                }
            }
            return root;
        }

        private boolean trySetFruit(int fruit, Node root) {
            Node node = root;
            while (!node.isLeaf() && node.maxBasket >= fruit) {
                if (node.left != null && node.left.maxBasket >= fruit) {
                    node = node.left;
                } else if (node.right != null && node.right.maxBasket >= fruit) {
                    node = node.right;
                } else {
                    break;
                }
            }
            if (node.isLeaf() && node.maxBasket >= fruit) {
                node.maxBasket = -1;
                while (node.father != null) {
                    node = node.father;
                    int maxBasket = -1;
                    if (node.left != null) {
                        maxBasket = Math.max(maxBasket, node.left.maxBasket);
                    }
                    if (node.right != null) {
                        maxBasket = Math.max(maxBasket, node.right.maxBasket);
                    }
                    node.maxBasket = maxBasket;
                }
                return true;
            }
            return false;
        }
    }

/*
4 -> 5, 4    -> 2
2 -> 3, 5, 4 -> 3
5 -> 5       -> 1
*/

}
