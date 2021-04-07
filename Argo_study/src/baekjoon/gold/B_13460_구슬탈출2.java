package baekjoon.gold;

import java.io.*;
import java.util.*;


//20210406
//이해가 필요함
public class B_13460_구슬탈출2 {
	
	static class Point{
		int R[];
		int B[];
		int dis;
		
		public Point(int[] r, int[] b, int dis) {
			R = r;
			B = b;
			this.dis = dis;
		}
		public Point() {
		}	
	}
	
 
	
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	static int N,M;
	static char arr[][];
	static boolean v1[][][][];
	
	
	public static void main(String[] args)throws Exception {
		
		System.setIn(new FileInputStream("res/input_B_13460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char [N][M];
		v1 = new boolean [N][M][N][M];
		
		Point p = new Point();
		p.dis =0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				
				if(arr[i][j] == 'R')
					p.R = new int[] {i,j};
				else if (arr[i][j] == 'B')
					p.B = new int[] {i,j};
			}
		}
		
		bfs(p);

	}

	private static void bfs(Point p) {
		LinkedList<Point> q = new LinkedList<>();
		
		q.offer(p);
		
		v1[p.R[0]][p.R[1]][p.B[0]][p.B[1]] = true;
		
		while (!q.isEmpty()) {
			
			Point P = q.poll();
			
			if(P.dis >= 10) {	//횟수 넘어가면 끝
				System.out.println(-1);
				return;
			}
			
//			System.out.println(P.dis+" 번 진행");
			
			for (int d = 0; d < 4; d++) {
//				System.out.println(d +"방향 가는중");
				int Rx = P.R[0];
				int Ry = P.R[1];
				int Bx = P.B[0];
				int By = P.B[1];
				
				while (arr[Rx+dx[d]][Ry+dy[d]] !='#') {
					Rx+=dx[d];
					Ry+=dy[d];
					if(arr[Rx][Ry] == 'O')
						break;
				}
				
				while (arr[Bx+dx[d]][By+dy[d]] !='#') {
					Bx+=dx[d];
					By+=dy[d];
					
					if(arr[Bx][By] == 'O')
						break;
				}
				

                if (arr[Bx][By] == 'O')
                    continue;
                
                if (arr[Rx][Ry] == 'O') {
                    System.out.println(P.dis + 1);
                    return;
                }
				
                if (Rx == Bx && By == Ry) {
                	 
                    switch (d) {
                    case 0: // 동
                    if (P.R[1] > P.B[1])
                        By -= 1;
                    else
                        Ry -= 1;
                    break;
                case 1: // 서
                    if (P.R[1] > P.B[1])
                        Ry += 1;
                    else
                        By += 1;
                    break;
                case 2: // 남
                    if (P.R[0] > P.B[0])
                        Bx -= 1;
                    else
                        Rx -= 1;
                    break;
                case 3: // 북
                    if (P.R[0] > P.B[0])
                        Rx += 1;
                    else
                        Bx += 1;
                    break;
                   
                    }
                }
                
                
                if (!v1[Rx][Ry][Bx][By]) {
                	v1[Rx][Ry][Bx][By] = true;
                    q.offer(new Point(new int[] {Rx,Ry},new int[] {Bx,By}, P.dis + 1));
                }
			}		
		}

		System.out.println(-1);
	}
	
}
