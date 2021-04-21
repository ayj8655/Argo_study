package baekjoon.gold;

import java.util.*;
import java.io.*;


public class B_17143_낚시왕 {
	
	static class Point{
		int s,d,z;

		public Point(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int dx[] = {0,-1,1,0,0};
	static int dy[] = {0,0,0,1,-1};
	
	static int R, C, M,Ans;
	static int Man;

	static LinkedList<Point> arr[][];
	static LinkedList<Point> arrcopy[][];
	
	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("res/input_B_17143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new LinkedList[R+1][C+1];
		
		for (int i = 0; i < R+1; i++) {
			for (int j = 0; j < C+1; j++) {
				arr[i][j]= new LinkedList<Point>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());//속력
			int d = Integer.parseInt(st.nextToken());//방향
			int z = Integer.parseInt(st.nextToken());//크기

			arr[r][c].add(new Point(s, d, z));
		}
		//낚시왕이 오른쪽으로 한 칸 이동한다.
		//낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
		//상어가 이동한다.
		for (int i = 0; i < C; i++) {
			kingmove();	//낚시왕 이동
			shmove();	//상어 이동
			eat();		//상어 잡아먹기
		}
		
		System.out.println(Ans);
		
	}
	static void eat() {
		for (int i = 0; i < R+1; i++) {
			for (int j = 0; j < C+1; j++) {
				int temp = arr[i][j].size();		//상어 몇마리인지
				
				if(temp>=2) {		//2마리 이상이면
					
					Point p = arr[i][j].poll();
					
					while (!arr[i][j].isEmpty()) {
						
						Point p2 = arr[i][j].poll();
						
						if(p.z < p2.z) p=p2;

					}
					
					arr[i][j].clear();
					arr[i][j].add(p);
					
				}
			}
		}
	}		
	
	static void shmove() {
		
		arrcopy = new LinkedList[R+1][C+1];
		
		for (int i = 0; i < R+1; i++) {
			for (int j = 0; j < C+1; j++) {
				arrcopy[i][j]= new LinkedList<Point>();	//상어들 움직이기 위한 임시
			}
		}
		
		
		for (int i = 0; i < R+1; i++) {
			for (int j = 0; j < C+1; j++) {
				
				if(arr[i][j].size() > 0) {
					
					Point p = arr[i][j].get(0);
					
					int nx =i;
					int ny =j;

					int dir = p.d;
					for (int l = 0; l < p.s; l++) {
						if(dir == 1) {
							nx += dx[dir];
							ny += dy[dir];
							if(nx < 1) {
								dir=2;
								nx += 2;
								ny += 0;
							}
						}else if(dir == 2) {
							nx += dx[dir];
							ny += dy[dir];
							if(nx > R) {
								dir=1;
								nx -= 2;
								ny += 0;
							}
						}else if(dir == 3) {
							nx += dx[dir];
							ny += dy[dir];
							if(ny > C) {
								dir=4;
								nx += 0;
								ny -= 2;
							}
						}else if(dir == 4) {
							nx += dx[dir];
							ny += dy[dir];
							if(ny < 1) {
								dir=3;
								nx += 0;
								ny += 2;
							}
						}
						
						//System.out.println(nx+" " + ny);
						
					}
					//System.out.println("상어한마리 이동");
					arrcopy[nx][ny].add(new Point(p.s,dir,p.z));	//움직인 상어 추가
				}
			}
		}
		
		arr = arrcopy;	//이동한 상어 원본으로 옮기기
		
		
	}
	static void kingmove() {	//낚시왕 이동
		Man++;
		for (int i = 1; i <= R; i++) {
			if(arr[i][Man].size() > 0) {
				Point a = arr[i][Man].get(0);
				Ans += a.z;
				arr[i][Man].remove();
				break;
			}
		}
		
	}


}
