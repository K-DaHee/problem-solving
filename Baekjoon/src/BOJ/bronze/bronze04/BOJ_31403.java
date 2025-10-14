package BOJ.bronze.bronze04;

import java.util.Scanner;

public class BOJ_31403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		
		int result1 = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
		System.out.println(result1);
		
		String add = A + B;
		int result2 = Integer.parseInt(add) - Integer.parseInt(C);
		System.out.println(result2);
	}
}
