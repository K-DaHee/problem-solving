package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6809_Array {
	static int N = 9;
	static int[] data = new int[N];
	static int[] temp = new int[N];
	static int count;
	static int total;
	static int[] cards = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < N; j++) {
					if (cards[j] == i)
						break;
					if (j == N - 1) {
						data[idx++] = i;
					}
				}
			}
			count = 0;
			total = 0;
			perm(0, 0);
			
			int win = count;
			int lose = total - count;
			System.out.printf("#%d %d %d\n", testCase, win, lose);
		}
	}

	public static void perm(int idx, int flag) {
		if (idx == N) {
			int score1 = 0;
            int score2 = 0;
            for (int i = 0; i < N; i++) {
                if (cards[i] > temp[i]) {
                	score1 += cards[i] + temp[i];
                } else {
                    score2 += cards[i] + temp[i];
                }
            }
            if (score1 > score2) {
                count++;
            }
            total++;
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
