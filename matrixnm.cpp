#include<vector>
#include<iostream>
#include<algorithm>
#include<string>
#include<unordered_map>
#include<stack>
#include<queue>
#include<map>
#include<set>
using namespace std;
//sprial Traversal
#define mp(x,y) make_pair(x,y)


int main(int argc, char const *argv[])
{
    int n,m;

    cin>>n>>m;


    vector<vector<int>> ans(n,vector<int>(m,-1));

    int rs=0,cs=0,ce=m-1,re=n-1,coun=1;
    while(cs<=ce && rs<=re){
        for(int i=cs;i<=ce;i++){
            ans[rs][i]=coun++;
        }

        for(int i = rs+1;i<=re;i++){
            ans[i][ce]=coun++;
        }

        for(int i=ce-1;i>=cs;i--){
            ans[re][i]=coun++;
        }

        for(int i=re-1;i>=rs+1;i--){
            ans[i][cs]=coun++;
        }
        cs++;
        rs++;
        ce--;
        re--;
    }


    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            printf("%3d ",ans[i][j]);
        }
        cout<<endl;
    }
    return 0;
}
