class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
       while(i<s.length() && j <t.length())
       {
        char ch=s.charAt(i);
        char ch1=t.charAt(j);
        if(ch==ch1)
        {
            i++;
            j++;
        }
        else if(ch!=ch1)
        {
            j++;
        }
       }
       if(i==s.length())
       {
        return true;
       }
       return false;
    }
}