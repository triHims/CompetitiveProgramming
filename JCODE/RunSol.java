import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunSol{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=sc.nextInt();
        }

        int k = sc.nextInt();
        Solution s = new Solution();
        System.out.println(s.findKthLargest(arr, k));
        
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return KthLargest(nums,0,nums.length-1, nums.length-k);
    }

    int KthLargest(int []arr,int low,int high ,int k){
        
        while(low<high){
            int pos = partition(arr, low, high);
            if(pos==k){
                return arr[pos];
            }
            else if(k<pos){
                high = pos-1;
                // System.out.println("High is - " + high);
            }else{
                low = pos+1;
                // System.out.println("low is - "+low);
            }

        }

        return arr[low];
    }

    int partition(int arr[],int low,int high){
        double pos = Math.random()*(high-low+1);
        int val = low+(int)pos;

        swap(arr, val, high);

        int pivot = arr[high];

        int sorted = low-1;

        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                ++sorted;
                swap(arr, sorted, i);
            }
        }

        swap(arr, sorted+1, high);
        return sorted+1;
    }

    void swap(int arr[],int a,int b){
        int t  = arr[a];
        arr[a]=arr[b];
        arr[b]=t;
        
    }
}

class MutableInt{
    int val=0;
    MutableInt(int inp){
        this.val=inp;
    }

    void increment(){
        ++val;
    }

    void decrement(){
        --val;

    }

    void setVal(int nval){
        this.val = nval;
    }

    int value(){
        return this.val;
    }
    
    public String toString(){
        return String.valueOf(this.val);
    }

    public static MutableInt build(int val){
        return new MutableInt(val);
    }
}