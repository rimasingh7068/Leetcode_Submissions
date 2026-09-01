import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitter = litters.size();
        int fullMask = (1 << totalLitter) - 1;
        
        // maxEnergy[r][c][mask] stores the max remaining energy at (r, c) with given mask
        int[][][] maxEnergy = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < (1 << totalLitter); k++) {
                    maxEnergy[i][j][k] = -1;
                }
            }
        }
        
        // Queue state: {row, col, mask, currentEnergy}
        Queue<int[]> queue = new LinkedList<>();
        
        int initialMask = 0;
        // Check if starting position itself is a litter cell
        for (int i = 0; i < totalLitter; i++) {
            if (litters.get(i)[0] == startR && litters.get(i)[1] == startC) {
                initialMask |= (1 << i);
            }
        }
        
        queue.offer(new int[]{startR, startC, initialMask, energy});
        maxEnergy[startR][startC][initialMask] = energy;
        
        int steps = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                if (mask == fullMask) {
                    return steps;
                }
                
                // If out of energy, student cannot make another move
                if (e == 0) continue;
                
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    char cell = classroom[nr].charAt(nc);
                    if (cell == 'X') continue;
                    
                    int nextMask = mask;
                    int nextEnergy = e - 1;
                    
                    // Update mask if moving into a litter cell
                    if (cell == 'L') {
                        for (int i = 0; i < totalLitter; i++) {
                            if (litters.get(i)[0] == nr && litters.get(i)[1] == nc) {
                                nextMask |= (1 << i);
                                break;
                            }
                        }
                    } else if (cell == 'R') {
                        // Reset energy to max capacity
                        nextEnergy = energy;
                    }
                    
                    // Prune state if we've reached (nr, nc, nextMask) with >= energy before
                    if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                        maxEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}