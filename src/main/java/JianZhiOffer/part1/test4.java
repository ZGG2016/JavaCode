package JianZhiOffer.part1;

public class test4 {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        TreeNode root = helper(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    public TreeNode helper(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){

        if(startPre>endPre || startIn>endIn){  //越界即左右子节点不存在
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++){
            if(in[i]==pre[startPre]){
                 root.left = helper(pre, startPre+1,startPre+i-startIn,
                        in,startIn,i-1);
                 root.right = helper(pre,startPre+i-startIn+1,endPre,
                        in,i+1,endIn);
                break;
            }
        }
        return root;
    }
}

/*
*
* startPre+i-startIn：左子树长度为i-startIn
*
*
* startPre+i-startIn+1：
* 从startPre位置越过左孩子及其子节点的偏移量
* （即i-startIn，因为startIn和i之间全是i这个元素的左孩子及其子节点）
* 再往下一个节点走（即右孩子起始点），如果写成startPre+(i-startIn)+1可能要容易看懂些，
*
* */