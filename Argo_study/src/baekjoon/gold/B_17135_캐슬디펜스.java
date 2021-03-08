package baekjoon.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B_17135_캐슬디펜스 {

	static int N,M,D;
	static int arr [][];		//게임판
	static int copyarr[][];		//게임판원본
	static boolean v[];			//죽일 타겟 위치
	static int sel [];
	static int com[];
	
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static LinkedList<Point> enemy;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		arr = new int[N+1][M];
		copyarr = new int[N+1][M];
		v = new boolean[M];
		sel = new int[3];
		com = new int[M];
		
		for (int i = 0; i < M; i++) {
			com[i]=i;
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				copyarr[i][j] = arr[i][j];
			}
		}
		
		//궁수 배치 조합으로
		combi(0,0);
		
		//print();
		
	}
	
	private static int dis(Point a, Point e) {
		return Math.abs(a.y-e.y) + Math.abs(a.x-e.x);
	}
	
	private static void print() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = copyarr[i][j];
			}
		}
	}
	
	private static void combi(int k, int idx) {
		if(k==sel.length) {
			
			//뽑힌 조합에서 최대 수 나오게 계산하면 끝
			init();	// 매번 계산할 때 마다 배열 초기화
			enemy = new LinkedList<>();	//적의 위치 저장용 리스트
			
			fight();
			
			return;

		}
		
		for (int i = idx; i < com.length; i++) {
			sel[k] = com[i];
			combi(k+1, i+1);
		}
	
	}

	private static void fight() {
		int cnt=0;
		
		while(true) {
			for (int i = 0; i < arr.length; i++) {
				
			}
			
		}
		
	}
}
