package algorithms;

/*
* 求二叉树深度
* */
public class DepthofBinaryTree {

    public static void main(String[] agrs){

    }

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) +1;

    }
}
