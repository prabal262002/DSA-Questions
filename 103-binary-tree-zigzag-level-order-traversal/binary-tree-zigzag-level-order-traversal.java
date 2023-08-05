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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root== null) return ans;
        boolean flag = false;
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                l.add(q.poll().val);
            }
            if(flag) Collections.reverse(l);
            flag = (flag==true)?false:true;
            ans.add(l);
        }
        return ans;
    }
}