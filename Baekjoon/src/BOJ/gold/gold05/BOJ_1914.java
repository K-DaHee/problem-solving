package BOJ.gold.gold05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1914 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BigInteger count = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
		System.out.println(count);
		
		if(N > 20) return;
		
		hanoi(N, 1, 2, 3);
	}

	public static void hanoi(int N, int start, int mid, int end) {
		if (N == 1) {
			System.out.println(start + " " + end);
			return;
		}
		hanoi(N - 1, start, end, mid);
		System.out.println(start + " " + end);
		hanoi(N - 1, mid, start, end);
	}
}
