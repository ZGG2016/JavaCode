package JianZhiOffer.part3;

public class test8 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean res = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        bs(cur);
        return res;

    }
    //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
    public int bs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = bs(node.left);
        int right = bs(node.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}
