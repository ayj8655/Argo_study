package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 *
20210222

......
......
......
......
......
......
......
......
.Y....
.YG...
RRYG..
RRYGG.

3

 */
public class B_11559_뿌요뿌요 {

	static int Ans;
	static char[][] arr = new char[12][6];
	static boolean[][] v;
	static LinkedList<Point> list;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static class Point {
	    int y,x;
	    Point(int x, int y) {
	    	this.y = y;
	    	this.x = x;
	    }
	}

	public static void main(String[] args) throws IOException {
		//R 빨강, G 초록, B 파랑, P 보라, Y 노랑
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 for (int i = 0; i < 12; i++) arr[i] = br.readLine().toCharArray();
		 
		 while (true) {
			 boolean flag = false;
			 v = new boolean[12][6];
	 
			 for (int i = 0; i < 12; i++) {
				 for (int j = 0; j < 6; j++) {
					 if (arr[i][j] != '.' && !v[i][j]) {
	                    list = new LinkedList<Point>();
	                    dfs(i, j, arr[i][j]);
	                    
	                    
	                    if (list.size() >= 4) {
	                        flag = true;
	                        for (Point p : list) {
	                            arr[p.x][p.y] = '.';
	                        }
	                    }
	                }
	            }
	        }
	 
	        if (!flag) break;
	        else Ans++;
	 
	        gravity();
		        
		    }
		    
		    System.out.println(Ans);

		
	}
	
	public static void dfs(int y, int x, char ch) {
	    for (int d = 0; d < 4; d++) {
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	 
	        if (0 <= nx && 0 <= ny &&  nx < 6 && ny < 12) {
	            if (arr[ny][nx] == ch && !v[ny][nx]) {
	                list.add(new Point(ny, nx));
	                v[ny][nx] = true;
	                dfs(ny, nx, ch);
	            }
	        }
	    }
	}
	
	public static void gravity() {
	    for (int i = 0; i < 6; i++) {
	        for (int j = 10; j >= 0; j--) {
	            for (int k = 11; k > j; k--) {
	                if (arr[j][i] != '.' && arr[k][i] == '.') {
	                    arr[k][i] = arr[j][i];
	                    arr[j][i] = '.';
	                    break;
	                }
	            }
	        }
	    }
	}
}
