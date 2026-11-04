import java.util.*;
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int count=0;
        int prefixsum=0;
        hs.put(0,1);
        for(int num:nums)
        {
            prefixsum+=num;
            int rem=prefixsum-goal;
            if(hs.containsKey(rem))
            {
                count+=hs.get(rem);
            }
            hs.put(prefixsum,hs.getOrDefault(prefixsum,0)+1);
        }
        return count;
        
    }
}