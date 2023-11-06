import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        SolutionComb s = new SolutionComb();
        System.out.println(s.combinationSum(arr, target));

    }

}


class SolutionComb {
    List<List<Integer>> nums;
    int[] globCandidates;
    int globTarget;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = new ArrayList<>();
        globCandidates = candidates;
        globTarget = target;
        
        findCombinations();
        return nums;
    }
    
    void findCombinations() {
        ArrayDeque<Saver> ad1 = new ArrayDeque<>();
        ArrayDeque<Saver> ad2 = new ArrayDeque<>();
        
        int maxLen = globTarget / globCandidates[0];
        ad1.push(new Saver());
        for (int i = 1; i <= maxLen && ad1.size()>0; i++) {
            for (Saver oldList : ad1) {
                for (int j = oldList.lastPos; j < globCandidates.length; j++) {
                    if (oldList.curSz + globCandidates[j] <= globTarget) {
                        Saver cloneOld = oldList.clone();
                        cloneOld.curSz += globCandidates[j];
                        cloneOld.ls.add(globCandidates[j]);
                        cloneOld.lastPos = j;
                        if (cloneOld.curSz == globTarget) {
                            nums.add(cloneOld.ls);
                        } else {
                            ad2.add(cloneOld);
                        }
                    }
                }
            }
            ad1=ad2;
            ad2=new ArrayDeque<>();
        }
    }
}


class Saver implements Cloneable {
    List<Integer> ls;
    int lastPos;
    int curSz;

    public Saver(List<Integer> ls, int lastPos, int curSz) {
        this.ls = ls;
        this.lastPos = lastPos;
        this.curSz = curSz;
    }

    public Saver() {
        this.ls = new ArrayList<>();
        this.lastPos = 0;
        this.curSz = 0;
    }

    @Override
    protected Saver clone() {
        Saver out = new Saver(new ArrayList<>(this.ls), lastPos, curSz);
        return out;
    }
}