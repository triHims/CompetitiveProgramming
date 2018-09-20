#include<bits/stdc++.h>
#define lol long long
#define vll vector<lol>
#define vinc(x) vector<x>
//wasudev sutam devam sant char ud mardhnam devki permanandam  krishnam bande jagat gurum
//私は違いを生むことができると思いますか？
//それは鳴りますか？
//unhe punjit karao akar do he, mujhe mera jalit , shringar do he, pawan ka veig do durjay anal do  ,
//vikartan ! aaj apna tej bal do ! Mahi ka surya hona chahata hu
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        lol N;
        cin>>N;
        lol low , high,mid,masala;
        low=0;
        high =1e9+1;
        while((high-low)>1)
        {
            mid=low+(high-low)/2;
             masala= (mid*(mid+1))/2;
            if(masala<=N)
                low=mid;
            else
                high=mid;
        }
        masala=((low)*(low+1))/2;
        if(masala<=N)
            cout<<low<<endl;
        else
            cout<<-1<<endl;


    }

}
