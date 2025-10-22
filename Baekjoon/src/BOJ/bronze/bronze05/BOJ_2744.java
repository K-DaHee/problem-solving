package BOJ.bronze.bronze05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String answer = "";
		for(char c : br.readLine().toCharArray()) {
			if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            }else{
                answer += Character.toUpperCase(c);
            }
		}
		System.out.println(answer);
	}
}
