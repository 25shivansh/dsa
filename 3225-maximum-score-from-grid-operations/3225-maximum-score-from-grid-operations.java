class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        
        // Precompute prefix sums for each column
        // S[j][k] = sum of the first k elements in column j
        long[][] S = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                S[j][i + 1] = S[j][i] + grid[i][j];
            }
        }

        // dp[col][height][state]
        // state 0: Increasing/Same (h_i >= h_{i-1})
        // state 1: Decreasing (h_i <= h_{i-1})
        // state 2: Transition/Reset (h_i after a peak/valley)
        long[][][] dp = new long[n][n + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1L);
            }
        }

        // Base Case: Column 0
        for (int h = 0; h <= n; h++) {
            dp[0][h][0] = 0;
            dp[0][h][1] = 0;
            dp[0][h][2] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int currH = 0; currH <= n; currH++) {
                for (int prevH = 0; prevH <= n; prevH++) {
                    
                    // State 0: Increasing (currH >= prevH)
                    // Column i-1 gains score from the cells between prevH and currH
                    if (currH >= prevH) {
                        if (dp[i - 1][prevH][0] != -1) {
                            dp[i][currH][0] = Math.max(dp[i][currH][0], 
                                dp[i - 1][prevH][0] + S[i - 1][currH] - S[i - 1][prevH]);
                        }
                        if (dp[i - 1][prevH][2] != -1) {
                            // After a reset, prevH effectively acts as 0 for column i-1's gain
                            dp[i][currH][0] = Math.max(dp[i][currH][0], 
                                dp[i - 1][prevH][2] + S[i - 1][currH]);
                        }
                    }

                    // State 1: Decreasing (currH <= prevH)
                    // Column i gains score from the cells between currH and prevH
                    if (currH <= prevH) {
                        long prevMax = Math.max(dp[i - 1][prevH][0], dp[i - 1][prevH][1]);
                        if (prevMax != -1) {
                            dp[i][currH][1] = Math.max(dp[i][currH][1], 
                                prevMax + S[i][prevH] - S[i][currH]);
                        }
                    }

                    // State 2: Valley / Reset
                    // Allows the next column to start an increasing trend from 0
                    if (currH < prevH) {
                        long prevMax = Math.max(dp[i - 1][prevH][0], dp[i - 1][prevH][1]);
                        if (prevMax != -1) {
                            dp[i][currH][2] = Math.max(dp[i][currH][2], prevMax);
                        }
                    } else if (currH == 0) {
                        long prevMax = Math.max(dp[i - 1][prevH][0], 
                                       Math.max(dp[i - 1][prevH][1], dp[i - 1][prevH][2]));
                        if (prevMax != -1) {
                            dp[i][0][2] = Math.max(dp[i][0][2], prevMax);
                        }
                    }
                }
            }
        }

        // The answer is the maximum value in the last column's DP entries
        long ans = 0;
        for (int h = 0; h <= n; h++) {
            for (int s = 0; s < 3; s++) {
                ans = Math.max(ans, dp[n - 1][h][s]);
            }
        }
        return ans;
    }
}