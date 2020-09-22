package jianzhioffer.part2;

public class test4 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    //˫����������ͷ�����ұ�ͷ�ڵ�
    TreeNode leftHead = null;
    TreeNode rightHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        //�ݹ����Ҷ�ӽڵ�����ҽڵ㷵��null
        if (pRootOfTree == null) return null;
        //��һ������ʱ������ʹ�����Ҷ�ӽڵ�Ϊ�����һ���ڵ�
        Convert(pRootOfTree.left);
        if (rightHead == null) {
            leftHead = rightHead = pRootOfTree;
        } else {
            //�Ѹ��ڵ���뵽˫�������ұߣ�rightHead����ƶ�
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        //����Ҷ�ӽڵ�Ҳ���뵽˫������rightHead��ȷ����ֱ�Ӳ��룩
        Convert(pRootOfTree.right);
        //�������ͷ���
        return leftHead;
    }
}
