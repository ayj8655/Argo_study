package baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;

public class B_20056_마법사상어와파이어볼 {//사실 행 열이 원형이었던거
	
	static class Point{
		int m,d,s;
		public Point(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N,M,K;
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
	
	static LinkedList<Point> arr[][];
	static LinkedList<Point> arrcopy[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		arr = new LinkedList[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j]= new LinkedList<Point>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			arr[x][y].add(new Point(m,s,d));	//입력할 때 함정 ㅡㅡ
		}
		
		for (int i = 0; i < K; i++) {
			move();	//1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
			after();//2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다
		}
		
		long Ans=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				while(!arr[i][j].isEmpty()) {
					Point p = arr[i][j].poll();
					Ans+=p.m;	//마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 구해보자.
				}
			}
		}		
		System.out.println(Ans);
	}

	private static void move() {
		arrcopy = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arrcopy[i][j]= new LinkedList<Point>();	//움직인 파이어볼 위치 저장용 임시
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int temp = arr[i][j].size();		//파이어볼 개수
				for (int k = 0; k < temp; k++) {
					
					Point p = arr[i][j].get(k);
					int nx = (i+p.s * dx[p.d]+1000*N)%N;	//모듈러
					int ny = (j+p.s * dy[p.d]+1000*N)%N;
				
					arrcopy[nx][ny].add(new Point(p.m,p.s,p.d));	//움직인 파이어볼 위치 추가
				}
			}
		}
		arr = arrcopy;	//추가된 파이어볼 위치 arr로 이동
	}
	
	private static void after() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = arr[i][j].size();	//파이어볼 개수 확인
				
				if(temp>=2) {		//2개이상
					int m=0,s=0;
					boolean oddflag = true, evenflag = true;	//홀짝 비교용
					//같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
					while(!arr[i][j].isEmpty()) {	//위치에있는 파이어볼 꺼내서 계산
						Point p = arr[i][j].poll();
						m+=p.m;		//질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
						s+=p.s;		//속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
						if(p.d % 2 ==0) oddflag = false;
						else evenflag = false;
					}
					m/=5;
					s/=temp;
					arr[i][j].clear();	//다 꺼냈으니 클리어
					if(m==0) continue;	//0이면 사라지니까 추가 안함
					for (int k = 0; k < 4; k++) {	//합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
						if( oddflag||evenflag) arr[i][j].add(new Point(m,s,0+2*k));
						else  arr[i][j].add(new Point(m,s,1+2*k));
						
					}
				}	
			}
		}
		
	}

}
