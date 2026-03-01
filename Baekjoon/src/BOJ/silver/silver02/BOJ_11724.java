package BOJ.silver.silver02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static int N, M;
	static int[] u, v;
	static boolean[] visited;
	static int group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수

		u = new int[M];
		v = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		group = 0;
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				group++;
				searchSame(i);
			}
		}
		System.out.println(group);
	}

	public static void searchSame(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int current = q.poll();
			for (int k = 0; k < M; k++) {
				// u[k]가 현재 정점이고, 반대편 v[k]를 아직 방문 안했다면
				if (u[k] == current && !visited[v[k]]) {
					visited[v[k]] = true;
					q.add(v[k]);
				}
				// v[k]가 현재 정점이고, 반대편 u[k]를 아직 방문 안했다면
				else if (v[k] == current && !visited[u[k]]) {
					visited[u[k]] = true;
					q.add(u[k]);
				}
			}
		}
	}
}
