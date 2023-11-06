public class singleduplicate {
    
}

class Solution {
    int singleDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        while(low<high){
                int mid = (low+high)/2;

                    // System.out.println(mid+" low "+low+" high "+high);
                if(mid%2==1){
                    if(nums[mid-1]==nums[mid]){
                        low=mid+1;
                    }else{
                        high = mid;
                    }
                } else {
                    if(nums[mid]==nums[mid+1]){
                        low = mid+1;
                    }else{
                        high = mid;
                    }
                }

        }
        return nums[low];
    }
    public int search(int[] nums, int target) {
        int low = 1;
        int high = nums.length-1;
        while(low<high){
                int mid = (low+high)/2;

                    // System.out.println(mid+" low "+low+" high "+high);
               if(nums[mid-1]<nums[mid]){
                    low=mid+1;
               }else{
                  high=mid;
               }

        }
        return nums[low]<nums[low-1]?low:-1;
    }
    public static void main(String[] args) {
        
    }
}
