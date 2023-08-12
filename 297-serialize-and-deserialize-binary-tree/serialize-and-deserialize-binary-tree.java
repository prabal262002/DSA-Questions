/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder l = new StringBuilder();
        preorder(l,root);
        return l.toString();
    }
    public void preorder(StringBuilder l,TreeNode root){
        if(root!=null){
            l.append("{"+root.val+"}");
            preorder(l,root.left);
            preorder(l,root.right);
        }
        else l.append("{$}");
    } 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList();
        int i=0;
        while(i<data.length()){
            int l = data.indexOf('}',i);
            String val= data.substring(i+1,l);
            i = l+1;
            q.add(val);
        }
        return rvrspre(q);
    }

    public TreeNode rvrspre(Queue<String> q){
        String value = q.poll();
        if(value.equals("$")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = rvrspre(q);
        node.right = rvrspre(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));