package baekjoon.silver;

import java.io.*;
import java.util.*;
//210406 DP 
//다시 풀어봐야함
public class B_17271_리그오브레전설 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_17271.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int mod = 1000000007;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int dp [] = new int [N+1];
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1];
			if(i-M >=0) 
				dp[i] = (dp[i] + dp[i-M]) % mod;
		}
				
		System.out.println(dp[N]);
	}

}
