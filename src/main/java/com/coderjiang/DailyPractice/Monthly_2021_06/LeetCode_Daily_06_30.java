package com.coderjiang.DailyPractice.Monthly_2021_06;



import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_Daily_06_30 {

    public static class Codec {

        private int index = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> res = toList(root);
            return CodecUtil.toString(res);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<String> list = CodecUtil.parseList(data);
            return toTreeNode(list);
        }

        private List<String> toList(TreeNode root) {
            List<String> res = new ArrayList<>();
            return dfs(root, res);
        }

        private List<String> dfs(TreeNode root, List<String> list) {
            if (root == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(root.val));
                dfs(root.left, list);
                dfs(root.right, list);
            }
            return list;
        }

        private TreeNode toTreeNode(List<String> list) {
            if (list.size() == 0) return null;
            this.index = 0;
            return dfs(list);
        }

        private TreeNode dfs(List<String> list) {
            TreeNode node = null;
            if (!list.get(index).equals("null")) {
                node = new TreeNode();
                node.val = Integer.parseInt(list.get(index));
                index += 1;
                node.left = dfs(list);
                index += 1;
                node.right = dfs(list);
            }
            return node;
        }

        static class CodecUtil {

            public static String toString(List<String> list) {
                // [1,2,3,null,null,4,5]
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    sb.append(i == list.size() - 1 ? "]" : ",");
                }
                return sb.toString();
            }

            public static List<String> parseList(String data) {
                return new ArrayList<>(Arrays.asList(data.substring(1, data.length() - 1).split(",")));
            }

            public static void main(String[] args) {
                List<String> res = parseList("[]");
                System.out.println(Arrays.toString(res.toArray()));
            }
        }
    }

}