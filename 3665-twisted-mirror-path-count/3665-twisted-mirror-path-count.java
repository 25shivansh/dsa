
class Solution {

    private static final int MOD = 1_000_000_007;

    private int m, n;
    private int[][] grid;
    private int[][][] memo;

    // dir = 0: entered mirror while moving RIGHT
    // dir = 1: entered mirror while moving DOWN

    private int resolve(int r, int c, int dir) {

        // Out of bounds
        if (r >= m || c >= n) {
            return -1;
        }

        // Already calculated
        if (memo[r][c][dir] != -2) {
            return memo[r][c][dir];
        }

        int nr, nc;
        int nextDir;

        if (dir == 0) {
            // Right -> Down
            nr = r + 1;
            nc = c;
            nextDir = 1;
        } else {
            // Down -> Right
            nr = r;
            nc = c + 1;
            nextDir = 0;
        }

        // Reflection goes outside the grid
        if (nr >= m || nc >= n) {
            return memo[r][c][dir] = -1;
        }

        // Another mirror: continue reflecting
        if (grid[nr][nc] == 1) {
            return memo[r][c][dir] =
                resolve(nr, nc, nextDir);
        }

        // Reached an empty cell
        return memo[r][c][dir] = nr * n + nc;
    }

    public int uniquePaths(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];

        // -2 means not calculated
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) {
                    continue;
                }

                // Current reachable cells are empty.
                
                // Try moving RIGHT
                if (j + 1 < n) {

                    int target;

                    if (grid[i][j + 1] == 0) {
                        target = i * n + (j + 1);
                    } else {
                        target = resolve(i, j + 1, 0);
                    }

                    if (target != -1) {
                        int nr = target / n;
                        int nc = target % n;

                        dp[nr][nc] =
                            (dp[nr][nc] + dp[i][j]) % MOD;
                    }
                }

                // Try moving DOWN
                if (i + 1 < m) {

                    int target;

                    if (grid[i + 1][j] == 0) {
                        target = (i + 1) * n + j;
                    } else {
                        target = resolve(i + 1, j, 1);
                    }

                    if (target != -1) {
                        int nr = target / n;
                        int nc = target % n;

                        dp[nr][nc] =
                            (dp[nr][nc] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
