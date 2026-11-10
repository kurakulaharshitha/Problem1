class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int left=0;
        int right=s.length()-1;
        while(left<right)
        {
           char ch=s.charAt(left);
           char ch1=s.charAt(right);
           if(!Character.isLetterOrDigit(ch))
           {
            left+=1;

           }
           else if (!Character.isLetterOrDigit(ch1))
           {
            right-=1;
           }
           else
           {
            if(ch!=ch1)
            {
                return false;
            }
            left+=1;
            right-=1;
           }
          
        }
         return true;
    }
}