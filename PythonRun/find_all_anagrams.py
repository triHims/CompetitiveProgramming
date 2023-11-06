# pylint: skip-file
from collections import deque
from typing import List

class CountingSet:
    def __init__(self) -> None:
        self.mp = {}
    def rem(self,cha):
        val = self.mp.get(cha,0)
        if(val):
            self.mp[cha] = val-1
            self.mp['cnt'] = self.mp.get('cnt',0)-1

    def add(self,cha):
        val = self.mp.get(cha,0)
        self.mp[cha]=val+1
        self.mp['cnt'] = self.mp.get('cnt',0)+1

    def len(self):
        return self.mp.get('cnt',0)
    
    def __len__(self):
        return self.len()


    def count(self,ch):
        return self.mp.get(ch,0)

    def clear(self):
        self.mp.clear()
        self.mp['cnt']=0

class Solution:

    def findAnagrams(self, s: str, p: str) -> List[int]:
        que = deque()
        st = CountingSet()
        valid = CountingSet()

        for i in range(len(p)):
            valid.add(p[i])

        startInd=0

        ans=[]


        for i in range(len(s)):
            if(valid.count(s[i])==0):
                st.clear()
                que.clear()
                startInd=i+1
            else: 
                if(st.len() <len(p)):
                    while( st.count(s[i]) >= valid.count(s[i])):
                        st.rem(que[0])
                        que.popleft()
                        startInd+=1

                    st.add(s[i])
                    que.append(s[i])
                
                if(len(st) == len(p)):
                    ans.append(startInd)
                    startInd+=1
                    st.rem(que[0])
                    que.popleft()

        return ans


s = Solution()

print(s.findAnagrams("baa","aa"))