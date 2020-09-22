package jianzhioffer.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test22 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
/*
* 用arraylist模拟一个队列来存储相应的TreeNode
*
*
* */

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();

        if(root==null) return al;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            al.add(tmp.val);

            if(tmp.left!=null){
                queue.offer(tmp.left);
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
            }
        }
        return al;
    }
}
