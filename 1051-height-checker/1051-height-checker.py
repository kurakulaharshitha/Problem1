class Solution(object):
    def heightChecker(self, heights):
        count=0
        expected=sorted(heights)
        for i in range(len(heights)):
            if(expected[i]!=heights[i]):
                count=count+1
        return count
       