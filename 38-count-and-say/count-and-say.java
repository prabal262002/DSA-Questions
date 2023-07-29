class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (n-->1) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int count = 1;
                char ch = s.charAt(i);
                while (i + 1 < s.length() && ch == s.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append("" + count + ch);
                i++;
            }
            s = sb.toString();
        }
        return s;
    }
}
