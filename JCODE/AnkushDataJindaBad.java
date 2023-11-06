import java.util.ArrayDeque;
import java.util.Scanner;

public class AnkushDataJindaBad{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        

        String k = sc.next();
        SolutionXX s = new SolutionXX();
        System.out.println(s.findSolution(k));
        
    }
}

class TrackedStack{
    ArrayDeque<Character> stack;
    char count[];

    TrackedStack(){
        stack=new ArrayDeque<>();
        count=new char[27];
    }
    

    char pop(){
        char c = stack.peek();
        --count[c-'a'];
        stack.pop();
        return c;
    }

    void push(char c){
        ++count[c-'a'];
        stack.push(c);
    }

    boolean contains(char c){
            return count[c-'a']>0;
    }
}

class SolutionXX {
    String removeDuplicates(String s){
        StringBuilder sBuffer = new StringBuilder();

        char old =0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==old){
                continue;
            }

            old = s.charAt(i);
            sBuffer.append(old);

           
        }

        return sBuffer.toString();


    }
    public int findSolution(String s){
        TrackedStack stack = new TrackedStack();

        String finstr = removeDuplicates(s);
        int effort =0;
        for(int i=0;i<finstr.length();i++){
            char c = finstr.charAt(i);
            if(stack.contains(c)){
                while(stack.pop()!=c);
                continue;
            }else{
                effort++;
                stack.push(c);
            }
        }


        return effort;

    }   
}
