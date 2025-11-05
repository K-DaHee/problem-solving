package BOJ.bronze.bronze01;

import java.util.Scanner;

public class BOJ_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double sum = 0;
		double max = 0;
		double[] nums = new double[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextDouble();
			max = Math.max(max, nums[i]);
		}
		
		for (int i = 0; i < nums.length; i++) {
			double num = (nums[i] / max) * 100;
			sum += num;
		}
		System.out.println(sum / n);
	}
}
