package old.professor;

import java.io.FileInputStream;
import java.util.Scanner;

public class B_17136_색종이붙이기_pro {
	static int N=10;
	static int[][] map = new int[N][N];
	
	static int[] paper = new int[]{0,5,5,5,5,5};
	
	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("색종이붙이기.txt"));
		Scanner sc = new Scanner(System.in);
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c]=sc.nextInt();
			}
		}
		
		//print(map);
		solve(0);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
	static int ans = Integer.MAX_VALUE;
	static void solve(int cnt) {
		// 지도에서 1 찾는다
		int Sr = -1;
		int Sc = -1;
		L:for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==1) {
					Sr = r;
					Sc = c;
					break L;
				}
			}
		}
		if(Sr==-1 && Sc==-1) {
			// 색종이 붙일데가 없어요
			ans = Math.min(ans, cnt);
			return ;
		}
		
		// 1이 발견된 위치에서 붙일수 있는 최대 색종이 크기를 구합니다 (5 이하)
		int size = getPageSize(Sr,Sc);
		//System.out.println(size);
		// 최대 크기부터 1일까지의 색종이를 붙여나가 본다
		for (int i = 1; i <= size; i++) {
			// 그싸이즈의 용지가 있다면
			if(paper[i]>0) {
				for (int r = 0; r < i; r++) {
					for (int c = 0; c < i; c++) {
						map[Sr+r][Sc+c]=0;
					}
				}
				paper[i]--;
				
				solve(cnt+1);
				for (int r = 0; r < i; r++) {
					for (int c = 0; c < i; c++) {
						map[Sr+r][Sc+c]=1;
					}
				}
				paper[i]++;
			}
		}
		
	}
	static int getPageSize(int Sr, int Sc) {
		//System.out.println(Sr+","+Sc);
		int size = 5;
		while(size > 1 ) {
			boolean flag = true;
			
			L:for (int r = Sr; r < Sr+size; r++) {
				for (int c = Sc; c < Sc+size; c++) {
					if(r<0||r>=N||c<0||c>=N||map[r][c]!=1) {
						flag=false;
						break L;
					}
				}
			}
			if(flag) return size;
			size--;
		}
		//System.out.println(size);
		return size;
	}
	
	static void print(int [][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}
}
