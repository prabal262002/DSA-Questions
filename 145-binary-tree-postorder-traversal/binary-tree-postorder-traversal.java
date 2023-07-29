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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        if(root == null) return l;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            l.add(curr.val);
            if(curr.left!= null) st.push(curr.left);
            if(curr.right!= null) st.push(curr.right);
        }
        Collections.reverse(l);
        return l;
    }
}