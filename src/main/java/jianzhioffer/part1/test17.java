package jianzhioffer.part1;

public class test17 {


     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;

         }
     }
    //��ps������Լ��������������һ�������ӽṹ��
    public boolean HasSubtree1(TreeNode root1,TreeNode root2){
        boolean rlt = false;

        if(root1!=null && root2!=null){
            if(root1.val==root2.val){
                return isSubTree1(root1,root2);
            }

            if(rlt){
                return HasSubtree1(root1.left,root2);
            }
            if(rlt){
                return HasSubtree1(root1.right,root2);
            }
        }

        return rlt;
    }
    private boolean isSubTree1(TreeNode node1,TreeNode node2){
         if(node1==null){
             return false;
         }
         if(node2==null){
             return true;
         }

         if(node1.val!=node2.val){
             return false;
         }

         return isSubTree1(node1.left,node2.left) && isSubTree1(node1.right,node2.right);
    }

    //��·����
    //�߼�������Ķ�·����
    //1. &&�Ķ�·����: ��Ϊ�����������ִ�еģ����ж����Ϊfalseʱ&&�ķ��ؽ�����Ѿ�ע����false ,
    //���Ժ�����жϼ�����Ͳ�ִ����.
    //
    //2. || �Ķ�·���ԣ���Ϊ�����Ǵ�������ִ�У����ж����Ϊtrueʱ ���ؽ�����Ѿ�ע���� true��
    // ���Ժ�����жϼ������ִ��
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
         if(root1==null || root2==null) return false;
         return isSubTree(root1,root2) ||
                 HasSubtree(root1.left,root2)||
                 HasSubtree(root2.right,root2);
    }
    private boolean isSubTree(TreeNode node1,TreeNode node2){
        if(node2==null){
            return true;
        }
        if(node1==null){
            return false;
        }

        if(node1.val==node2.val){
            return isSubTree(node1.left,node2.left) && isSubTree(node1.right,node2.right);
        }else{
            return false;
        }
    }
}
