package baekjoon.silver;

import java.util.*;
import java.io.*;


public class B_2563_색종이 {
	
	static int N,Ans=0;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_B_2563.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		N = Integer.parseInt(br.readLine());
	
		int [][] arr = new int[100][100];
		
		for (int i = 0; i < N; i++) {
		
			st = new StringTokenizer(br.readLine()," ");
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {			
					if(arr[x+nx][y+ny]==1) continue;
					arr[x+nx][y+ny] =1;
					Ans++;
				}
			}
		}
		
		System.out.println(Ans);
	}
}
