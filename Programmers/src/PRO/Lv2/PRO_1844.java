package PRO.Lv2;
import java.util.*;

public class PRO_1844 {
  public static void main(String[] args) {
      Solution_1844 s = new Solution_1844();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_1844 {
    // 상하좌우
    int[] dr = {-1, 1, 0, 0};  // 행
    int[] dc = {0, 0, -1, 1};  // 열
    boolean[][] visited;
    int min = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new boolean[n][m];
        
        int answer = bfs(n, m, maps);
        if (answer == Integer.MAX_VALUE) answer = -1; 
        return answer;
    }
    
    public int bfs(int n, int m, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});  // 캐릭터 시작위치, 이동횟수
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];
            
            if (curR == n-1 && curC == m-1) {
                min = Math.min(min, dist);
            }
            
            for (int d = 0; d < 4; d++) {
                int nR = curR + dr[d];
                int nC = curC + dc[d];
                if (nR < n && nR >= 0 && nC < m && nC >= 0 && maps[nR][nC] == 1 && !visited[nR][nC]) {
                    q.add(new int[]{nR, nC, dist + 1});
                    visited[nR][nC] = true;
                }
            }
        }
        return min;
    }
}