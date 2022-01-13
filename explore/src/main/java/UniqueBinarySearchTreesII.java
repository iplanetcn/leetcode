import entity.TreeNode;
import utils.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }

        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n){
        List<TreeNode> result = new ArrayList<>();
        if(m>n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1);
            List<TreeNode> rs = helper(i+1, n);
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        for (TreeNode generateTree : new UniqueBinarySearchTreesII().generateTrees(4)) {
            TreeNodePrinter.preOrder(generateTree);
            System.out.println();
            TreeNodePrinter.inOrder(generateTree);
            System.out.println();
            TreeNodePrinter.postOrder(generateTree);
            System.out.println();
            System.out.println("-------------------------");
        }
    }
}
