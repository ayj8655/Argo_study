package swea;

import java.util.Arrays;
import java.util.Scanner;

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&
[S/W 문제해결 응용] 3일차 - 최적 경로
순열문제

10
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20

*/
public class S1247 {
	
	static int officex;
	static int officey;
	static int homex;
	static int homey;
	static int min;
	static int N;
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {	//테케 시작
			N = sc.nextInt(); //고객의수
			min = Integer.MAX_VALUE;
			
			arr = new int[N][2];
			officex = sc.nextInt();
			officey = sc.nextInt();
			homex = sc.nextInt();
			homey = sc.nextInt();
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					arr[j][k] = sc.nextInt();
				}
			}

			permutation(new int[N],0,new boolean[N]);
			
			System.out.println(min);
			
		}
		
		
		
	}
	static int dist(int a, int b,int c, int d) {
		return Math.abs(a-b)+Math.abs(c-d);
		
	}
	
	private static void permutation(int[] sel, int k, boolean[] v) {
		// TODO 자동 생성된 메소드 스텁
		
		if(k==sel.length) {
			int sum = dist(officex,arr[0][0],officey,arr[0][1]);
			//System.out.println(sum);
			
			for (int i = 0; i < sel.length-1; i++) {
				for (int j = 1; j < sel.length; j++) {
					sum+=dist(arr[i][0],arr[j][0],arr[i][1],arr[j][1]);
				}
			}
			sum+=dist(arr[N-1][0],homex,arr[N-1][1],homey);
			//System.out.println(sum);
			if(sum<min) min = sum;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(v[i]==false) {		
				v[i] = true;		
				sel[k] = i;
				permutation(sel, k+1,v);
				v[i] = false;		
			}
		}
		
	}

}
