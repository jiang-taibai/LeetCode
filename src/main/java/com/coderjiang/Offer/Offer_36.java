package com.coderjiang.Offer;


/**
 * <p>Creation Time: 2021-12-17 20:48:05</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_36 {

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        public Node treeToDoublyList(Node root) {
            change(root);
            Node minNode = root;
            Node maxNode = root;
            while (minNode.left != null) minNode = minNode.left;
            while (maxNode.right != null) maxNode = maxNode.right;
            minNode.left = maxNode;
            maxNode.right = minNode;
            return minNode;
        }

        private void change(Node root) {
            Node left = root.left;
            Node right = root.right;
            root.left = findPreNode(root.left);
            root.right = findPreNode(root.right);
            change(left);
            change(right);
        }

        private Node findPreNode(Node root) {
            if (root == null) return null;
            if (root.right == null) return root;
            else return findPreNode(root.right);
        }

        private Node findNextNode(Node root) {
            if (root == null) return null;
            if (root.left == null) return root;
            else return findPreNode(root.left);
        }

        class Node {
            public int val;
            public Node left;
            public Node right;

            public Node() {
            }

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, Node _left, Node _right) {
                val = _val;
                left = _left;
                right = _right;
            }
        }

        ;
    }

}
