package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_1546_평균 {
	
	static double arr[];
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		arr = new double[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		double max = Double.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			if(arr[i] > max) max = arr[i];
		}
		
		
		double result = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = (arr[i] / max) * 100;
			result += arr[i];
		}
		System.out.println(result / N);
		
	}

}
