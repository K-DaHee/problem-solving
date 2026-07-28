package PRO.Lv2;
import java.util.*;

public class PRO_1844 {
  public static void main(String[] args) {
      Solution_1844 s = new Solution_1844();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_1844 {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    boolean[][] visited;
    int min = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new boolean[n][m];
        
        int min = bfs(n, m, maps);
        
        if (min == Integer.MAX_VALUE)
            return -1;
        
        return min;
    }
    
    int bfs (int n, int m, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int curR = current[0];
            int curC = current[1];
            int count = current[2];
            
            if (curR == n-1 && curC == m-1) {
                min = Math.min(min, count);
            }
            
            for (int i = 0; i < 4; i++) {
                int nR = curR + dr[i];
                int nC = curC + dc[i];
                
                if (nR >= n || nR < 0 || nC >= m || nC < 0) continue;
                if (visited[nR][nC]) continue;
                if (maps[nR][nC] == 0) continue;
                
                q.add(new int[]{nR, nC, count + 1});
                visited[nR][nC] = true;
            }
        }
        
        return min;
    }
}