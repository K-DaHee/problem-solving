package BOJ.bronze.bronze03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int max = 0;
			int[] nums = new int[3];
			for (int i = 0; i < 3; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			max = nums[2];

			if (max == 0)
				break;

			double sum = Math.pow(nums[0], 2) + Math.pow(nums[1], 2);

			if (Math.pow(max, 2) == sum) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
