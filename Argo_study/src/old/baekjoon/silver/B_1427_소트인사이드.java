package old.baekjoon.silver;

import java.io.*;
import java.util.*;

public class B_1427_소트인사이드 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_1427.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String[] arr = str.split(""); //문자열을 잘라서 배열로 리턴
		Arrays.sort(arr, Comparator.reverseOrder());	//배열을 내림차순정렬
		
		for (int i = 0; i < arr.length; i++) 
			sb.append(arr[i]);

		System.out.println(sb);
		
	}
}
