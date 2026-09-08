class Solution:
    def makeGood(self, s: str) -> str:
        stack=[]
        for ch in s:
            if len(stack)!=0 and  ch.lower()==stack[-1].lower() and ch!=stack[-1]:
                stack.pop()
            else:
                stack.append(ch)
        return ''.join(stack)

        