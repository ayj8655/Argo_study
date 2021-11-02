package old.swea.d4;

import java.util.*;
import java.io.*;


public class S_1219_길찾기 {

	static int V=100;
	static int [][] graph;
	static boolean [] visit;
	
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=10;
		
		for (int t = 1; t <= T; t++) {
			graph = new int [V][V];
			visit = new boolean[V];
			
			t = sc.nextInt();
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start][end] =1;	//유향이라 하나 무향이면 graph[start][end] =graph[end][start] =1;	
			}

			System.out.println("#"+t+" "+bfs(0));
			
		}
		
		sc.close();

	}

	private static int dfs(int v) {
		visit[v] = true;
		if(v==99) return 1;
		for (int u = 0; u < V; u++) {//진출값
			if(visit[u] == false && graph[v][u] ==1){//방문한적이 없고 인접했다면? 방문 가능
				if(dfs(u) ==1) return 1;
			}
		}
		return 0;
	}
	
	
	
	

	private static int bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[v] = true;
		q.offer(v);
		
		while (!q.isEmpty()) {
			v = q.poll();
			if(v==99) return 1;
			
			for (int u = 0; u < V; u++) {//진출값
				if(visit[u] == false && graph[v][u] ==1){//방문한적이 없고 인접했다면? 방문 가능
					visit[u] = true;
					q.offer(u);
					
				}
	
			}
		}
		
		return 0;
	}



}
