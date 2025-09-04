package BOJ.silver.silver05;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 정보를 입력 받을 배열
		String[][] info = new String[N][3];
		for (int i = 0; i < info.length; i++) {
			info[i][0] = sc.next();	// 0번째에 나이 입력
			info[i][1] = sc.next();	// 1번째에 이름 입력
			info[i][2] = i + "";	// 정보를 입력받는 순서로 정렬하기 위해 2번째에 순서 저장
		}
		Arrays.sort(info, (a, b) -> {
			int age1 = Integer.parseInt(a[0]);
			int age2 = Integer.parseInt(b[0]);
			int idx1 = Integer.parseInt(a[2]);
			int idx2 = Integer.parseInt(b[2]);
			
			if(Integer.compare(age1, age2) == 0) {
				return Integer.compare(idx1, idx2);
			} else {
				return Integer.compare(age1, age2);
			}
		});
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i][0] + " " + info[i][1]);
		}
	}
}
