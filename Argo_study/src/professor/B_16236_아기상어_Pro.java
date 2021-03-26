package professor;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_16236_아기상어_Pro {

	static int T, N, M, ans = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int[][] map;
	
	static Shark s;
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("아기상어.txt"));
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c]=input.nextInt();
				if(map[r][c]==9) {
					s = new Shark(r, c);
				}
			}
		}
		solve();
		System.out.println(ans);
	}
	
	private static void solve() {
		boolean[][] v= new boolean[N][N];
		Queue<Shark>Q=new LinkedList<>();
		v[s.r][s.c]=true;
		map[s.r][s.c]=0;
		Q.add(s);
		int time = 0;
		while(!Q.isEmpty()) {
			int size = Q.size();
			ArrayList<Fish> meal = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Shark p = Q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&map[nr][nc]<=s.size) {
						v[nr][nc]=true;
						Q.add(new Shark(nr, nc));
						// 자기보다 작은 물고기가 있으면
						if(map[nr][nc]<s.size&&map[nr][nc]!=0) {
							meal.add(new Fish(nr, nc));
						}
					}
				}
			}
			time++;
			//System.out.println(meal.size());
			// 먹을 물고기가 있으면
			if(meal.size() != 0) {
				Collections.sort(meal);
				Fish f = meal.get(0);
				
				map[s.r][s.c]=0;
				
				s.eatFish(f.r, f.c);
				
				meal.clear();
				
				
				Q.clear();
				Q.add(s);
				ans += time;
				time=0;
				v=new boolean[N][N];
				v[s.r][s.c]=true;
			}
		}
		
	}
	static class Fish implements Comparable<Fish>{
		int r, c;
		Fish(int r, int c){
			this.r=r;
			this.c=c;
		}
		@Override
		public int compareTo(Fish o) {
			if(this.r==o.r) {
				return this.c - o.c;
			}
			return this.r-o.r;
			
		}
	}
	static class Shark{
		int r,c,eat,size=2;
		Shark(){};
		Shark(int r, int c){
			this.r=r;
			this.c=c;
		}
		void eatFish(int r, int c) {
			this.r=r;
			this.c=c;
			eat++;
			if(eat==size) {
				eat=0;
				size++;
			}
		}
	}
}
















