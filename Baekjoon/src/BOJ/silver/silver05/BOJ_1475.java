package BOJ.silver.silver05;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		int[] setCount = new int[10];
		for (char c : arr) {
			int idx = c - '0';
			if(idx == 6) {
				if(setCount[6] > setCount[9]) setCount[9] += 1;
				else setCount[6] += 1;
			} else if(idx == 9) {
				if(setCount[9] > setCount[6]) setCount[6] += 1;
				else setCount[9] += 1;
			} else {
				setCount[idx] += 1;
			}
		}
		Arrays.sort(setCount);
		System.out.println(setCount[setCount.length - 1]);
	}
}
