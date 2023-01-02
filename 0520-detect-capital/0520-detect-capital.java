class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if(allcapital(arr)) return true;
        else if(allsmall(arr)) return true;
        else if(arr[0]>='A' && arr[0]<='Z' && arr[1]>='a' && arr[1]<='z'){
            if(allsmall(arr,2)) return true;
            else return false;
        }
        else return false;
    }

    public boolean allcapital(char[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='A' && arr[i]<='Z') continue;
            else return false;
        }
        return true;
    }
    public boolean allsmall(char[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='a' && arr[i]<='z') continue;
            else return false;
        }
        return true;
    }
    public boolean allsmall(char[] arr,int a){
        for(int i=a;i<arr.length;i++){
            if(arr[i]>='a' && arr[i]<='z') continue;
            else return false;
        }
        return true;
    }
}