class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        
        // If total substrings possible < total binary codes
        if (n < k) return false;
        
        int total = 1 << k; // 2^k
        boolean[] seen = new boolean[total];
        
        int count = 0;
        int mask = total - 1; // To keep only last k bits
        int hash = 0;
        
        for (int i = 0; i < n; i++) {
            // Shift left and add new bit
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');
            
            // Start checking only when window size >= k
            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;
                    
                    if (count == total) return true;
                }
            }
        }
        
        return false;
    }
}