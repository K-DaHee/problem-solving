package BOJ.silver.silver05;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][2];
		for (int i = 0; i < map.length; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}

		Arrays.sort(map, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			} else {
				return Integer.compare(a[0], b[0]);
			}
		});
		for (int i = 0; i < map.length; i++) {
			System.out.println(map[i][0] + " " + map[i][1]);
		}
	}
}
