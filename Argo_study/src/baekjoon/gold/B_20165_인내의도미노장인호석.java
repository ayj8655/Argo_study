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
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 라운드 수 
		
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
			int cr = Integer.parseInt(st.nextToken()) - 1;
			int cc = Integer.parseInt(st.nextToken()) - 1;
			int d = checkDir(st.nextToken().charAt(0));
			
			attack(cr, cc, d);
			
			st = new StringTokenizer(br.readLine(), " ");
			cr = Integer.parseInt(st.nextToken()) - 1;
			cc = Integer.parseInt(st.nextToken()) - 1;
			
			defense(cr,cc);
		}
		System.out.println(Ans);
		
		for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                // 도미노가 넘어진 것
                if (ch[row][col]) {
                    System.out.print("F ");
                } 
                // 도미노가 세워진 것
                else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }

		
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

	static void attack(int cr, int cc, int d) {
		if (ch[cr][cc]) {
			return;
		} else {
			int size = arr[cr][cc] - 1;
			ch[cr][cc] = true;
			Ans++;
			while (size > 0) {
				int nx = cr + dx[d];
				int ny = cc + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					return;
				}
				if (ch[nx][ny]) {
					size--;
					cr = nx;
					cc = ny;
					continue;
				}
				size--;
				ch[nx][ny] = true;
				int newSize = arr[nx][ny] - 1;
				cr = nx;
				cc = ny;
				Ans++;
				size = newSize > size ? newSize : size;
			}
		}
	}
	static void defense(int cr, int cc) {
		if(ch[cr][cc]) {
			ch[cr][cc] = false;
		}else {
			return;
		}
	}

}
