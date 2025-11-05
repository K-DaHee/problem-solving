package BOJ.gold.gold03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static int N, min;
	static boolean[] visited;
	static int[] people;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 각 노드의 인원 수 저장
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 인접리스트를 선언해서 연결된 정보 저장
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int node = 0; node < N; node++) {
			st = new StringTokenizer(br.readLine());

			// 하나의 노드에 연결된 노드가 몇개인지 체크
			int connect = Integer.parseInt(st.nextToken());

			// 연결된 수 만큼 연결 정보 저장
			for (int j = 0; j < connect; j++) {
				adj[node].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		subset(0);
        
        if(min == Integer.MAX_VALUE) { 
			min = -1;
		}

		System.out.println(min);
	}

	// 조합 코드 1~N/2개 만큼!
	static void subset(int index) {
		// 1. 종료 조건: 모든 원소의 포함 여부를 결정했을 때
		if (index == N) {
			// 현재 visited 상태를 기반으로 부분집합을 만들어 리스트에 추가
			List<Integer> subset = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					subset.add(i);
				}
			}

			if (isConnected(subset)) {
				int countA = 0;
				int countB = 0;
				for (int i = 0; i < N; i++) {
					if (subset.contains(i))
						countA += people[i];
					else
						countB += people[i];
				}
				min = Math.min(min, Math.abs(countA - countB));
			}
            
			return; // 재귀 종료
		}

		// 재귀 호출
		// 현재 원소(index)를 포함시킨다
		visited[index] = true;
		subset(index + 1);

		// 현재 원소(index)를 포함시키지 않는다
		visited[index] = false;
		subset(index + 1);
	}

	// 완성된 조합이 연결되어 있는지 확인
	static boolean isConnected(List<Integer> subset) {
		// 선거구가 2개로 나뉘었는지 확인 (공집합이거나 전체집합이면 안 됨)
		if (subset.isEmpty() || subset.size() == N)
			return false;

		// A 선거구가 연결되어 있는지 확인
		int startNode = subset.get(0);
		int sizeA = subset.size();

		// 선거구를 모두 방문했는지 확인
		if (!check(startNode, true, sizeA))
			return false;

		// B 선거구가 연결되어 있는지 확인
		startNode = -1;
		int sizeB = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) { // B 선거구에 속하는 노드
				if (startNode == -1) {
					startNode = i;
				}
				sizeB++;
			}
		}
		
		if (!check(startNode, false, sizeB))
			return false;

		// 두 선거구 모두 연결됨
		return true;
	}

	static boolean check(int startNode, boolean isGroupA, int size) {
		boolean[] connect = new boolean[N];

		Queue<Integer> q = new LinkedList<>();
		q.add(startNode);
		connect[startNode] = true;
		
		int visitedCount = 1;

		while (!q.isEmpty()) {
			int current = q.poll();
			for (int neighbor : adj[current]) {
				// 이웃이 내 선거구에 포함되고 아직 방문 안 했으면
				if (visited[neighbor] == isGroupA && !connect[neighbor]) {
					connect[neighbor] = true;
					q.add(neighbor);
					visitedCount++;
				}
			}
		}
		
		if (visitedCount != size)
			return false;
		
		return true;
	}
}