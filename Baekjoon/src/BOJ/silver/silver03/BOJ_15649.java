package BOJ.silver.silver03;

import java.util.Scanner;

public class BOJ_15649 {
	static int N, M;
    static int[] sequence;
    static boolean[] used;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sequence = new int[M];
        used = new boolean[N + 1];

        dfs(0);
        sc.close();
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                sequence[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}
