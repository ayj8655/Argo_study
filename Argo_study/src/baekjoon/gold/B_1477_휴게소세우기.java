package baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_1477_휴게소세우기 {

	static int N,M,L,left,right,Ans;
	static int arr[];
	
	public static void main(String[] args)throws Exception{
		System.setIn(new FileInputStream("res/input_B_1477.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N + 2];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 1; i <= N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		
		arr[0] = 0;
		arr[N + 1] = L;
		
		left = 0;
		right = L;
		
		Arrays.sort(arr);
		
		// 0 82 201 411 555 622 755 800
		//System.out.println(Arrays.toString(arr));
		

		while (left <= right) {
			
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < N + 2; i++) {
				sum += (arr[i] - arr[i - 1] - 1) / mid;
	//			System.out.println(sum +" "+arr[i] +" "+arr[i - 1] +" "+mid);
			}
				
//			System.out.println("mid: "+mid+" sum: "+sum+", L: "+left+" right: "+right);
			
			if (sum > M) left = mid + 1;	// 현재 mid의 거리 차이가 가능하다면 => 더 최대값을 찾기 위해 더 넓은 범위 탐색. 
			
			else right = mid - 1;			// 더 적게 세워야 하면 간격을 줄인다

		}
		
		
		System.out.println(left);
	}

		


}