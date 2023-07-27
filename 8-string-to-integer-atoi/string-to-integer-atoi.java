class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        
        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Handle positive and negative signs
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Calculate the integer value
        long ans = 0L; // Use long to handle potential overflow
        
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = ans * 10 + (s.charAt(i) - '0');
            
            // Check for overflow
            if (sign * ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int) (sign * ans);
    }
}
