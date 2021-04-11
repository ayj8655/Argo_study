package baekjoon.gold;

import java.util.*;
import java.io.*;


public class B_20165_인내의도미노장인호석 {
	
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static int arr[][];
	static boolean ch[][];
	static int N, M, R,Ans;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_20165.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		ch = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = checkDir(st.nextToken().charAt(0));
			
			attack(x, y, d);
			
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			defense(x,y);
		}
		
		sb.append(Ans).append("\n");
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ch[i][j]) 
                	sb.append("F ");// 도미노가 넘어진 것
                else 
                	sb.append("S ");// 도미노가 세워진 것
            }
            sb.append("\n");
        }
		
		System.out.print(sb.toString());
		
	}
	
	static int checkDir(char cs) {
		if (cs == 'E') {//오
			return 0;
		} else if (cs == 'W') {//왼
			return 1;
		} else if (cs == 'S') {//하
			return 2;
		} else if (cs == 'N') {//상
			return 3;
		}
		return 0;
	}

	static void attack(int x, int y, int d) {
		if (ch[x][y]) {
			return;
		} else {
			int size = arr[x][y] - 1;
			ch[x][y] = true;
			Ans++;
			while (size > 0) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					return;
				}
				if (ch[nx][ny]) {
					size--;
					x = nx;
					y = ny;
					continue;
				}
				size--;
				ch[nx][ny] = true;
				int newSize = arr[nx][ny] - 1;
				x = nx;
				y = ny;
				Ans++;
				size = newSize > size ? newSize : size;
			}
		}
	}
	static void defense(int x, int y) {
		if(ch[x][y]) 
			ch[x][y] = false;
		else 
			return;
		
	}

}
