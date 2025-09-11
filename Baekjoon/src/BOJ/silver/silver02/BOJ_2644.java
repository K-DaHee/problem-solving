package BOJ.silver.silver02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	static int n, m;
	static int[] x, y;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 전체 사람 수
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());	// 서로 다른 두 사람의 번호
		int num2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계 수
		
		x = new int[m];
		y = new int[m];
		for (int i = 0; i < m; i++) {
			st =  new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());			
		}
		
		visited = new boolean[n + 1];
		
		System.out.println(check(num1, num2));
	}
	
	public static int check(int start, int target) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			
			if(current[0] == target) return current[1];
			
			// 모든 관계를 확인하여 연결된 사람 찾기
			for (int i = 0; i < m; i++) {
				int p = -1;
                // x[i]가 현재 사람과 같다면, 연결된 사람 y[i]
                if (x[i] == current[0]) {
                    p = y[i];
                } 
                // y[i]가 현재 사람과 같다면, 연결된 사람 x[i]
                else if (y[i] == current[0]) {
                    p = x[i];
                }

                // 찾았고, 아직 방문하지 않았다면
                if (p != -1 && !visited[p]) {
                    visited[p] = true;
                    q.add(new int[]{p, current[1] + 1}); // 촌수를 1 늘려서 큐에 추가
                }
			}
		}
		return -1;
	}
}
