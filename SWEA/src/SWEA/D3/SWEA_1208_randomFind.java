package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1208_randomFind {
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
            
            // while 반복을 위한 변수
            int j = 0;
            // sort 없이 max, min 값을 찾기 위한 변수
            int maxIdx = 0, minIdx = 0;
            int max = 0, min = 0;
            
            while(j < dump) {
            	maxIdx = 0;
                minIdx = 0;
                // sort 없이 box 의 최대인덱스, 최소인덱스 찾기
            	for (int i = 1; i < box.size(); i++) {
                    if (box.get(i) > box.get(maxIdx)) maxIdx = i;
                    if (box.get(i) < box.get(minIdx)) minIdx = i;
                }
            	
            	// 최대, 최소 인덱스에 해당하는 값 저장
                max = box.get(maxIdx);
                min = box.get(minIdx);
                
                // 평탄화 작업
                box.set(maxIdx, max - 1);
                box.set(minIdx, min + 1);
                
                j++;
            }
            
            maxIdx = 0;
            minIdx = 0;
            // 마지막 max, min 저장하기 위해 max, min 찾기
            for (int i = 1; i < box.size(); i++) {
                if (box.get(i) > box.get(maxIdx)) maxIdx = i;
                if (box.get(i) < box.get(minIdx)) minIdx = i;
            }
            max = box.get(maxIdx);
            min = box.get(minIdx);
            
            int gap = max - min;
			System.out.println("#" + testCase + " " + gap);
		}
	}
}
