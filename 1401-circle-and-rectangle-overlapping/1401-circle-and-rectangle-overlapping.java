class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest point (nearestX, nearestY) on/in the rectangle to the circle's center
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate Euclidean distance components between center and closest point
        int dx = xCenter - nearestX;
        int dy = yCenter - nearestY;
        
        // Check if distance^2 <= radius^2 (prevents floating-point precision issues)
        return dx * dx + dy * dy <= radius * radius;
    }
}