package JianZhiOffer.part5;

import java.util.Stack;

public class test5 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

        int count = 0;

        TreeNode KthNode(TreeNode pRoot, int k) {
            if (count > k || pRoot == null)
                return null;
            TreeNode p = pRoot;
            Stack<TreeNode> LDRStack = new Stack<TreeNode>();
            TreeNode kthNode = null;
            while (p != null || !LDRStack.isEmpty()) {
                while (p != null) {
                    LDRStack.push(p);
                    p = p.left;
                }
                TreeNode node = LDRStack.pop();
                System.out.print(node.val + ",");
                count++;
                if (count == k) {
                    kthNode = node;
                }
                p = node.right;
            }
            return kthNode;
        }
}
