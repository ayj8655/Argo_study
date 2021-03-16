package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_16235_나무재테크 {

	
	static int arr[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y =Integer.parseInt(st.nextToken());
		int z =Integer.parseInt(st.nextToken());
		//--------------------입력 끝
		
		
		
		
		
	}

}
