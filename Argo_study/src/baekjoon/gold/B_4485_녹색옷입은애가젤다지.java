package baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_4485_녹색옷입은애가젤다지 {
	
    static class Edge implements Comparable<Edge> {
		int start;		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static int N;
	static int arr[][];
	static int dis[][];
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_B_4485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t =0;
		while (true) {
			t++;
			N = Integer.parseInt(br.readLine());
			if(N ==0) break;	//0이면 종료
			
			arr = new int[N][N];
			dis = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			
			PriorityQueue<Edge> q = new PriorityQueue<>();
			
			q.add(new Edge(0, 0, arr[0][0]));
			
			dis[0][0] = arr[0][0];
			while (!q.isEmpty()) {
				Edge e = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = e.start + dx[d]; 
					int ny = e.end + dy[d];
					
					if(nx >=0 & ny >= 0 && nx <N && ny < N ) {
						
						if(dis[nx][ny] > e.weight + arr[nx][ny]) {
							dis[nx][ny] = e.weight + arr[nx][ny];
							q.offer(new Edge(nx,ny,dis[nx][ny]));
							
						}			
					}
				}
			}
			
			sb.append("Problem ").append(t).append(": ").append(dis[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}

}
