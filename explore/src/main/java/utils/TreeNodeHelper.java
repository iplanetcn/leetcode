package utils;

import entity.TreeNode;

public class TreeNodeHelper {
    /**
     * A function that constructs Balanced Binary Search Tree from a sorted array
     */
    public static TreeNode sortedArrayToBST(int[] arr, int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    // function to get a new node
    private static TreeNode getNode(int data) {
        // Allocate memory
        TreeNode newNode = new TreeNode();

        // put in the data
        newNode.val = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    // function to construct a BST from its level order traversal
    private static TreeNode LevelOrder(TreeNode root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.val) {
            root.left = LevelOrder(root.left, data);
        } else {
            root.right = LevelOrder(root.right, data);
        }
        return root;
    }

    public static TreeNode levelOrderArrayToBST(int[] arr, int n) {
        if (n == 0) return null;
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            root = LevelOrder(root, arr[i]);
        }
        return root;
    }
}
