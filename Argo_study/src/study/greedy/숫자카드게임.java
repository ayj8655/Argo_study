package study.greedy;
import java.io.*;
import java.util.*;

public class 숫자카드게임 {
	
	static int N,M,ans;
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_숫자카드게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N][M];
		
		
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int min = 999999;
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(min > arr[i][j]) {
					min = arr[i][j];
				}
			}
			
			if (ans < min) {
				ans = min;
			}
		}
		
		System.out.println(ans);
		
	}

}
