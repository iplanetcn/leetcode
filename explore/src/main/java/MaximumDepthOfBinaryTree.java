import entity.LevelTraverseCoder;
import entity.TreeNode;
import utils.TreeNodePrinter;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lHeight = maxDepth(root.left);
            int rHeight = maxDepth(root.right);

            /* use the larger one */
            if (lHeight > rHeight) {
                return (lHeight + 1);
            } else {
                return (rHeight + 1);
            }
        }
    }

    public static void main(String[] args) {
        String stn = "3,9,20,null,null,15,7";
        LevelTraverseCoder coder = new LevelTraverseCoder();
        TreeNode treeNode = coder.deserialize(stn);
        System.out.println(TreeNodePrinter.traversePreOrder(treeNode));
        System.out.println(coder.serialize(treeNode));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(treeNode));
    }
}
