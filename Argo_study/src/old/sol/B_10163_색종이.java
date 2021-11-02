package old.sol;

import java.util.*;
import java.io.*;

public class B_10163_색종이 {
	
	static int N, cnt=1;
	static int arr[][];
	
	public static void main(String[] args) throws Exception{
		
		arr = new int [101][101];
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for (int t = 0; t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			
			for (int q = x; q < x+w; q++) {
				for (int e = y; e < y+h; e++) {
					arr[q][e] = cnt;
				}
			}
			cnt++;
			
		}
		
		int cnt1[] = new int [101];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				cnt1[arr[i][j]]++;
			}
		}
		
		for (int i = 1; i < cnt; i++) {
			System.out.println(cnt1[i]);
		}
		
		
	}

}
