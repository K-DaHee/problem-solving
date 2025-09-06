package SWEA.D2;

import java.util.Scanner;

public class SWEA_14510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] trees = new int[N];
			int maxHeight = 0;
			for (int i = 0; i < N; i++) {
				trees[i] = sc.nextInt();
				maxHeight = Math.max(maxHeight, trees[i]);
			}

			int oneNeed = 0;
			int twoNeed = 0;
			for (int height : trees) {
				int diff = maxHeight - height;
				if (diff > 0) {
					twoNeed += diff / 2;
					oneNeed += diff % 2;
				}
			}

			int days = 0;
			while (oneNeed > 0 || twoNeed > 0) {
				days++;

				if (days % 2 != 0) {
					if (oneNeed > 0) {
						oneNeed--;
					} else if (twoNeed >= 2) {
						twoNeed--;
						oneNeed++;
					}
				} else {
					if (twoNeed > 0) {
						twoNeed--;
					}
				}
			}

			System.out.println("#" + t + " " + days);
		}
	}
}
