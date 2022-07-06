package problems.ds;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class ContainerShipped {

    public int shipWithinDays(int[] weights, int days) {
        int lo= -1, hi= 0;
        for(int w : weights){
            lo= Math.max(w, lo);
            hi+=w;
        }
        while(lo < hi){
            int mid= (lo + hi)/2;
            if(canShipped(weights, days, mid)){
                //ans= mid;
                hi= mid;
            }
            else{
                lo= mid+1;
            }
        }
        return lo;
    }

    public boolean canShipped(int[] weights, int days, int capacity){
        //System.out.println(capacity);
        int day=0;
        int curr=0;
        for(int w : weights){
            if(curr + w > capacity){
                day++;
                curr=0;
            }
            curr+= w;
        }
        return day < days;
    }

    boolean check(int arr[], int mid, int n, int d){
        int sum = 0;
        int days = 1;
        for(int i=0; i<n; i++){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }
            else{
                sum = arr[i];
                days++;
            }
        }
        if(days <= d) return true;
        return false;
    }

    public int shipWithinDays1(int[] arr, int days) {
        int n = arr.length;
        int sum = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            sum += arr[i];
        }

        int start = max;
        int end = sum;
        int res = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(arr, mid, n, days)){
                res = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return res;
    }
}
