import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class solve 
{   

    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
        // Your code here
        if(color[i]!=0)
            return false;

        int validColor = 0;
        for(int j:G[i]){
            if(color[j]==0)
                continue;
            validColor|=(1<<color[j]);
        }

      boolean inSide =false;

       for(int j:G[i]){
           if(color[j]==0){
            inSide =true;
               for(int x=1;x<=m;x++){
                   
                   if((validColor&(1<<x)) == 0){
                    color[j]=x;
                    if(graphColoring(G,color,j,m))
                        return true;
                    color[j]=0;
                   }
               }
           }
       }

       return !inSide;


    }

}



class UTraRunner{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            int V = sc.nextInt();
            int C = sc.nextInt();
            int E = sc.nextInt();
            List<Integer>[] G = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                G[u].add(v);
                G[v].add(u);
            }


            int [] color = new int[V];

            System.out.println(solve.graphColoring(G, color, 0, C));

        }
    }
}