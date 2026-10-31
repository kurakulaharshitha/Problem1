class Solution:
    def uniquePaths(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1

        for i in range(m):
            for j in range(n):

                if dp[i][j] == 0:
                    continue

                # Try moving right
                r, c = i, j + 1
                direction = 0  # 0 = right, 1 = down

                while r < m and c < n and grid[r][c] == 1:
                    if direction == 0:
                        r += 1
                        direction = 1
                    else:
                        c += 1
                        direction = 0

                if r < m and c < n:
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD

                # Try moving down
                r, c = i + 1, j
                direction = 1

                while r < m and c < n and grid[r][c] == 1:
                    if direction == 0:
                        r += 1
                        direction = 1
                    else:
                        c += 1
                        direction = 0

                if r < m and c < n:
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD

        return dp[m - 1][n - 1]