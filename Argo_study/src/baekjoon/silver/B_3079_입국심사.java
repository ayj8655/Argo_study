package baekjoon.silver;

import java.util.*;
import java.io.*;


public class B_3079_입국심사 {
	
	static int N,M,Ans;
	static int arr[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_3079.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		System.out.println(Ans);
	}
}
