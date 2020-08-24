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

        if(startPre>endPre || startIn>endIn){  //Խ�缴�����ӽڵ㲻����
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
* startPre+i-startIn������������Ϊi-startIn
*
*
* startPre+i-startIn+1��
* ��startPreλ��Խ�����Ӽ����ӽڵ��ƫ����
* ����i-startIn����ΪstartIn��i֮��ȫ��i���Ԫ�ص����Ӽ����ӽڵ㣩
* ������һ���ڵ��ߣ����Һ�����ʼ�㣩�����д��startPre+(i-startIn)+1����Ҫ���׿���Щ��
*
* */