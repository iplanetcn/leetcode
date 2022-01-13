package entity;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("v->").append(val);
        if (left != null) {
            sb.append(",l->").append(left);
        }

        if (right != null) {
            sb.append(",r->").append(right);
        }
        sb.append("}");

        return sb.toString();
    }
}
