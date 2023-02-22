class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        List<Integer> row,pre = null;
        // l.add(new ArrayList<Integer>());
        // l.get(0).add(1);
        for(int i =0;i<numRows;i++){
            row = new ArrayList<Integer>();
            // l.add(new ArrayList<Integer>(i+1));
            // l.get(i).add(1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) row.add(1);
                else row.add(pre.get(j)+pre.get(j-1));
            }
            pre = row;
            l.add(row);
        }
        return l;
    }
}