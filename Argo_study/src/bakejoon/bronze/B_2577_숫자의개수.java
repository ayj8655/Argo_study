package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_2577_숫자의개수 {
	
	static int arr[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = A*B*C;
		
		
		arr = new int[10];
		
		//valueOf = 숫자를 문자열로 변경해줌
		String str = String.valueOf(D);
		int length = str.length();
		
		for (int i = 0; i < length; i++) {
			arr[str.charAt(i)-48]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
