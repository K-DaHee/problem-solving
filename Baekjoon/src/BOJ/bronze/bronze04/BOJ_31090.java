package BOJ.bronze.bronze04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_31090 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String current = br.readLine();
			int next = Integer.parseInt(current) + 1;
			int num = Integer.parseInt(current.substring(2, 3));

			String answer;
			if (next % num == 0)
				answer = "Good";
			else
				answer = "Bye";

			System.out.println(answer);
		}
	}
}
