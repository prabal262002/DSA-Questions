class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> m = new HashMap<>();
        // int[] arr = new int[1000000000];
        for(int i=0;i<tasks.length;i++){
            m.put(tasks[i],m.getOrDefault(tasks[i],0)+1);
        }
        int ans=0;
        for(int i: m.values()){
                if(i==1 )  return -1;
                // else if(i%2==0)  {ans+=i/2; i%=2;}
                ans+=i/3;
                if(i%3!=0) ans++;
                // ans+=i/2; i%=2;
                
        }
        return ans;
    }
}