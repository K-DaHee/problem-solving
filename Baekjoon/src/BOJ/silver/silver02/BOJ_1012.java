package BOJ.silver.silver02;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N, K, x, y;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			int[][] field = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				field[y][x] = 1;
			}
			
			int wormCount = 0;
			
			for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[]{i, j});
                        visited[i][j] = true;

                        while (!stack.isEmpty()) {
                            int[] current = stack.pop();
                            int curY = current[0];
                            int curX = current[1];

                            for (int d = 0; d < 4; d++) {
                                int ny = curY + dy[d];
                                int nx = curX + dx[d];

                                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                                    if (field[ny][nx] == 1 && !visited[ny][nx]) {
                                        visited[ny][nx] = true;
                                        stack.push(new int[]{ny, nx});
                                    }
                                }
                            }
                        }
                        wormCount++;
                    }
                }
            }
            System.out.println(wormCount);
		}
        sc.close();
	}
}
