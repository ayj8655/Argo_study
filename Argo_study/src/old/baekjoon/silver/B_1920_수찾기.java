package old.baekjoon.silver;


import java.io.*;
import java.util.*;

public class B_1920_수찾기 {
	
	static int arr[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_1920.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			int X = Integer.parseInt(st.nextToken());
			int start=0;
			int end = arr.length-1;
			int mid =0;
			
			boolean flag = false;
			while (start<=end) {
				
				mid = (start + end) / 2;
				if(arr[mid] ==X) {
					flag = true;
					sb.append(1+"\n");
					break;
				} else if(arr[mid]>X)
					end = mid-1;
				else if(arr[mid]<X)
					start=mid+1;	
			}
			if(!flag)
				sb.append(0+"\n");

		}
		
		System.out.print(sb.toString());
		
		

	}

}
