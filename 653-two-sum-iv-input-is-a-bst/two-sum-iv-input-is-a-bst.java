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
 public class BSTIterator {
    Stack<TreeNode> stck;
    boolean reverse=false;
    public BSTIterator(TreeNode root, boolean isreverse) {
        reverse = isreverse;
        stck = new Stack<>();
        pushLeftOrRight(root);
    }
    
    public int next() {
        TreeNode node = stck.pop();
        if(!reverse){
            if(node.right!=null){
                pushLeftOrRight(node.right);
            }
        }
        else {
            if(node.left!=null){
                pushLeftOrRight(node.left);
            }
        }
        return node.val;
    }

    public void pushLeftOrRight(TreeNode root){
        while(root!=null){
            stck.push(root);
            if(!reverse)   root=root.left;
            else root = root.right;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();    //Previous
        while(i<j){
            if(i+j==k) return true;
            if(i+j<k) i = l.next();
            else j = r.next();   //Previous
        }
        return false;
    }
  
}