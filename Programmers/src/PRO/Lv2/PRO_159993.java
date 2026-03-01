package PRO.Lv2;


public class PRO_159993 {
  public static void main(String[] args) {
      Solution_159993 s = new Solution_159993();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    

import java.util.LinkedList;
import java.util.Queue;

class Solution_159993 {
    int R, C;
	char[][] board;

	// 상하좌우
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };

	public int solution(String[] maps) {
		R = maps.length;
		C = maps[0].length();

		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = maps[i].toCharArray();
		}

		int startR = 0;
		int startC = 0;

		int LR = 0;
		int LC = 0;
		
		// 맵 탐색하면서 S와 L의 위치 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'S') {
					startR = i;
					startC = j;
				}

				if (board[i][j] == 'L') {
					LR = i;
					LC = j;
				}
			}
		}

		// S -> L 경로
		int lever = find(startR, startC, 'L');
		if (lever == -1) return -1;
		
		// L -> E 경로
		int exit = find(LR, LC, 'E');
		if (exit == -1) return -1;
		
		int answer = lever + exit;
		return answer;
	}

	// 돌면서 미로 탈출의 최소 경로 찾기
	public int find(int startR, int startC, char end) {
		Queue<int[]> q = new LinkedList<>();
		
		// 방문한 곳 체크하는 배열! => 방문 체크 안하면 무한 반복에 빠짐
		boolean[][] visited = new boolean[R][C];
		
		// 시작 지점 추가
		q.offer(new int[] { startR, startC, 0 });
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			// 현재 위치의 시간 체크
			int time = current[2];
			
			// 반복 종료 지점을 만나면 그 지점까지의 시간 반환
			if (board[current[0]][current[1]] == end)
				return time;

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];

				// 다음 경로가 경계를 벗어나는지, 벽인지, 방문 했었는지 확인
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				
				if (board[nr][nc] == 'X' || visited[nr][nc]) continue;
				
				// 큐에 넣기 전에 방문 처리
				visited[nr][nc] = true;
				
				// 다음 경로 큐에 추가, 시간 증가
				q.offer(new int[] { nr, nc, time + 1 });
			}
		}
		return -1;
	}
}