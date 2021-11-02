package old.baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

//210305~

public class B_17070_파이프옮기기1_O {

	static int N,Ans;
	static int[][] arr;
	static boolean [][] v;
	
	static int[] dx = {0,1,1};
	static int[] dy = {1,0,1};
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		init();
		//가로 세로 대각선인지 저장
		//각각에 맞게 진행가능한지 확인
		
		dfs(0,1,1);
		//print();
		
		
		
		System.out.println(Ans);

	}

	private static void dfs(int i,int j,int d) {
		
		boolean flag = false;
		
		if(i==N-1 && j ==N-1) {
			Ans++;
			return;
		}
		
		if(d==1) {
			for (int D = 0; D <= 2; D++) {
				
				
				if(D==0) {
					int nx = i+dx[D];
					int ny = j+dy[D];
					if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
						
						if(arr[nx][ny] == 0) {
							dfs(nx,ny,1);
						}
						
						
					}
				}

				if(D==2) {
					int nx = i+dx[D];
					int ny = j+dy[D];
						if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
							for (int d2 = 0; d2 < 3; d2++) {
								int tx = i+dx[d2];
								int ty = j+dy[d2];
								
								if(arr[tx][ty]==1) flag = true;
							}
							
							if(!flag) {
								dfs(nx,ny,3);
								
							}
							
						}

				}
				
			}
		}
		else if(d==2) {
			for (int D = 0; D <= 2; D++) {
				
				
				if(D==1) {
					int nx = i+dx[D];
					int ny = j+dy[D];
					if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
						
						if(arr[nx][ny] == 0 ) {
							dfs(nx,ny,2);
						}
						
						
					}
				}

				if(D==2) {
					int nx = i+dx[D];
					int ny = j+dy[D];
						if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
							for (int d2 = 0; d2 < 3; d2++) {
								int tx = i+dx[d2];
								int ty = j+dy[d2];
								
								if(arr[tx][ty]==1) flag = true;
							}
							
							if(!flag) {
								dfs(nx,ny,3);
								
							}						
						}

				}
				
			}
			
			
		}
		else if(d==3) {
			for (int D = 0; D < 3; D++) {
				
				
				if(D==0) {
					int nx = i+dx[D];
					int ny = j+dy[D];
					if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
						
						if(arr[nx][ny] == 0) {
							dfs(nx,ny,1);
						}
						
						
					}
				}
				if(D==1) {
					int nx = i+dx[D];
					int ny = j+dy[D];
					if (nx>=0 && ny >= 0 && nx < N && ny <N) {
						
					if(arr[nx][ny] == 0 ) {
							dfs(nx,ny,2);
						}
					}
					
				}

				if(D==2) {
					int nx = i+dx[D];
					int ny = j+dy[D];
						if ( nx>=0 && ny >= 0 && nx < N && ny <N) {
							for (int d2 = 0; d2 < 3; d2++) {
								int tx = i+dx[d2];
								int ty = j+dy[d2];
								
								if(arr[tx][ty]==1) flag = true;
							}
							
							if(!flag) {
								dfs(nx,ny,3);

							}					
						}

				}
				
			}
			
			
		}
	
	}
	
	private static void init() {
		N = sc.nextInt();
		arr = new int [N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				arr[i][j]=a;
				if(a==1) v[i][j]=true;
			}
		}
		for (int i = 0; i < 2; i++) {
			arr[0][i]=1;
			v[0][i]=true;
		}
		
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}

}
