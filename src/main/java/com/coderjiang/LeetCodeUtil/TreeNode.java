package com.coderjiang.LeetCodeUtil;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] array) {
        return createTreeFromArray(array, 0);
    }

    private static TreeNode createTreeFromArray(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = createTreeFromArray(array, 2 * index + 1);
        node.right = createTreeFromArray(array, 2 * index + 2);

        return node;
    }
}