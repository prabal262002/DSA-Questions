class Solution {
    class VerticalNode {
        int v;
        int h;
        TreeNode node;

        VerticalNode(int v, int h, TreeNode node) {
            this.v = v;
            this.h = h;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // TreeMap to store vertical levels of nodes, with each level sorted by horizontal distance (h).
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> verticalMap = new TreeMap<>();

        Queue<VerticalNode> queue = new LinkedList<>();
        queue.offer(new VerticalNode(0, 0, root));

        while (!queue.isEmpty()) {
            VerticalNode tempNode = queue.poll();
            TreeNode node = tempNode.node;
            int v = tempNode.v; // Vertical distance of the node from the root
            int h = tempNode.h; // Horizontal distance of the node from the root

            // Add the node value to the verticalMap at its respective vertical and horizontal levels.
            verticalMap.putIfAbsent(v, new TreeMap<>());
            verticalMap.get(v).putIfAbsent(h, new ArrayList<>());
            verticalMap.get(v).get(h).add(node.val);

            // Explore the left and right children of the current node in the tree.
            if (node.left != null) {
                queue.offer(new VerticalNode(v - 1, h + 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new VerticalNode(v + 1, h + 1, node.right));
            }
        }

        // Convert the verticalMap into the final result list.
        for (Integer v : verticalMap.keySet()) {
            List<Integer> levelList = new ArrayList<>();
            for (Integer h : verticalMap.get(v).keySet()) {
                List<Integer> temp = verticalMap.get(v).get(h);
                Collections.sort(temp); // Sort the nodes at the same vertical level by their values.
                levelList.addAll(temp);
            }
            result.add(levelList);
        }

        return result;
    }
}
