import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class minimumKSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        SolutioMiniK s = new SolutioMiniK();
        System.out.println(s.minimalKSum(arr, target));

    }

}

class SolutioMiniK{
    public long minimalKSum(int[] nums, int k) {
            Arrays.sort(nums);
            ArrayList<Integer> numSet  =copyUnique(nums);

            if(numSet.get(numSet.size()-1)<=k+numSet.size()){
                int total = k+numSet.size();
                return total*(total+1)/2-getSum(numSet);
            }


            int low = 0,high = numSet.size()-1;
            while(high>low){
                int mid = low+(high-low)/2;
                if(numSet.get(mid)-mid-1 <= k){
                    low= mid+1;
                }else{
                    high=mid;
                }
            }
            // System.out.println("Low her eis "+ low );
            return (k+(long)low)*((long)k+low+1)/2 - getSum(numSet, low+1);
    }
    ArrayList<Integer> copyUnique(int[] arr){
        ArrayList<Integer> target=new ArrayList<>();
        int old  = -1;
        
        for(int i=0;i<arr.length;i++){
            if(old==arr[i]){
                continue;
            }
            old = arr[i];
            target.add(arr[i]);
        }
        return target;
    }

    long getSum(ArrayList<Integer> a,int... num){
        long sum = 0;
        int n  = num.length>0?num[0]:Integer.MAX_VALUE;
        for (int j = 0; j < a.size() && j<n; j++) {
         
            sum+=(long)a.get(j);
        }
        return sum;
    }
}
