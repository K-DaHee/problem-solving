package BOJ.bronze.bronze03;

import java.util.Scanner;

public class BOJ_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			int count = 1;
			while(n > h) {
				count++;
				n -= h;
			}
			String result = Integer.toString(count);
			if(count < 10) {
				result = "0" + Integer.toString(count);
			}
			System.out.println(n + result);
		}
	}
}
