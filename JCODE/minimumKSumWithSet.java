import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class minimumKSumWithSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        SolutioMiniKSet s = new SolutioMiniKSet();
        System.out.println(s.minimalKSum(arr, target));

    }

}

class SolutioMiniKSet{
    public long minimalKSum(int[] nums, int k) {
            HashSet<Integer> hs = new HashSet<>();

            int runK = k;
            long runSum =0;

            for (int i = 0; i < nums.length; i++) {
                if(!hs.contains(nums[i]) && nums[i]<=runK ){
                    ++runK;
                    runSum +=nums[i];

                }
                hs.add(nums[i]);
            }

            return (long)k*(k+1)/2 -runSum;
    }
    
}
