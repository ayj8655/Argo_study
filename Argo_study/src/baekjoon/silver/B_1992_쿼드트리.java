package baekjoon.silver;

import java.util.Scanner;

/*
쿼드 트리

분할정복 재귀

 * 
 */
public class B_1992_쿼드트리 {

	static int N;
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) { //문자열 입력
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		dfs(0,0,N);
		
	}
	private static void dfs(int x, int y, int n) {
		if(n==1) {	//최소 범위일경우 바로 출력
			System.out.print(arr[x][y]);
			return;
		}
		boolean one =true, zero = true;
		
		for (int i = x; i < x+n; i++) {		//범위내 값이 섞여있는지 확인
			for (int j = y; j < y+n; j++) {
				if(arr[i][j]==0) one=false;
				if(arr[i][j]==1) zero=false;
			}
		}
		
		if(one) {	//1만 존재한다면 1출력
			System.out.print(1);
			return;
		}
		if(zero) {	//0만 존재한다면 0 출력
			System.out.print(0);
			return;
		}
		
		System.out.print("(");	//아닐경우 분할정복 적용 및 괄호 입력
		dfs(x,y,n/2);
		dfs(x,y+n/2,n/2);
		dfs(x+n/2,y,n/2);
		dfs(x+n/2,y+n/2,n/2);
		System.out.print(")");
		
	}

}
