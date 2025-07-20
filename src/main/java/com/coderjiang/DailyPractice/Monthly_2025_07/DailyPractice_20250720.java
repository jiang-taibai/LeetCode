package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-20 20:19:28</p>
 */
public class DailyPractice_20250720 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final Map<String, List<PathNode>> hashToPath = new HashMap<>();

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
//            paths.sort((lhs, rhs) -> {
//                for (int i = 0; i < Math.min(lhs.size(), rhs.size()); ++i) {
//                    if (!Objects.equals(lhs.get(i), rhs.get(i))) {
//                        return lhs.get(i).compareTo(rhs.get(i));
//                    }
//                }
//                return Integer.compare(lhs.size(), rhs.size());
//            });
//            for (List<String> path : paths) {
//                System.out.println("path = " + path);
//            }
            PathNode root = new PathNode("/", "/");
            for (List<String> path : paths) {
                PathNode curr = root;
                StringBuilder sb = new StringBuilder();
                for (String folderName : path) {
                    sb.append('/');
                    sb.append(folderName);
                    if (!curr.children.containsKey(folderName)) {
                        curr.children.put(folderName, new PathNode(sb.toString(), folderName));
                    }
                    curr = curr.children.get(folderName);
                }
            }
            calculateAllPathHash(root);
            for (List<PathNode> nodes : hashToPath.values()) {
                if (nodes.size() > 1) {
                    nodes.forEach(PathNode::markDelete);
                }
            }
            List<List<String>> res = new ArrayList<>();
            for (PathNode value : root.children.values()) {
                res.addAll(removeDeletedFolder(value));
            }
            return res;
        }

        public String calculateAllPathHash(PathNode node) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, PathNode> entry : node.children.entrySet()) {
                sb.append(entry.getKey());
                sb.append('^');
                sb.append(calculateAllPathHash(entry.getValue()));
                sb.append('$');
            }
            String hash = sb.toString();
            if (!hashToPath.containsKey(hash)) {
                hashToPath.put(hash, new ArrayList<>());
            }
//            System.out.println("hash = " + hash);
            if(!hash.isEmpty()) {
                hashToPath.get(hash).add(node);
            }
            return hash;
        }

        public List<List<String>> removeDeletedFolder(PathNode node) {
            List<List<String>> res = new ArrayList<>();
            if (node.deleted) return res;
            res.add(node.absPathToList());
            for (PathNode value : node.children.values()) {
                List<List<String>> subRes = removeDeletedFolder(value);
                res.addAll(subRes);
            }
            return res;
        }
    }

    static class PathNode {
        public final String absPath;
        public final String name;
        public boolean deleted = false;
        public final Map<String, PathNode> children = new TreeMap<>();

        public PathNode(String absPath, String name) {
            this.absPath = absPath;
            this.name = name;
        }

        public void markDelete() {
            this.deleted = true;
        }

        public List<String> absPathToList() {
            String[] split = absPath.split("/");
            return Arrays.stream(split).skip(1).collect(Collectors.toList());
        }
    }

}
