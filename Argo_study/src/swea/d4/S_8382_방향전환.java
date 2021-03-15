package swea.d4;

import java.io.*;
import java.util.*;

public class S_8382_방향전환 {
	
	static class Point {	//근데 이거 안만들고 인트형 배열로 다 만들어도 가능함
		int i,j,cnt;
		boolean dir;//가로 false = 0, 세로 true = 1로 할거임
		public Point(int i, int j, int cnt, boolean dir) {
			this.i = i;			this.j = j;
			this.cnt = cnt;		this.dir = dir;
		}
	}
	static int[] dx = {-1,1,0,0};//상하, 좌우
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken())+100;//좌표 체계를 0.0이 시작으로 만들라고
			int y1 = Integer.parseInt(st.nextToken())+100;
			int x2 = Integer.parseInt(st.nextToken())+100;
			int y2 = Integer.parseInt(st.nextToken())+100;
			int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
			
			
			Queue<Point> q = new LinkedList<>();
			boolean v[][][] = new boolean[201][201][2];	//0에 해당되는 값이 있기때문에 1 플러스 해주는거
			//3차원 배열 만듦 왜냐면 가로로 오는 경우도 있고 세로로 오는 경우도 있기 때문에 가로0,세로1
			
			
			
			q.offer(new Point(x1,y1,0,false));//i,j,cnt,dir 들어감
			v[x1][y1][0]=true;	//가로로 0
			
			q.offer(new Point(x1,y1,0,true));//i,j,cnt,dir 들어감
			v[x1][y1][1]=true;	//세로로 1
			
			
			while (!q.isEmpty()) {
				Point p = q.poll();
				if(dist<Math.abs(x2-p.i) + Math.abs(y2-p.j)) continue;//거리를 넘어가면 패스
				
				if(p.i==x2 && p.j == y2) {
			//		sb.append("#"+t+" "+p.cnt);
					sb.append("#").append(t).append(" ").append(p.cnt).append("\n");
					break;
				}
				
				
				if(p.dir==false) {	//가로 폴스
					for (int d = 0; d < 2; d++) {
						int nx = p.i+dx[d];
						int ny = p.j+dy[d];
						
						if(nx<0 || 201<nx ||ny<0 || 201<ny) continue; 
						if(v[nx][ny][1]) continue;
						q.offer(new Point(nx,ny,p.cnt+1,!p.dir));
						v[nx][ny][1]=true;
						
					}
					
				}else if(p.dir == true){	//세로 투르
					for (int d = 2; d < 4; d++) {
						int nx = p.i+dx[d];
						int ny = p.j+dy[d];
						
						if(nx<0 || 201<nx ||ny<0 || 201<ny) continue; 
						if(v[nx][ny][0]) continue;
						q.offer(new Point(nx,ny,p.cnt+1,!p.dir));
						v[nx][ny][0]=true;
						
					}
				}
			}
		}
		
		System.out.print(sb.toString());
		
		br.close();
	}
}



























/*
package swea.d4;

import java.io.*;
import java.util.*;

public class S_8382_방향전환 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_8382.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int x = Math.abs(x1-x2);
			int y = Math.abs(y1-y2);
			System.out.println("#"+t+" ");
			if((x+y)%2==0) System.out.println(Math.max(x, y)*2);
			else System.out.println(Math.max(x, y)*2-1);
			
			
			
		}		
		sc.close();
	}
}
*/