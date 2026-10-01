class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        ans=[0]*(highLimit+1)
        for i in range(lowLimit,highLimit+1):
            num=i
            sum=0
            while(num>0):
                digit=num%10
                sum+=digit
                num=num//10
            ans[sum]+=1
        return max(ans)
       
        