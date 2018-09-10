#include<bits/stdc++.h>
#define ll long long
#define vll vector<ll>
//wasudev sutam devam sant char ud mardhanam devki parmanadam krishnam bande jagat gurum
#define vinc(x) vector<x>
#define mod 20011

using namespace std;
void update_ques(vinc(vll) &allowed,vinc(vll) &count_left,vinc(vll) &count_up,int x,int y,int limit)
{
    if(allowed[x][y]==0)
        {
            count_left[x][y]=0;
            count_up[x][y]=0;
            return (void)0;
        }

  //  int ix=x-1,iy=y-1;

   for(int i=1;i<=limit ;i++)
     {
           if(y-i>=0  && allowed[x][y-i]==1)
            count_left[x][y]=(count_left[x][y]+count_up[x][y-i])%mod;
            else
                break;
                }

    for(int i=1;i<=limit ;i++)
      {

      if(x-i>=0 &&allowed[x-i][y] == 1)
        count_up[x][y]=(count_left[x-i][y]+count_up[x][y])%mod;
        else
            break;
            }
}


int main()
{
    int x,y,limit;
    cin>>x>>y>>limit;
    vinc(vll) count_left(x,vll(y,0));
    vinc(vll) count_up(x ,vll(y,0));
    count_left[0][0]=1;
    count_up[0][0]=1;
    vinc(vll) allowed(x,vll(y,0));
    for(int i=0;i<x;i++)
        for(int j=0;j<y;j++)
            cin>>allowed[i][j];
    for(int i=0;i<x;i++)
    {
        for(int j=0;j<y;j++)
            update_ques(allowed,count_left,count_up,i,j,limit);
    }
    cout<<(count_left[x-1][y-1]+count_up[x-1][y-1])%mod;
}
