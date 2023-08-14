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
class BSTIterator {
    Stack<TreeNode> stck;
    public BSTIterator(TreeNode root) {
        stck = new Stack<>();
        pushLeft(root);
    }
    
    public int next() {
        TreeNode node = stck.pop();
        if(node.right!=null){
            pushLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stck.isEmpty();
    }

    public void pushLeft(TreeNode root){
        while(root!=null){
            stck.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */