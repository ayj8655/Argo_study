package professor;

import java.util.*;
import java.io.*;


public class B_1260_DFS와BFS_pro {
	static int N,M,V;
	static int[][] a;
	static boolean[] visited;
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("res/DFS_BFS.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		V=sc.nextInt();
		a=new int[N+1][N+1];
		for (int i = 1; i <= M; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			a[s][t]=1;
			a[t][s]=1;			
		}
		//print(matrix);
		visited=new boolean[N+1];
		dfs(a,V);
		
		visited=new boolean[N+1];
		
		System.out.println();
		
		bfs(a);
	}
	
	private static void bfs(int[][] a) {
		Queue<Integer> q = new LinkedList();
		q.add(V);
		visited[V]=true;
		while(!q.isEmpty()) {
			Integer p = q.poll();
			System.out.print(p+" ");
			for (int i = 1; i <= N; i++) {
				if(a[p][i]==1&&!visited[i]) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
	}

	private static void dfs(int[][] a, int v) {
		visited[v]=true;
		System.out.print(v+" ");
		for (int i = 1; i <= N; i++) {
			if(a[v][i]==1&&!visited[i]) {
				dfs(a,i);
			}
		}
	}

	private static void print(int[][] matrix) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}