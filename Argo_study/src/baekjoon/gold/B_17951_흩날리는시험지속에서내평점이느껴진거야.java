package baekjoon.gold;

import java.io.*;
import java.util.*;


public class B_17951_흩날리는시험지속에서내평점이느껴진거야 {

	static int N,K,Ans;
	static int arr[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_17951.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());		
		arr = new int [N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left =0;
		int right = N*20;
		
		while (left <= right) {
			int mid = (left+right) / 2;
			
			if(isPossible(mid)) 
				left = mid +1;
			else 
				right = mid-1;
		}
		
		System.out.println(Ans);
	}

	private static boolean isPossible(int mid) {
		
		int score = 0;
		int tem = Integer.MAX_VALUE;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (score + arr[i] >= mid) {
				score += arr[i];
				tem = Math.min(tem, score);
				score = 0;
				cnt++;
				if (cnt > K) {
					Ans = Math.max(Ans, tem);
					return true;
				}
			}
			else 
				score += arr[i];
		}
		return false;
	}

}
