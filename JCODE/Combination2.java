import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Combination2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        SolutionComb2 s = new SolutionComb2();
        System.out.println(s.combinationSum2(arr, target));

    }

}


class SolutionComb2 {
    List<List<Integer>> nums;
    int[] globCandidates;
    int globTarget;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        nums = new ArrayList<>();
        globCandidates = candidates;
        globTarget = target;
        Arrays.sort(globCandidates);
        
        findCombinations(0,new ArrayList<>(),0,false);
        return nums;
    }
    void findCombinations(int pos,List<Integer> curList ,int curSum,boolean lastTaken){
        if(curSum>globTarget) return;
        if(curSum==globTarget ) {
            nums.add(new ArrayList(curList));
            return;
        }
        if(pos>=globCandidates.length)
            return;
        
            findCombinations(pos+1,curList,curSum,false);

       
            if(curSum+globCandidates[pos]>globTarget || pos>0 && globCandidates[pos]==globCandidates[pos-1] && !lastTaken)return ;
                curList.add(globCandidates[pos]);
                findCombinations(pos+1,curList,curSum+globCandidates[pos],true);
                curList.remove(curList.size()-1);
        
        
    }
    
}


