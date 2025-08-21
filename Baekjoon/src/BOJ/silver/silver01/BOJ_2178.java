package BOJ.silver.silver01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] maze = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			String[] parts = line.split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(parts[j]);
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                	continue;
                }
                if (maze[nx][ny] == 0 || visited[nx][ny]) {
                	continue;
                }
                maze[nx][ny] = maze[x][y] + 1;
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
 		}
		
		System.out.println(maze[N-1][M-1]);
		sc.close();
	}
}
