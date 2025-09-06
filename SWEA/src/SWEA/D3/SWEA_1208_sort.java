package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1208_sort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스는 10번만 돌아간다.
		for (int testCase = 1; testCase <= 10; testCase++) {
			// dump 값 읽기
			int dump = Integer.parseInt(br.readLine());

            // 한 줄에 들어있는 박스 높이들 읽기
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> box = new ArrayList<>();

            while (st.hasMoreTokens()) { // 토큰이 있는 동안 반복
                box.add(Integer.parseInt(st.nextToken()));
            }
			
			int j = 0, max = 0, min = 0;
			while(j < dump) {
				Collections.sort(box);
				max = box.get(box.size() - 1);
				min = box.get(0);
				if (max - min <= 1) break;
				
				box.set(box.size() - 1, box.get(box.size() - 1) - 1);
				box.set(0, box.get(0) + 1);
				j++;
			}
			Collections.sort(box);
			max = box.get(box.size() - 1);
			min = box.get(0);
			
			int gap = max - min;
			System.out.println("#" + testCase + " " + gap);
		}
		
	}
}
