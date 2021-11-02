package old.baekjoon.gold;

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
			
			int d=0;	//방향 기본값
			char temp = st.nextToken().charAt(0);
			
			if (temp == 'W')//방향에 따라 설정
				d=1;
			else if (temp == 'S')
				d=2;
			else if (temp == 'N')
				d=3;
			
			att(x, y, d);//공
			
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			def(x,y);//방
		}
		
		
		sb.append(Ans).append("\n");
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ch[i][j]) 
                	sb.append("F ");
                else 
                	sb.append("S ");
            }
            sb.append("\n");
        }
		
		System.out.print(sb.toString());
		
	}

	
	static void att(int x, int y, int d) {
		if (ch[x][y]) //이미 넘어져있다면 아무일도 일어나지않는다
			return;
		
		int size = arr[x][y] - 1;
		ch[x][y] = true;	//초기값 넘어짐
		Ans++;
		while (size > 0) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) //경계값
				return;
			
			if (ch[nx][ny]) {//다음칸이 넘어져있다면?
				size--;
				x = nx;
				y = ny;
				continue;//컷
			}
			
			size--;
			ch[nx][ny] = true;
			Ans++;
			
			int nsize = arr[nx][ny] - 1;//넘어진 도미노의 사이즈
			x = nx;
			y = ny;
			
			if(nsize > size) size = nsize;	//넘어진게 넘어지게 만든애보다 크면 업데이트
			
		}
		
	}
	static void def(int x, int y) {//방어
		if(ch[x][y]) 	//넘어져있다면 
			ch[x][y] = false;	//다시 세워놓기
		else 
			return;
	}
}
