package jianzhioffer.part2;

import java.util.ArrayList;

public class test2 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> rlt = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> al = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null) return rlt;

        al.add(root.val);
        target-=root.val;
        if(target==0 && root.left==null && root.right==null){
            rlt.add(new ArrayList<>(al));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);
        al.remove(al.size()-1);
        return rlt;
    }
}
