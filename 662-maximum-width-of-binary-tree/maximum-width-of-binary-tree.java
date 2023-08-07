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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qi = new LinkedList<>();

        int ans=0;

        q.offer(root);
        qi.offer(0);

        while(!q.isEmpty()){

            int first=0,last=0;
            int n = q.size();
            int index = qi.peek(); // to make the id starting from 0.

            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                int curri= qi.poll()-index;// Now it will be zero.

                if(i==0) first = curri;
                if(i==n-1) last = curri;

                if(temp.left!=null) {
                    q.offer(temp.left);
                    qi.offer(curri*2+1);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                    qi.offer(curri*2+2);
                }
            }
            ans = Math.max(last-first+1,ans);
        }
        return ans;
    }
}