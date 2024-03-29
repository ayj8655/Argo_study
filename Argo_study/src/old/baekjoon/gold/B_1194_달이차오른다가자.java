package old.baekjoon.gold;

import java.util.*;
import java.io.*;


public class B_1194_달이차오른다가자 {
	
	static class Point{
		int x;		int y;
		int cnt;	int key;

		public Point(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static int N,M;
	static char arr[][];
	static boolean[][][] check;
	
	static LinkedList<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_1194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		int x=0,y=0;
		arr = new char [N][M];
		check = new boolean[N][M][1 << 6];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == '0') {
					x=i;
					y=j;
				}
					
					
			}
		}
//		print();
		
		bfs(x,y);
		
	}


	private static void bfs(int x2, int y2) {
		
		q.add(new Point(x2, y2, 0,0));
		check[x2][y2][0] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			int truekey = p.key;
			
			
			
			for (int d = 0; d < 4; d++) {
				
				int nx = x+dx[d];
				int ny = y+dy[d];
				int key = truekey;
				
				if( nx < 0 || ny < 0 || nx >= N|| ny >= M || arr[nx][ny] == '#') continue;
				
				if(arr[nx][ny] == '1') {//찾았으면 거리 출력
					System.out.println(cnt+1);
					System.exit(0);
				}
				
				if(arr[nx][ny] == 'a' || arr[nx][ny] == 'b' || arr[nx][ny] == 'c' || arr[nx][ny] == 'd'|| arr[nx][ny] == 'e'|| arr[nx][ny] == 'f') 
					key |= (1 << arr[nx][ny] - 'a');
				
				
				if(arr[nx][ny] == 'A' || arr[nx][ny] == 'B' || arr[nx][ny] == 'C' || arr[nx][ny] == 'D'|| arr[nx][ny] == 'E'|| arr[nx][ny] == 'F') 
					if ((key & (1 << (arr[nx][ny] - 'A'))) == 0) continue;
				
				if (check[nx][ny][key])  continue;
           			
				
				check[nx][ny][key] = true;
				q.add(new Point(nx,ny,cnt+1,key));
				
			}	
		}
		
		System.out.println(-1);
	}


	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}

