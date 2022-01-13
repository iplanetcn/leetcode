import entity.TreeNode;
import utils.TreeNodePrinter;

/**
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        } else {
            TreeNode left = searchBST(root.left, val);
            TreeNode right = searchBST(root.right, val);

            return left != null ? left : right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        System.out.println(TreeNodePrinter.traversePreOrder(root));
        TreeNodePrinter.preOrder(root);
        System.out.println();
        TreeNodePrinter.inOrder(root);
        System.out.println();
        TreeNodePrinter.postOrder(root);
        System.out.println();
        TreeNodePrinter.levelOrder(root);
        System.out.println();

        TreeNode result = new SearchInABinarySearchTree().searchBST(root, 3);
        System.out.println(result);
    }

    private static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(4);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(2);
        l2.left = l1;
        l2.right = r1;
        root.left = l2;
        root.right = new TreeNode(7);
        return root;
    }
}
