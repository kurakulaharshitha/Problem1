class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]

        for i in range(len(s)):
            if s[i]=='(' or s[i]=='{' or s[i]=='[':
                stack.append(s[i])
            else:
                if(len(stack)==0):
                    return False
                top=stack.pop()
                current=s[i]
                if not((top=='('and current==')' or top=='['and current==']' or top=='{'and current=='}')):
                    return False
        return len(stack)==0
                    
       
    



            
            
                
            
        
        