import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        int cookie = 0;
        
        while (child < g.length && cookie < s.length) {
            // If the cookie satisfies the child's greed factor
            if (s[cookie] >= g[child]) {
                child++; // Move to the next child
            }
            cookie++; // Always move to the next cookie
        }
        
        return child; // 'child' counts how many children were content
    }
}