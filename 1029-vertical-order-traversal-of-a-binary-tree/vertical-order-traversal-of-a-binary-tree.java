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
    class Vrtcl{
        int v;
        int h;
        TreeNode val;
        Vrtcl(int v, int h, TreeNode val){
            this.v=v;
            this.h=h;
            this.val=val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(root== null) return ans;

        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> m = new TreeMap<>();
        Queue<Vrtcl> q = new LinkedList<>();
    
        q.offer(new Vrtcl(0,0,root));
        while(!q.isEmpty()){
            Vrtcl temp = q.poll();
            TreeNode node = temp.val;
            int v = temp.v;
            int h = temp.h;

            if(!m.containsKey(v)){
                m.put(v,new TreeMap<>());
            }
            if(!m.get(v).containsKey(h)){
                m.get(v).put(h,new ArrayList<>());
            }
            m.get(v).get(h).add(node.val);

            if(node.left!=null) {
                q.offer(new Vrtcl(v-1,h+1,node.left));
            }
            if(node.right!=null) {
                q.offer(new Vrtcl(v+1,h+1,node.right));
            }
        }
        for (Integer v : m.keySet()) {
            List<Integer> levelList = new ArrayList<>();
            for (Integer h : m.get(v).keySet()) {
                ArrayList<Integer> temp = m.get(v).get(h);
                Collections.sort(temp);
                levelList.addAll(temp);
            }
            ans.add(levelList);
        }
        return ans;      
    }
}