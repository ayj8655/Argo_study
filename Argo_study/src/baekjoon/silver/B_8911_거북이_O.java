package baekjoon.silver;

import java.util.Scanner;
/*
3
FFLF
FFRRFF
FFFBBBRFFFBBB


//최대 최소로 길이 구해서 계산함 
 * */

public class B_8911_거북이_O {
	
	
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	

	static int T,D,X,Y,CNT;
	static int[][] arr;	
	static Point[] po;
	
	static int[] dx = {1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		String str;
		arr = new int[500][500];
		for (int t = 1; t <= T; t++) {
			str = sc.next();
			char[] strarr = str.toCharArray();
			po = new Point[500];
			X=0;
			Y=0;
			CNT=0;
			D=1;
			
			po[CNT] = new Point(0,0);
			CNT++;
			for (int i = 0; i < strarr.length; i++) {
				
				
				
				
				switch (strarr[i]) {
					case 'F': {
						
						if(D==1) Y += 1;
						else if (D==2) Y +=-1;
						else if (D==3) X += -1;			
						else if (D==4) X += 1;
						
						
						if(D==1) po[CNT] = new Point(X,Y);
						else if (D==2) po[CNT] = new Point(X,Y);
						else if (D==3) po[CNT] = new Point(X,Y);
						else if (D==4) po[CNT] = new Point(X,Y);
						CNT++;
						
						break;
					}
					case 'B' : {
						if(D==1) Y += -1;
						else if (D==2) Y += 1;
						else if (D==3) X += 1;			
						else if (D==4) X += -1;
						
						
						if(D==1) po[CNT] = new Point(X,Y);
						else if (D==2) po[CNT] = new Point(X,Y);
						else if (D==3) po[CNT] = new Point(X,Y);
						else if (D==4) po[CNT] = new Point(X,Y);
						CNT++;
						break;
					}
					case 'L': {//방향 제어 1이면 상, 2하, 3좌, 4우
						if(D==1) D=3;
						else if(D==2) D=4;
						else if(D==3) D=2;
						else if(D==4) D=1;
						break;
					}
					case 'R': {
						if(D==1) D=4;
						else if(D==2) D=3;
						else if(D==3) D=1;
						else if(D==4) D=2;
						break;
					}
					default:
						break;
				}
				
			}
			
			boolean flagX = true;
			boolean flagY = true;
			
			for (int i = 0; i < CNT; i++) {
				if (po[i].x != 0 ) flagX=false;
				if (po[i].y != 0 ) flagY=false;				
			}
			
			//넓이 구하기
			if(flagX || flagY) {
				System.out.println(0);
			}
			else {
				int xmax=Integer.MIN_VALUE,ymax=Integer.MIN_VALUE;
				int xmin=Integer.MAX_VALUE,ymin=Integer.MAX_VALUE;
				int xxxx = 0,yyyy = 0;
				for (int i = 0; i < CNT; i++) {
					xmax = Math.max(xmax, po[i].x);
					if(xmin > po[i].x) xmin =po[i].x;
					ymax = Math.max(ymax, po[i].y);
					if(ymin > po[i].y) ymin =po[i].y;
					xxxx = xmax-xmin;
					yyyy = ymax-ymin;
				}
				System.out.println(xxxx*yyyy);
			}
			
		}
		
	}

}
