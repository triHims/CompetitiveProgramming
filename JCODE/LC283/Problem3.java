import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem3{
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

   class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }


class Solutionl3cp3 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,Integer> hasParent = new HashMap<>();
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        for(int arr[]:descriptions){
            int parent = arr[0];
            int child = arr[1];
            boolean isLeft = arr[2]==1?true:false;

            TreeNode childNode;
            TreeNode parentNode;

            if(hm.containsKey(child)){
                childNode = hm.get(child);
            }else{
                childNode = new TreeNode(child);
                hm.put(child,childNode);
            }

            if(hm.containsKey(parent)){
                parentNode = hm.get(parent);
            }else{
                parentNode = new TreeNode(parent);
                hm.put(parent,parentNode);
            }



            if(isLeft==true){
                parentNode.left=childNode;
            }else{
                parentNode.right=childNode;
            }
            
            hasParent.put(child,parent);
        }


        TreeNode root = null;
        
       for(Map.Entry<Integer,TreeNode> es: hm.entrySet()) {
            if(hasParent.containsKey(es.getKey())!=false)
                root= es.getValue();
        }

        return root;
    }
}