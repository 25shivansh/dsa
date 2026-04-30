/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return preorder(root,Integer.MIN_VALUE,0);
        
    }
    private int preorder(TreeNode root,int max, int count){
        if(root==null){
            return count ;
        }
        if(root.val>=max){
            count ++;
        }
        max=Math.max(max,root.val);
        count =preorder(root.left,max,count);
        count =preorder(root.right,max,count);
        return count ;
    }
}