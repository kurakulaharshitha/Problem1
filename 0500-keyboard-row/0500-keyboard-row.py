class Solution:
    def findWords(self, words: list[str]) -> list[str]:
        row1 = set("qwertyuiop")
        row2 = set("asdfghjkl")
        row3 = set("zxcvbnm")
        ans=[]
        for word in words:
            lower_word=word.lower()
            if  lower_word[0] in row1:
                row=row1
            elif lower_word[0] in row2:
                row=row2
            else:
                row=row3
            valid=True
            for ch in lower_word:
                if ch not in row:
                    valid=False
                    break
            if valid:
                ans.append(word)
        return ans
        
        