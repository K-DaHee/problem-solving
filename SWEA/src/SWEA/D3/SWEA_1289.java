package SWEA.D3;

import java.util.Scanner;

public class SWEA_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] nums = sc.next().toCharArray();

			int[] arr = new int[nums.length];
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (nums[i] - '0' != arr[i]) {
					count++;
					for (int j = i; j < arr.length; j++) {
						if(arr[j] == 0)	arr[j] = 1;
						else arr[j] = 0;
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}
