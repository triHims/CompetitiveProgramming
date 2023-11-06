import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem2{
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        

    int k = sc.nextInt();
    int nums[ ] = new int[k];
    for(int i=0;i<k;i++){
        nums[i]=sc.nextInt();
    }
    int countNums = sc.nextInt();
    SolutionlCp2 sol = new SolutionlCp2();
    System.out.println(sol.minimalKSum(nums,countNums));
   }
}

class SolutionlCp2 {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        ArrayList<Integer> newNums = new ArrayList<>();
        copyUnique(nums,newNums);
        

        int counter = 1 ;
        int till = 0;
        long finalSum = 0;
        
        for (int i = 0; i < newNums.size() && till<k;) {
            
            if(newNums.get(i)!=counter){
                if(newNums.get(i)-counter+till < k){
                    finalSum+=suminRange(counter,newNums.get(i)-1);
                    till += (newNums.get(i)-counter);
                    counter = newNums.get(i);
                }
                else{
                    finalSum+=suminRange(counter,counter+k-till-1);
                    till=k;
                    break;
                }
                ++counter;
                ++i;
                
            }else{
                ++counter;
                ++i;
            }
        }
        if(till<k)
            finalSum+=suminRange(counter,counter+k-till-1);

        return finalSum;
        
    }


    void copyUnique(int[] arr,ArrayList<Integer> target){
        int old  = -1;
        
        for(int i=0;i<arr.length;i++){
            if(old==arr[i]){
                continue;
            }
            old = arr[i];
            target.add(arr[i]);
        }
    }


    long sumNatural(int n)
{
    long sum = ((long)n * ((long)n + 1)) / 2;
    return sum;
}
 
// Function to return the sum
// of all numbers in range L and R
long suminRange(int l, int r)
{
    return sumNatural(r) - sumNatural(l - 1);
}
}