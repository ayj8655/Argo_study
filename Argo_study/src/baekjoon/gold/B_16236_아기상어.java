package baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_16236_아기상어 {
	static class Point{
		int x,y,d;

		public Point(int x, int y, int d) {
			this.x = x;			this.y = y;
			this.d = d;	//d 는 거리값 저장
		}
	}
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	/*
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	*/
	
	static LinkedList<Point> fish;
	static int arr[][];
	
	
	static int sx,sy;//상어의 위치 저장
	static int s_size = 2;
	static int s_eat=0;
	static int Ans=0;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_B_16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					sx=i;
					sy=j;
					arr[i][j]=0;
				}
			} 
		}
		
		while (true) {
			bfs(N);//상어 이동가능한곳 탐색, 먹는거가능한 물고기도 탐색

			int f_size = fish.size();
			
			if(f_size==0) break;	//물고기 리스트 없으면 종료
			
			Point eat = fish.get(0);//처음값으로 길이비교
			for (int i = 1; i < f_size; i++) {
				
				if(fish.get(i).d < eat.d) eat = fish.get(i);
				
				if(eat.d == fish.get(i).d) {
					if(eat.x >fish.get(i).x) eat = fish.get(i);
				}
			}
			
			s_eat++;
			arr[eat.x][eat.y] = 0;
			sx = eat.x;
			sy = eat.y;
			
			if(s_eat == s_size) {
				s_size++;
				s_eat = 0;
			}
			
			Ans += eat.d;
		}
		
		System.out.println(Ans);
		br.close();
	}

	private static void bfs(int N) {
		fish = new LinkedList<>();
		LinkedList<Point> q = new LinkedList<>();
		boolean v [][] = new boolean [N][N];
		
		q.add(new Point(sx,sy,0));
		v[sx][sy] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx<0 || ny < 0|| nx>= N || ny >= N) continue;
				
				if(v[nx][ny]) continue;
				
				if(1<=arr[nx][ny] && arr[nx][ny] <s_size) {	//먹을수있는 물고기 위치임
					q.add(new Point(nx,ny,p.d+1));
					fish.add(new Point(nx,ny,p.d+1));
					v[nx][ny] = true;
				} else if(arr[nx][ny] == 0 || arr[nx][ny] == s_size) {	//지나가는거 가능
					q.add(new Point(nx,ny,p.d+1));
					v[nx][ny] = true;
				}			
			}
		}
	}

}
