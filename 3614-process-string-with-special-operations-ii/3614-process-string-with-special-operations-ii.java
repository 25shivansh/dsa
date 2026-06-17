class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        
        // STEP 1: Compute final length
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                len++;
            } else if (ch == '*') {
                if (len > 0) len--;
            } else if (ch == '#') {
                len *= 2;
                // Cap to avoid overflow
                if (len > Long.MAX_VALUE / 2) len = Long.MAX_VALUE;
            }
            // '%' doesn't change length, so ignore it
        }
        
        // If k is out of bounds
        if (k >= len) return '.';
        
        // STEP 2: Traverse backwards to find the kth character
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                // This is a letter that was appended
                len--;
                if (k == len) {
                    return ch;
                }
            } 
            else if (ch == '#') {
                // Duplication: result = old + old
                // So character is in second half if k >= len/2
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            } 
            else if (ch == '*') {
                // This deletion removed the last character
                // So we need to increase len to what it was before deletion
                len++;
            } 
            else if (ch == '%') {
                // Reverse operation: new[k] = old[len-1-k]
                k = len - 1 - k;
            }
        }
        
        return '.';
    }
}