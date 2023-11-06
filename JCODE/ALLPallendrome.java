import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALLPallendrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input  = sc.next();
        Solutionpartition sp = new Solutionpartition();
        List<List<String>> ans = sp.partition(input);

        for(List<String> o : ans){
            System.out.println(o.toString());
        }

    }
}
class Solutionpartition {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        List<String> brokeString = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            brokeString.add(String.valueOf(s.charAt(i)));
        }
        ans.add(brokeString);
        for(int tarLen = 2;tarLen<=s.length();tarLen++){
            grind(tarLen, s, ans);
        }

        return ans;
    }

    void grind(int len,String s,List<List<String>> ans){
        List<String> temp =new ArrayList<>();
        for(int i=0;i+len-1<s.length();i++){
            if(isPalen(s, i, i+len-1)){
                for (int j = 0; j < i; j++) {
                    temp.add(String.valueOf(s.charAt(j)));
                }
                temp.add(s.substring(i, i+len));
                for (int j = i+len; j < s.length(); j++) {
                    temp.add(String.valueOf(s.charAt(j)));
                }
                ans.add(temp);
                temp = new ArrayList<>();
            }
        }
    }

    boolean isPalen(String s ,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;

        }
        return true;
    }
}