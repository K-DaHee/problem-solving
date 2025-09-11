package BOJ.gold.gold04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
	static int min, minCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		minCount = 0;
		bfs(n, k);
		System.out.print(min + "\n" + minCount);
	}

	public static void bfs(int n, int k) {
		int start = n;

		Queue<Integer> queue = new LinkedList<>();
		int[] time = new int[100001];

		// 시작점 큐에 추가하고 방문 처리
		queue.add(start);
		time[start] = 1;

		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == k) {
				minCount++;
				min = time[current] - 1;
			}
			// 다음 이동 위치 탐색
			int[] nextPositions = { current - 1, current + 1, current * 2 };

			for (int next : nextPositions) {
				if (next < 0 || next >= 100001)
					continue;
				if (time[next] == 0 || time[next] == time[current] + 1) {
					queue.add(next);
					time[next] = time[current] + 1;
				}
			}
		}
	}
}
