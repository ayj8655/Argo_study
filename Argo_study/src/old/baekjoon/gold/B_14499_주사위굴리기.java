package old.baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_14499_주사위굴리기 {
	
	static int N,M,x,y,K;
	static int arr[][];
	static int dice[];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
	//	System.setIn(new FileInputStream("res/input_B_14499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());	//이거 반대로 해서 틀림
		x = Integer.parseInt(st.nextToken());	//이거 반대로 해서 틀림 
		K = Integer.parseInt(st.nextToken());
		
		arr = new int [N][M];
		dice = new int [7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		
		//print();
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < K; i++) {	//K번 만큼 명령 반복
			int D = Integer.parseInt(st.nextToken());		
			int nx = x + dx[D-1];
			int ny = y + dy[D-1];
			
			if(nx >=0 && ny >=0 && nx< M && ny <N) {
				
				dicemove(D);
				
				if(arr[ny][nx] == 0) arr[ny][nx] = dice[6];
				else {
					dice[6] = arr[ny][nx];
					arr[ny][nx]= 0;
				}
				x = nx;
				y = ny;
				sb.append(dice[1]).append("\n");
			}
		}
		System.out.println(sb.toString());

	}
	private static void dicemove(int d) {
		int tem = dice[1];
		if(d==1) {
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tem;
		}else if (d==2) {
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tem;
		}else if (d==3) {
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tem;
		}else if (d==4) {
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tem;
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
