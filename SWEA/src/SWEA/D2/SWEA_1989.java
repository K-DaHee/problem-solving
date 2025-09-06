package SWEA.D2;

import java.util.Scanner;

public class SWEA_1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			char[] arr = sc.next().toCharArray();
			boolean isSame = false;
			for (int i = 0; i < arr.length/2; i++) {
				if(arr[i] == arr[arr.length - i]) isSame = true;
				else isSame = false;
			}
			
			if(isSame) System.out.println();
		}
	}
}
