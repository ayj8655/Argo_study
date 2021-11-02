package old.baekjoon.gold;

import java.util.*;
import java.io.*;

public class B_14891_톱니바퀴 {

	static int ch [];
	static int arr[][];
	static int R, Ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_14891.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		arr = new int[5][9];

		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		R = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int number = Integer.parseInt(st.nextToken()); // 회전시킬 바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 방향 (1:시계, -1:반시계)

			ch = new int[5];
			ch[number] = dir;
			right(number + 1, dir * -1);
			left(number - 1, dir * -1);
			rotate();
		}

		int cnt = 1;
		for (int i = 1; i <= 4; i++) {
			if (arr[i][0] == 1) {
				Ans += cnt;
			}
			cnt *= 2;
		}

		System.out.println(Ans);
	}

	private static void rotate() {

		for (int i = 1; i <= 4; i++) {

			if (ch[i] == -1) { // 반시계
				int fir = arr[i][0];
				for (int j = 1; j < 8; j++) {
					arr[i][j - 1] = arr[i][j];
				}
				arr[i][7] = fir;
			}

			else if (ch[i] == 1) { // 시계
				int last = arr[i][7];
				for (int j = 6; j >= 0; j--) {
					arr[i][j + 1] = arr[i][j];
				}
				arr[i][0] = last;
			}

		}

	}

	private static void right(int num, int dir) {// 오른쪽 방향
		if (num == 5) {
			return;
		}

		if (arr[num - 1][2] != arr[num][6]) {
			ch[num] = dir;
			right(num + 1, dir * -1);
		}

	}

	private static void left(int num, int dir) {// 왼쪽 방향
		if (num == 0) {
			return;
		}

		if (arr[num][2] != arr[num + 1][6]) {
			ch[num] = dir;
			left(num - 1, dir * -1);
		}

	}

}