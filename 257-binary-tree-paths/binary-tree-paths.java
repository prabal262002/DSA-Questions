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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        rcrs(root,"",ans);
        return ans;
    }
    public void rcrs(TreeNode root,String s,ArrayList<String> l){
        if(root==null) return;
        
        if(root.left==null && root.right==null){
            s+="->" + root.val;
            l.add(s.substring(2));
        }
        
        s+="->" + root.val;

        rcrs(root.left,s,l);
        rcrs(root.right,s,l);
    }
}