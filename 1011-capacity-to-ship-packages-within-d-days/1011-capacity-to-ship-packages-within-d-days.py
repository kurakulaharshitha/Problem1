class Solution(object):
    def shipWithinDays(self, weights, days):
        low=max(weights)
        high=sum(weights)
        while(low<=high):
            capacity=(low+high)//2
            current=0
            count_days=1
            for weight in weights:
                if((current+weight)>capacity):
                    count_days+=1
                    current=0
                current+=weight
            if(count_days<=days):
                high=capacity-1
            else:
                low=capacity+1
        return low
            

        
            
       
        