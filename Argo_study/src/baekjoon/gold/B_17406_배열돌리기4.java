package baekjoon.gold;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



//배열돌리기 4
//순열
//https://www.acmicpc.net/problem/17406
public class B_17406_배열돌리기4 {
	
	static public class RT {
		int r,c,s;

		public RT(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
	}

	static int N,M,K,R,C,S,Ans=Integer.MAX_VALUE;
	static int sum;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static RT rtarr[];
	static int [][] arr;
	static int [][] rearr;
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("배열돌리기4.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//크기 
		M = sc.nextInt();//크기
		K = sc.nextInt();//회전연산개수
		arr = new int[N][M];
		rearr= new int[N][M];
		rtarr = new RT[K];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				rearr[i][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < K; i++) {
			R = sc.nextInt();
			C = sc.nextInt();
			S = sc.nextInt();
			rtarr[i] = new RT(R,C,S);
		}
		
		dfs(new boolean[K],new int [K],0);
		
		//rotation(R,C,S);
		
		System.out.println(Ans);
		//print(arr);
	}
	
	private static void dfs(boolean[] v, int[] sel, int k) {
		if(k==sel.length) {
			sum=0;
			
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					 arr[i][j] = rearr[i][j];
				}
			}
			
			for (int i = 0; i < sel.length; i++) {
				rotation(rtarr[sel[i]].r,rtarr[sel[i]].c,rtarr[sel[i]].s);
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					sum += arr[i][j];
				}
				Ans = Math.min(Ans, sum);
				sum=0;
			}
			
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!v[i]) {
				v[i] =true;
				sel[k] = i;
				dfs(v, sel, k+1);
				v[i] =false;
			}
			
		}
	}
	
	private static void rotation(int r, int c, int s) {
		//3 4 2
//		int fxx = r-s;	//1
//		int fyy = c-s;	//2
//		int lxx = r+s;	//5
//		int lyy = c+s;	//6
		
		int arrx = Math.abs((r-s) - (r+s))+1;
		int arry = Math.abs((c-s) - (c+s))+1;
		int [][] temp = new int[arrx][arry];
		
		for (int i = 0; i < (temp.length); i++) {
			for (int j = 0; j < (temp[i].length); j++) {
				temp[i][j] = arr[(r-s)-1+i][(c-s)-1+j];
			}
		}
		
		int SS = Math.min(arrx, arry) / 2;	//돌릴개수
		
		for (int j = 0; j < SS; j++) {
			int d =0; //d는 방향
			int ox=j, oy=j;
			int tmp = temp[ox][oy];
			
			while (d<4) {
				int nx = ox + dx[d];
				int ny = oy + dy[d];
				
				if (nx >= j && ny >= j && nx < arrx -j && ny <arry -j) {
					temp[ox][oy] = temp[nx][ny];
					ox = nx;
					oy = ny;
				} else d++;
				
			}
			temp[j][j+1] = tmp;
		}
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				arr[(r-s)-1+i][(c-s)-1+j] = temp[i][j];
			}
		}
		
		print(arr);
		
	}
	
	
	

	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
	}
	
	

}
