class Solution {
    public int minSteps(String s, String t) {
        int[] wordBox = new int[27];
        int [] wordBox2 = new int[27];
        
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            ++wordBox[c-'a'];
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            ++wordBox2[c-'a'];
        }
        
        
        int effort=0;
        
        for (int i = 0; i < wordBox2.length; i++) {
            if(wordBox[i]-wordBox2[i]>0)
                effort+=(wordBox[i]-wordBox2[i]);
        }
        for (int i = 0; i < wordBox.length; i++) {
            if(wordBox2[i]-wordBox[i]>0)
                effort+=(wordBox2[i]-wordBox[i]);
        }

        return effort;
    }
}