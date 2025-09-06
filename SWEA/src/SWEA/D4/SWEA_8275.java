package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8275 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 우리의 개수
			int X = Integer.parseInt(st.nextToken());	// 한개의 우리에 들어갈 최대 햄스터 수
			int M = Integer.parseInt(st.nextToken());	// 기록 개수
			
			int[] cage = new int[N];	// 우리 개수만큼 배열 생성
			boolean[] check = new boolean[N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());
				for (int j = r; j >= l; j--) {
					int n;
					if(s - X >= 0) {
						s -= X;
						n = X;
					}
					else {
						n = s;
						s = 0;
					}
					cage[j] = n;
					check[j] = true;
				}
			}
			
			for (int i = 0; i < check.length; i++) {
				if(!check[i]) cage[i] = X;
			}
			
			for (int i = 0; i < cage.length; i++) {
				System.out.println(cage[i]);
			}
		}
	}
}
