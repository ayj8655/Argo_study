package baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_2580_스도쿠 {
	
	static int N = 9;
	static int arr[][];
	static boolean ch;
	
	static LinkedList<int[]> list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_2580.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		arr = new int[N][N];
		list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					list.add(new int[] {i, j});
			}
		}

		backtracking(0);

	}



	public static void backtracking(int idx) {

		if (idx == list.size()) {	//처음에넣은 빈칸의 개수와 동일하면 끝
			print();
			System.exit(0);	//하나만 출력하면 되서 그냥 종료
		}

		int y = list.get(idx)[0];
		int x = list.get(idx)[1];

		for (int i = 1; i <= 9; i++) {
			if (isPossible(y, x, i)) {	//좌표에 1~9까지 다 넣어본다
				arr[y][x] = i;
				backtracking(idx + 1);
				arr[y][x] = 0;
			}
		}

	}

	public static boolean isPossible(int y, int x, int v) {
		for (int i = 0; i < N; i++) {
			if (arr[y][i] == v)	//가로
				return false;
			if (arr[i][x] == v)	//세로
				return false;
		}
		

		int nx = x / 3 * 3;
		int ny = y / 3 * 3;
		
		for (int i = ny; i < ny + 3; i++) {	//3*3 유효한지 
			for (int j = nx; j < nx + 3; j++) {
				if (arr[i][j] == v)
					return false;
			}
		}
		return true;
	}
	

	public static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
