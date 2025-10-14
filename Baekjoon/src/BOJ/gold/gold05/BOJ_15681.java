package BOJ.gold.gold05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681 {
	static int N, R, Q;
	static int u, v;
	static List<Integer>[] graph;
	static int[] size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		// 1~N까지의 정점을 기준 => graph, size 크기 N + 1
		graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        size = new int[N + 1];
		
        // 간선 정보 양방향으로 저장
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		// 각 정점의 서브트리 계산 DFS
		subtree(R, 0);
		
		// 각 쿼리에 해당하는 정점의 서브트리 출력
		for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(size[q]);
        }
	}
	
	static int subtree(int currentNode, int parentNode) {
		// 자기 자신을 포함하므로 1로 시작
        size[currentNode] = 1;

        // 현재 노드와 연결된 모든 노드 탐색
        for (int n : graph[currentNode]) {
            // 자식 노드라면
            if (n != parentNode) {
                // 자식 노드 서브트리 크기를 재귀적으로 계산 => 현재 노드에 더함
                size[currentNode] += subtree(n, currentNode);
            }
        }
        return size[currentNode];
	}
}
