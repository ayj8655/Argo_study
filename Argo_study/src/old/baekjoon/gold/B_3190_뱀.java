package old.baekjoon.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B_3190_뱀 {
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Point2{
		int x;
		char c;
		public Point2(int x, char c) {
			this.x = x;
			this.c = c;
		}
	}
	
	
	
	static int N,K,L,Ans,d;
	static int nx,ny;
	static int [][] arr;
	static LinkedList<Point> bam;
	static LinkedList<Point2> dis;
	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		bam = new LinkedList<Point>();
		dis = new LinkedList<Point2>();
		bam.add(new Point(1,1));
		arr = new int [N+1][N+1];
		
		boolean flag = true;
		
/*		먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
		만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
		만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.	*/
		
		
		for (int i = 0; i < K; i++) arr[sc.nextInt()][sc.nextInt()] =3;
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			int a = sc.nextInt();
			char b = sc.next().charAt(0);
			dis.add(new Point2(a,b));
		}
		
		
		while (flag) {
			Ans++;
			Point bamm = bam.peekLast();
			nx = bamm.x + dx[d];
			ny = bamm.y + dy[d];
			
			if(nx > N || ny  > N || ny<=0 || nx<=0) { 	//게임판 아웃
				flag=false;
			}
			else {
				for (int i = 0; i < bam.size(); i++) {		//자기 몸 아웃
					int x = bam.get(i).x;
					int y = bam.get(i).y;
					if(x == nx && y == ny) flag=false;
				}	
			}
			
			
			if(!flag) break;
			
			if(arr[nx][ny] == 3) {
				bam.add(new Point(nx,ny));	//일단 머리는 움직임
			}
			else { //사과 못먹으면 꼬리 하나 짜름
				bam.add(new Point(nx,ny));	//일단 머리는 움직임
				bam.poll();
			}
			
			
			
			arr[nx][ny] =2;
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println("-----------------------------");
			
			
			if(!dis.isEmpty()) {
				if(Ans == dis.peek().x) {
					if(dis.peek().c == 'D') {
						d++;
						if(d>3) d=0;
					}else if(dis.peek().c == 'L') {
						d--;
						if(d<0) d=3;
					}
					dis.poll();
					
				}
				
			}
			
			
		}
		
		
		System.out.println(Ans);
		
		
	}
}
