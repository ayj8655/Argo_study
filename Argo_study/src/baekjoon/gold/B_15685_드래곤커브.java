package baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;

public class B_15685_드래곤커브 {

	
	static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
	static int N,x,y,d,g,Ans;
	static int arr[][] = new int [101][101];
    
    
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			d = sc.nextInt();
			g = sc.nextInt();
			draw();
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j]==1 && arr[i+1][j]==1 && arr[i][j+1]==1 && arr[i+1][j+1]==1) Ans++;
			}
		}
		
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(Ans);
		
	}


	private static void draw() {
		LinkedList<Integer> dir = new LinkedList<>();
		dir.add(d);	
		for (int i = 1; i <= g; i++) {
			for (int j = dir.size()-1; j >=0; j--) {
				dir.add((dir.get(j)+1) % 4);
			}
		}		
		
		int size = dir.size();
		
		arr[y][x] = 1;
		for (int i = 0; i <size ; i++) {
			d = dir.get(i);
			x =x+dx[d];
			y =y+dy[d];
			arr[y][x]=1;			
		}
		
		
		
	}

}
