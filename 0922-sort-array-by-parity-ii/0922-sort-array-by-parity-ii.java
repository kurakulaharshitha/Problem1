class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
         int oddin=1;
         int evenin=0;
         for(int num:nums)
         {
            if(num%2==0 && evenin%2==0)
            {
                ans[evenin]=num;
                evenin+=2;
            }
            if(num%2==1 && oddin%2==1)
            {
                ans[oddin]=num;
                oddin+=2;
            }
         }
        return ans;
    }
}