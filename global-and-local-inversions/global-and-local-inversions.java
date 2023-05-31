class Solution {
    static int ans;
    private static void merge(int arr[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int k = 0;
        int l = start, r = mid + 1;
        for (;l <= mid && r <= end;) {
            if (arr[l] <= arr[r])
                temp[k++] = arr[l++];
            else{
                ans += mid - l + 1;   
                temp[k++] = arr[r++];
            }
        }

        for (;l <= mid;)
            temp[k++] = arr[l++];

        for (;r <= end;)
            temp[k++] = arr[r++];

        for (int i = start, j = 0; i <= end; ++i, ++j) {
            arr[i] = temp[j];
        }
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static int countInversions(int arr[]){
        ans = 0;
        mergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    int localInversions(int arr[]){
        int cnt = 0;
        for(int i = 0;i < arr.length - 1;i++){
            if(arr[i] > arr[i + 1]) cnt++;
        }
        return cnt;
    }
    public boolean isIdealPermutation(int[] nums) {
        return localInversions(nums) == countInversions(nums);
    }
}