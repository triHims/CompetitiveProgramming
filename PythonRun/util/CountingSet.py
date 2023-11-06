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