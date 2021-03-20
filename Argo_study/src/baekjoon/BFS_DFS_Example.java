package baekjoon;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Example {

	public static void main(String[] args) {
		//인접행렬
		int [][] adjMat = new int[8][8];
		adjMat[1][2] =1;
		adjMat[2][1] =1;
		adjMat[1][3] =1;
		adjMat[3][1] =1;
		adjMat[2][4] =1;
		adjMat[4][2] =1;
		adjMat[2][5] =1;
		adjMat[5][2] =1;
		adjMat[3][6] =1;
		adjMat[6][3] =1;
		adjMat[3][7] =1;
		adjMat[7][3] =1;
		//행렬끝
		//인접리스트
		ArrayList<Integer>[] adj = new ArrayList[8];
		
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		adj[1].add(2);
		adj[1].add(3);
		adj[2].add(4);
		adj[2].add(5);
		adj[3].add(6);
		adj[3].add(7);
		//리스트 끝
	//	bfs(adj,1);
		
		boolean []vv = new boolean[8];
//		dfs(adj,1,vv);
		
//		bfs(adjMat,1);
		dfs(adjMat,1,vv);
	}

	private static void dfs(int[][] adjMat, int n, boolean[] vv) {
		vv[n]=true;
		System.out.println(n);
		
		for (int i = 0; i <adjMat[n].length; i++) {
			if(!vv[i]&&adjMat[n][i]==1) {
				dfs(adjMat,i,vv);
			}
		}
	}

	private static void bfs(int[][] adjMat, int start) {
		boolean []v = new boolean[8];
		Queue<Integer>q= new LinkedList<>();
		q.add(start);
		v[start]=true;
		
		while (!q.isEmpty()) {
			Integer p = q.poll();
			System.out.println(p+" ");
			
			for (int i = 0; i < adjMat[p].length; i++) {//인접행렬의 뽑혀온애의 길이만큼
				if (!v[i]&&adjMat[p][i]==1) {//이러면 연골된거
					v[i]=true;
					q.add(i);
					
				}
			}
		}
		
	}

	private static void dfs(ArrayList<Integer>[] adj, int n, boolean[] vv) {
		vv[n]=true;
		System.out.println(n+" ");
		
		int size = adj[n].size();
		for (int i = 0; i < size; i++) {
			Integer nn = adj[n].get(i);
			if (!vv[nn]) {
				dfs(adj, nn, vv);
			}
		}		
	}

	private static void bfs(ArrayList<Integer>[] adj, int start) {
		boolean []v = new boolean[8];
		Queue<Integer>q= new LinkedList<>();
		q.add(start);
		v[start]=true;
		
		while (!q.isEmpty()) {
			Integer p = q.poll();
			System.out.print(p);
			
			int size = adj[p].size();
			
			for (int i = 0; i < size; i++) {
				Integer n = adj[p].get(i);
				if (!v[n]) {
					q.add(n);
					v[n]=true;
				}
			}
		}
	}
}
