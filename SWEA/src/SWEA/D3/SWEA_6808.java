package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_6808 {
	static int N = 9;
	static int[] data = new int[N];
	static int[] temp = new int[N];
	static int win = 0;
	static int lose = 0;
	static List<Integer> cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			cards = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				cards.add(Integer.parseInt(st.nextToken()));
			}

			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (cards.contains(i))
					continue;
				data[idx] = i;
				idx++;
			}
			win = 0;
			lose = 0;
			perm(0, 0);

			System.out.printf("#%d %d %d\n", testCase, win, lose);
		}
	}

	public static void perm(int idx, int flag) {
		if (idx == N) {
			int score1 = 0;
			int score2 = 0;
			for (int i = 0; i < N; i++) {
				if (cards.get(i) > temp[i]) {
					score1 += cards.get(i) + temp[i];
				} else {
					score2 += cards.get(i) + temp[i];
				}
			}
			if (score1 > score2) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			temp[idx] = data[i];
			perm(idx + 1, flag | 1 << i);
		}
	}
}
