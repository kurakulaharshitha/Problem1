import heapq
class Solution(object):
    def lastStoneWeight(self, stones):
        heap=[]
        for stone in stones:
            heapq.heappush(heap,-stone)
        while len(heap)>1:
            first=-heapq.heappop(heap)
            second=-heapq.heappop(heap)
            if(first!=second):
                heapq.heappush(heap,-(first-second))
        if heap:
            return -heap[0]
        return 0
     
        