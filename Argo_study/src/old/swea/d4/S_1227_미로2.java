package old.swea.d4;

import java.io.*;
import java.util.*;
public class S_1227_미로2 {
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int arr[][];
	static boolean[][]v;
	
	static int find,N=100;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		for (int t = 1; t <= 10; t++) {
			arr = new int [N][N];			
			v = new boolean [N][N];
			Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			find=0;
			bfs(1,1,0);	
//			dfs(1,1);
			sb.append("#").append(t).append(" ").append(find).append("\n");
		}		
		System.out.print(sb.toString());
		br.close();

	}

	private static void dfs(int i, int j) {
		v[i][j]= true;
		
		if(arr[i][j] == 3) {
			find=1;
			return;
		}	
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(0<=nx && nx<N && 0<= ny && ny<N && !v[nx][ny] && arr[nx][ny] != 1) {
				dfs(nx,ny);
				
			}		
		}	
	}
	

	

	static void bfs(int i, int j, int k) {
		//스택과 링크드리스트 대신에 ArrayDeq
		
	//	LinkedList<int[]> q = new LinkedList<int[]>();
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		
		v[i][j]= true;
		q.offer(new int[] {i,j,k});
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			i = cur[0];
			j = cur[1];
			k = cur[2];
			if(arr[i][j] == 3) {
				System.out.println(k);	//이거로 최단경로 출력
				find=1;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				
				if(0<=nx && nx<N && 0<= ny && ny<N && !v[nx][ny] && arr[nx][ny] != 1) {
					v[nx][ny]= true;
					q.offer(new int[] {nx,ny,k+1});
					
				}		
			}	
		}	
	}
}
