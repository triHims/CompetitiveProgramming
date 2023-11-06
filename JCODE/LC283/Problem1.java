import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1{
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        

    String k = sc.next();
    SolutionlCp1 sol = new SolutionlCp1();
    System.out.println(sol.cellsInRange(k));
   }
}

class SolutionlCp1 {
    public List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        char rangeStart1 = split[0].charAt(0);
        char rangeStart2 = split[0].charAt(1);
        char rangeEnd1 = split[1].charAt(0);
        char rangeEnd2 = split[1].charAt(1);
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        System.out.println(split[0]+" "+split[1]);
        System.out.println(" " + rangeStart1+' '+rangeEnd1+"   -  "+rangeStart2+"  "+rangeEnd2);
        for(int i=rangeStart1;i<=rangeEnd1;i++){
            for (int j = rangeStart2; j <=rangeEnd2; j++) {
                sb.setLength(0);
                
                sb.append((char)i);
                sb.append((char)j);

                out.add(sb.toString());
            }
        }
        return out;
    }
}