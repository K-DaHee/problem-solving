package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			char[] input = br.readLine().toCharArray();
			
			Stack<Integer> st = new Stack<>();
			
			List<int[]> bar = new ArrayList<>();
			List<Integer> laser = new ArrayList<>();
			
			for (int j = 0; j < input.length; j++) {
				if(input[j] == '(') {
					st.push(j);
				} else {
					int n = st.pop();
					if(n == j-1) {
						laser.add(j);
					} else {
						bar.add(new int[] {n, j});
					}
				}
			}
			int sum = 0;
		    for (int[] b : bar) {
		        int start = b[0];
		        int end = b[1];
		        
		        // lower bound
		        int left = 0, right = laser.size();
		        while (left < right) {
		            int mid = (left + right) / 2;
		            if (laser.get(mid) >= start) right = mid;
		            else left = mid + 1;
		        }
		        int lower = left;
		        
		        // upper bound
		        left = 0; right = laser.size();
		        while (left < right) {
		            int mid = (left + right) / 2;
		            if (laser.get(mid) > end) right = mid;
		            else left = mid + 1;
		        }
		        int upper = left;
		        
		        int count = upper - lower + 1; // 포함된 레이저 개수 + 막대 조각 1개
		        
		        sum += count;
		    }
			
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
