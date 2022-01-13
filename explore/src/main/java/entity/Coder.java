package entity;


public interface Coder {
    String SEP = ",";
    String NULL = "null";

    // 把一棵二叉树序列化成字符串
     String serialize(TreeNode root);

    // 把字符串反序列化成二叉树
    TreeNode deserialize(String data);
}
