import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
public class NQUOON {
    
}

class Solution {
    int sz;
    List<List<String>> ans ;
    public List<List<String>> solveNQueens(int n) {

        int proof[][]=new int[n][n];
        sz = n;
        ans = new ArrayList<>();
    

        traverse(0,proof);

        return ans;

    }

    void traverse(int cur,int [][]proof){
        if(sz==cur){
            finalizeAns(proof);
            return;
        }

        for(int i=0;i<proof[cur].length ;i++){
            if(proof[cur][i]!=0)
                continue;

            if(checkPlacement(cur,i,proof)){
                proof[cur][i]=1;
                traverse(cur+1,proof);
                proof[cur][i]=0;
            }
            
        }


    }


    boolean checkPlacement(int down ,int right , int [] [] proof){
        for(int j=1;j<=down;j++){
            if(proof[down-j][right]==1)
                return false;

            if(right-j>=0 && proof[down-j][right-j]==1 )
                return false;

            if(right+j < proof.length && proof[down-j][right+j]==1)
                return false;
        }

        return true;
    }


    void finalizeAns(int arr[][]){
        List<String> temp =new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    sb.append(".");
                }else{
                    sb.append("Q");
                    
                }
            }
            temp.add(sb.toString());
        }

        ans.add(temp);

    }
}