package bakejoon.bronze;

import java.io.*;
import java.util.*;

public class B_10818_최소_최대 {
	
	static int arr[];
	public static void main(String[] args) throws Exception {
	
		System.setIn(new FileInputStream("res/input_B_10818.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i =0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min=Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] > max) {
				max = arr[i];
			}
			
		}
		
		System.out.print(min+" "+ max);
		
		
//		Arrays.sort(arr);
//		System.out.print(arr[0]+" "+ arr[arr.length - 1]);
	}

}
