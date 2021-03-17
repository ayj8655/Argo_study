package professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 다리만들기2_pro {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] adj;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("다리만들기2.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//print(map);
		// numbering
		int num = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==1) {
					numbering(r,c,num++);
				}
			}
		}
		//print(map);
		int V=num-2;
		adj=new int[V][V];
		for (int i = 0; i < V; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c]>1) {
					makeAdj(r,c);
				}
			}
		}
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if(adj[i][j]==Integer.MAX_VALUE) {
					adj[i][j]=0;
				}
			}
		}
		//print(adj);
		// mst
		int[] node = new int[V];
		boolean[]v = new boolean[V];
		Arrays.fill(node, Integer.MAX_VALUE);
		node[0]=0;
		
		for (int l = 0; l < V-1; l++) {
			//최소노드 찾기
			int minD=Integer.MAX_VALUE;
			int minIdx=-1;
			for (int i = 0; i < V; i++) {
				if(node[i]<minD&&!v[i]) {
					minD=node[i];
					minIdx=i;
				}
			}
			if(minIdx==-1) break;
			v[minIdx]=true;
			for (int i = 0; i < V; i++) {
				if(adj[minIdx][i]>0&&!v[i]&&adj[minIdx][i]<node[i]) {
					node[i]=adj[minIdx][i];
				}
			}
		}
		//System.out.println(Arrays.toString(node));
		int sum=0;
		for (int i = 0; i < V; i++) {
			if(node[i]==Integer.MAX_VALUE) {
				sum=-1;
				break;
			}
			sum+=node[i];
		}
		System.out.println(sum);
	}

	private static void makeAdj(int r, int c) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			int dist=0;
			while(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0) {
				dist++;
				nr+=dr[d];
				nc+=dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]!=0&&map[nr][nc]!=map[r][c]&&dist>1) {
					int start = map[r][c]-2;
					int end = map[nr][nc]-2;
					if(adj[start][end]>dist) {	//간선배열 생성
						adj[start][end]=dist;
						adj[end][start]=dist;
					}
				}
			}
		}
		
	}

	private static void numbering(int r, int c,int num) {
		map[r][c]=num;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1) {
				numbering(nr,nc,num);
			}
		}
		
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
