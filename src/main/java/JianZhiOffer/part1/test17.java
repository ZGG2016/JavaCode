package JianZhiOffer.part1;

public class test17 {


     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;

         }
     }
    //（ps：我们约定空树不是任意一个树的子结构）
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

    //短路特性
    //逻辑运算符的短路特性
    //1. &&的短路特性: 因为程序从左往右执行的，当判断左边为false时&&的返回结果就已经注定是false ,
    //所以后面的判断计算机就不执行了.
    //
    //2. || 的短路特性：因为程序是从左往右执行，当判断左边为true时 返回结果就已经注定是 true，
    // 所以后面的判断计算机不执行
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
