import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ReplaceNonCoPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        SolutioMiniKSetNon s = new SolutioMiniKSetNon();
        System.out.println(s.replaceNonCoprimes(arr));

    }

}

class SolutioMiniKSetNon{
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> stack = new ArrayList<>();
    
        for(int num:nums){
            stack.add(num);
            while(stack.size()>1 && findgcd(stack.get(stack.size()-1), stack.get(stack.size()-2))>1){
                    int gcd= findgcd(stack.get(stack.size()-1), stack.get(stack.size()-2));
                    int newNumber = stack.get(stack.size()-1)/gcd * stack.get(stack.size()-2);
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                    stack.add(newNumber);
            }   
        }

        return stack;
    }

    public <T> void swap(T a,T b){
        T c= a;
        a=b;
        b=c;
    }

    int findgcd(int a,int b){
        if(a==0)
            return b;
        if(b==0)
            return a;

        while(a>0)
        {
            int temp=b%a;
            b=a;
            a=temp;
        }
        return b;
    }
    
}