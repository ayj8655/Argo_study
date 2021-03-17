package profe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 야구_pro {
	static int N, ans;
	static int[][] hitters;
	static int[] sel;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("야구_17281.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		hitters = new int[N][9];

		for (int i = 0; i < hitters.length; i++) {
			for (int j = 0; j < hitters[i].length; j++) {
				hitters[i][j] = sc.nextInt();
			}
		}
		
		sel = new int[9];
		sel[3] = 0;
		permutation(0, sel, new boolean[9]);
		System.out.println(ans);
	}
	static void solve(int[] sel) {
		int jumsu = 0;
		int start = 0;
		for (int i = 0; i < N; i++) {
			int out = 0;
			//0 홈런 1 2 3 루타
			boolean[] base = new boolean[4];
			int cur = start;
			while (out < 3) {
				
				int s = hitters[i][sel[cur]];
				switch (s) {
				case 0:
					out++;
					break;
				case 1:
					if (base[3]) {jumsu++;}
					base[3] = base[2];
					base[2] = base[1];
					base[1] = true;
					
					break;
				case 2:
					if (base[3]) jumsu++;
					if (base[2]) jumsu++;
					base[3] = base[1];
					base[2] = true;
					base[1] = false;
					break;
				case 3:
					if (base[3]) jumsu++;
					if (base[2]) jumsu++;
					if (base[1]) jumsu++;
					base[3] = true;
					base[2] = false;
					base[1] = false;
					break;
				case 4:
					jumsu++;
					if (base[3]) jumsu++;
					if (base[2]) jumsu++;
					if (base[1]) jumsu++;
					base[3] = false;
					base[2] = false;
					base[1] = false;
					break;
				}

				cur = (cur+1)%9;
			}
			start=cur;
		}
		ans = Math.max(ans, jumsu);
	}
	
	private static void permutation(int k, int[] sel, boolean[] v) throws Exception {
		if (k == sel.length) {
			//solve(sel);
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (k == 3) {//4번거르기
				k++;
				i--;
				continue;
			}
			if (!v[i]) {
				v[i] = true;
				sel[k] = i;
				permutation(k + 1, sel, v);
				v[i] = false;
			}
		}
	}

	private static void print(int[][] hitters) {
		for (int i = 0; i < hitters.length; i++) {
			for (int j = 0; j < hitters[i].length; j++) {
				System.out.print(hitters[i][j] + " ");
			}
			System.out.println();
		}
	}

}
