package BOJ.silver.silver02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		int[][] line = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			line[a][b] = 1;
			line[b][a] = 1;
		}
		
		boolean[] dfsVisited = new boolean[N + 1];
        int[] stack = new int[10000];
        int top = -1;

        stack[++top] = V;

        while (top >= 0) {
            int node = stack[top--];

            if (!dfsVisited[node]) {
                dfsVisited[node] = true;
                System.out.print(node + " ");

                for (int i = N; i >= 1; i--) {
                    if (line[node][i] == 1 && !dfsVisited[i]) {
                        stack[++top] = i;
                    }
                }
            }
        }

        System.out.println();

        // BFS
        boolean[] bfsVisited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        bfsVisited[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 1; i <= N; i++) {
                if (line[node][i] == 1 && !bfsVisited[i]) {
                    queue.add(i);
                    bfsVisited[i] = true;
                }
            }
        }
        sc.close();
	}
}
