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
        StringBuilder serialized = new StringBuilder();
        preorderSerialize(serialized, root);
        return serialized.toString();
    }

    // Helper method for preorder serialization
    private void preorderSerialize(StringBuilder serialized, TreeNode root) {
        if (root != null) {
            serialized.append("{" + root.val + "}");  // Append current node value
            preorderSerialize(serialized, root.left);  // Recursively serialize left subtree
            preorderSerialize(serialized, root.right); // Recursively serialize right subtree
        } else {
            serialized.append("{$}");  // Append null indicator
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList();
        int i = 0;
        while (i < data.length()) {
            int l = data.indexOf('}', i);
            String val = data.substring(i + 1, l);
            i = l + 1;
            q.add(val);
        }
        return reversePreorderDeserialize(q);
    }

    // Helper method for reverse preorder deserialization
    public TreeNode reversePreorderDeserialize(Queue<String> q) {
        String value = q.poll();
        if (value.equals("$")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = reversePreorderDeserialize(q);
        node.right = reversePreorderDeserialize(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
