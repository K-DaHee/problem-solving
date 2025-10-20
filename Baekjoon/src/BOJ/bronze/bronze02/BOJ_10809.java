package BOJ.bronze.bronze02;

import java.util.Scanner;

public class BOJ_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] position = new int[26];
		for (int i = 0; i < position.length; i++) {
			position[i] = -1;
		}

		char[] arr = sc.next().toCharArray();		
		for (int i = 0; i < arr.length; i++) {
			if (position[arr[i] - 'a'] == -1)
				position[arr[i] - 'a'] = i;
		}
		
		for (int i : position) {
			System.out.print(i + " ");
		}
	}
}
