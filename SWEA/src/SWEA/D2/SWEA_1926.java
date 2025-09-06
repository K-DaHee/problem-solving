package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int count = 0;
			char[] num = Integer.toString(i + 1).toCharArray();
			for (int j = 0; j < num.length; j++) {
				// 3, 6, 9가 있다면 몇개 있는지 count
				if(num[j] == '3' || num[j] == '6' || num[j] == '9') {
					count++;
				}
			}
			// count 수 만큼 - 반복해서 출력
			if(count > 0) {
				for (int j = 0; j < count; j++) {
					System.out.print("-");
				}
			} else {
				// count가 없다면. 즉, 3, 6, 9가 포함되지 않았으면 숫자 그냥 출력
				System.out.print(i + 1);
			}
			// 공백 분리
			System.out.print(" ");
		}
	}
}
