package SWEA.D2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				q.offer(sc.nextInt());
			}
			
			long result = 0;
			while (!q.isEmpty()) {
				int max = Integer.MIN_VALUE;
				int maxIdx = 0;
				int idx = 0;
				for (int num : q) {
					if (num > max) {
						max = num;
						maxIdx = idx;
					}
					idx++;
				}

				for (int i = 0; i < q.size(); i++) {
					if (q.peek() == max) {
						q.poll();
						break;
					}
					if (q.peek() < max && i < maxIdx)
						result += max - q.poll();
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
