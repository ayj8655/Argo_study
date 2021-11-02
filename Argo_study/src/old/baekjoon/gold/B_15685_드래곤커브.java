package old.baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;

public class B_15685_드래곤커브 {

	static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
/*	0: x좌표가 증가하는 방향 (→)
	1: y좌표가 감소하는 방향 (↑)	
	2: x좌표가 감소하는 방향 (←)
	3: y좌표가 증가하는 방향 (↓)	*/
    
	static int N,x,y,d,g,Ans;
	static int arr[][] = new int [101][101];
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			x = sc.nextInt();	//시작점 x
			y = sc.nextInt();	//시작점 y
			d = sc.nextInt();	//시작 방향
			g = sc.nextInt();	//세대
			draw();
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {	//꼭짓점 탐색
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


	private static void draw() {	//드래곤 커브 그리기
		
		LinkedList<Integer> dir = new LinkedList<>();
		dir.add(d);		//처음 방향 지정
		
		for (int i = 1; i <= g; i++) {
			for (int j = dir.size()-1; j >=0; j--) {//역순으로 탐색해서 추가하기 
				dir.add((dir.get(j)+1) % 4);
			}
		}
		
		int size = dir.size();		
		arr[y][x] = 1;	//처음 위치
		for (int i = 0; i <size ; i++) {	//지도에 드래곤커브 그리기
			d = dir.get(i);
			x =x+dx[d];
			y =y+dy[d];
			arr[y][x]=1;			
		}
	}
}
