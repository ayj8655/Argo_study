package old.baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_21278_호석이두마리치킨 {

	
	static int N,M;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_21278.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N+1][N+1];
		for (int i = 1; i <= M; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i == j) continue;
				else if (arr[i][j] == 0) arr[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					if( arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE)
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]); 
				}
			}
		}
		
		
		int minSum = Integer.MAX_VALUE;
		String result = "";
		
		// 두 개의 치킨집을 가정하고(i,j) 모든 건물들(k)과의 거리 총합 중 최소 값을 찾습니다.
		// "(j,k) + (j,k+1) + j(k+2) ..." 은 모든 건물들과 거리 총합
		for (int i = 1; i < N+1; i++) {
			for (int j = i+1; j < N+1; j++) {
				int sum = 0;
				// 건물(k)에서 치킨 집이 더 가까운 쪽으로 가기 때문에 (i,k) (j,k) 중 최소 값을 총합에 넣습니다.
				for (int k = 1; k < N+1; k++) {
					sum += Math.min(arr[i][k],arr[j][k]);
				}
				
				if(minSum > sum) {
					minSum = sum;
					result = i + " " + j + " " + minSum * 2;
				}
			}
		}
		System.out.println(result);

	}

}
