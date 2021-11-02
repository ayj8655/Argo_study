package old.swea.d4;

import java.util.*;
import java.io.*;


public class S_1219_길찾기2 {

	static int V=100;
	static ArrayList<Integer>[] graph;
	static boolean [] visit;
	
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=10;
		
		for (int t = 1; t <= T; t++) {
			graph = new ArrayList [V];//어레이리스트의 주소를 담는 배열 객체
			
			for (int i = 0; i < V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			visit = new boolean[V];
			
			t = sc.nextInt();
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start].add(end);	//유향이라 하나 무향이면 graph[start][end] =graph[end][start] =1;	
			}

			System.out.println("#"+t+" "+bfs(0));
			
		}
		
		sc.close();

	}

	private static int dfs(int v) {
		
		visit[v] = true;
		
			if(v==99) return 1;
			
			for (int u : graph[v]) {//진출값
				if(visit[u] == false){//
					visit[v] = true;
					
					
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
			
			for (int u : graph[v]) {//진출값
				if(visit[u] == false){//
					visit[u] = true;
					q.offer(u);
					
				}
	
			}
		}
		
		return 0;
	}



}
