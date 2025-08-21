package BOJ.silver.silver03;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int connect = sc.nextInt();
		int[][] com = new int[connect][2];
		
		for(int i = 0; i < connect; i++) {
			com[i][0] = sc.nextInt();
			com[i][1] = sc.nextInt();
		}
		// 1. 인접행렬로 변환
        int[][] network = new int[computer + 1][computer + 1];
        for (int i = 0; i < connect; i++) {
            int a = com[i][0];
            int b = com[i][1];
            network[a][b] = 1;
            network[b][a] = 1;  // 양방향 연결
        }

        // 2. DFS 시작
        boolean[] visited = new boolean[computer + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        int count = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int i = 1; i <= computer; i++) {
                if (network[current][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
        sc.close();
	}
}
