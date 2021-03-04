package jungol;

import java.util.Arrays;
import java.util.Scanner;

/*
정올 냉장고 1828

그리디

4
-15 5
-10 36
10 73
27 44

2

 * 
 */
public class J_1828_냉장고 {
	
	
	static int N;
	static int Ans =1;
	
	public static class Point implements Comparable<Point>{
		int f,l;
		public Point(int f, int l) {
			super();
			this.f = f;
			this.l = l;
		}
		@Override
		public int compareTo(Point o) {
			return this.l - o.l;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Point[] re = new Point[N];
		for (int i = 0; i < re.length; i++) {
			re[i] = new Point(sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(re);
		Point a = re[0];
		int i=1;
		while(i<N) {
			if(re[i].f > a.l) {
				a=re[i];
				Ans++;
			}
			i++;
		}
		
		System.out.println(Ans);
	}
}
