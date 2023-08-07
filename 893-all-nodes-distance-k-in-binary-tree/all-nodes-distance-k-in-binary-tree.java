/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parents  = new HashMap<>();
        findAllParents(parents,root);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while(!queue.isEmpty()){
            int n = queue.size();
            if(k==0) break;
            k--;
            for(int i=0;i<n;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null && !visited.contains(temp.left)){
                    visited.add(temp.left);
                    queue.offer(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)){
                    visited.add(temp.right);
                    queue.offer(temp.right);
                }
                if(parents.containsKey(temp) && !visited.contains(parents.get(temp))){
                    visited.add(parents.get(temp));
                    queue.offer(parents.get(temp));
                } 
            }
        }    
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
    public void findAllParents(HashMap<TreeNode,TreeNode> m, TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            TreeNode temp = queue.poll();
                if(temp.left!=null){
                    m.put(temp.left,temp);
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    m.put(temp.right,temp);
                    queue.offer(temp.right);
                }
        }
    }
}