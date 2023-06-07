class Solution {
    public int minFlips(int a, int b, int c) {
        long i = 0,count=0;
        while(c>0||b>0||a>0){
            // System.out.println(c + "??");
            if((c&1)==0){
                if((a&1)==1 && (b&1)==1) count+=2;
                else if((a&1)==1 || (b&1)==1) count++;
                // System.out.println(count+" if");
            }
            else{
                if((a&1)==0 && (b&1)==0) count+=1;
                // System.out.println(count+" else");
            }
            c>>=1;
            b>>=1;a>>=1;
        }
        return (int)count;
    }
}