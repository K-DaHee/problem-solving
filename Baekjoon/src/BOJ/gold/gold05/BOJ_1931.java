package BOJ.gold.gold05;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] times = new int[N][2];
		for (int i = 0; i < times.length; i++) {
			times[i][0] = sc.nextInt();
			times[i][1] = sc.nextInt();
		}
		Arrays.sort(times, (a, b) -> {
			if (a[1] == b[1])
				return Integer.compare(a[0], b[0]);
			else
				return Integer.compare(a[1], b[1]);
		});

		int baseEnd = 0;
		int count = 0;
		
		for (int i = 0; i < times.length; i++) {
			int start = times[i][0];
			int end = times[i][1];
			if (start >= baseEnd) {
				baseEnd = end;
				count++;
			}
		}

		System.out.println(count);
	}
}
