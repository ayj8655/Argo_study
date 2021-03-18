package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_14499_주사위굴리기 {
	
	static int N,M,x,y,K;
	static int X,Y;
	static int arr[][];
	static int d[] = {1,2,3,4};//동 서 북 남
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_14499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) {
					X = i;//주사위 기본위치
					Y = j;//주사위 기본 위치
				}
			} 
		}
		//print();
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < K; i++) {	//K번 만큼 명령 반복
			int D = Integer.parseInt(st.nextToken());
			
			
		}
		
		
		
		
		
		
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");	
			} 
			System.out.println();
		}
	}
}
