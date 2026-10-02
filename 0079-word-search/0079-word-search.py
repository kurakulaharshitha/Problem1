class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        rows=len(board)
        cols=len(board[0])
        def dfs(r,c,index):
            if r<0 or r>=rows or c<0 or c>=cols:
                return False
            if board[r][c]!=word[index]:
                return False
            if index==len(word)-1:
                return True
            temp=board[r][c]
            board[r][c]="#"
            found=(
                dfs(r+1,c,index+1) or dfs(r-1,c,index+1) or dfs(r,c+1,index+1) or 
                dfs(r,c-1,index+1)

            ) 
            board[r][c]=temp
            return found
        for r in range(rows):
            for c in range(cols):
                if dfs(r,c,0):
                    return True
        return False

        