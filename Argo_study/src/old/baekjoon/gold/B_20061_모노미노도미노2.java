package old.baekjoon.gold;

import java.util.*;
import java.io.*;

//순서대로 진행
public class B_20061_모노미노도미노2 {

	static boolean green[][], blue[][];	
	static int Ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_20061.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
				
				
		int N = Integer.parseInt(br.readLine());
		int t, r, c;

		green = new boolean[10][4];	//녹색
		blue = new boolean[4][10];	//파란색

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			// 이동
			greenMove(green, t, r, c);
			blueMove(blue, t, r, c);
			// 빙고
			greenCheck(green);
			blueCheck(blue);
			// 특별영역
			specialgreenCheck(green);
			specialblueCheck(blue);
		}

		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				if (green[i][j])
					cnt++;
				if (blue[j][i])
					cnt++;
			}
		}
		
		sb.append(Ans).append("\n").append(cnt);
		System.out.println(sb.toString());
		

	}

	private static void specialgreenCheck(boolean[][] green) {	//특별영역

		int remove = 0;

		for (int i = 4; i < 6; i++) {
			boolean check = false;
			for (int j = 0; j < green[i].length; j++) {
				if (green[i][j]) {	//하나라도 영역에 있으면
					check = true;
					break;
				}
			}
			if (check)
				remove++;	//발견한 라인수 만큼
		}

		for (int i = 0; i < remove; i++)
			greenGravity(green, green.length - 1);	//지워버리기

	}

	private static void specialblueCheck(boolean[][] blue) {

		int remove = 0;

		for (int i = 4; i < 6; i++) {
			boolean check = false;
			for (int j = 0; j < blue.length; j++) {
				if (blue[j][i]) {
					check = true;
					break;
				}
			}
			if (check)
				remove++;
		}

		for (int i = 0; i < remove; i++)
			blueGravity(blue, blue[0].length - 1);

	}

	private static void blueCheck(boolean[][] blue) {
		for (int i = 0; i < blue[0].length; i++) {
			boolean check = true;
			for (int j = 0; j < blue.length; j++) {
				if (!blue[j][i]) {
					check = false;
					break;
				}
			}
			if (check) {
				Ans++;
				blueGravity(blue, i);
			}
		}
	}

	private static void blueGravity(boolean[][] blue, int idx) {
		for (int i = idx - 1; i >= 0; i--) {
			for (int j = 0; j < blue.length; j++) {
				blue[j][i + 1] = blue[j][i];
				blue[j][i] = false;
			}
		}
	}

	private static void greenCheck(boolean[][] green) {	//한줄 여부 확인
		for (int i = 0; i < green.length; i++) {
			boolean check = true;
			for (int j = 0; j < green[i].length; j++) {
				if (!green[i][j]) {	//하나라도 참이 있으면 컷
					check = false;
					break;
				}
			}
			if (check) {	//모두 참이라서 포인트 얻고
				Ans++;
				greenGravity(green, i);	//중력 적용 
			}
		}
	}

	private static void greenGravity(boolean[][] green, int idx) {	//한줄 지우기 + 내리기
		for (int i = idx - 1; i >= 0; i--) {
			for (int j = 0; j < green[i].length; j++) {
				green[i + 1][j] = green[i][j];
				green[i][j] = false;
			}
		}
	}

	private static void blueMove(boolean[][] blue, int t, int r, int c) {	//최초 중력
		int ny = c;
		if (t == 1) {
			for (int i = 0; i < blue[r].length; i++) {
				if (blue[r][i]) {
					break;
				} else {
					ny = i;
				}
			}
			blue[r][ny] = true;
		} else if (t == 2) {
			for (int i = 0; i < blue[r].length - 1; i++) {
				if (blue[r][i] || blue[r][i + 1]) {
					break;
				}
				ny = i;
			}
			blue[r][ny] = true;
			blue[r][ny + 1] = true;
		} else if (t == 3) {
			for (int i = 0; i < blue[r].length; i++) {
				if (blue[r][i] || blue[r + 1][i]) {
					break;
				}
				ny = i;
			}
			blue[r][ny] = true;
			blue[r + 1][ny] = true;
		}
	}

	private static void greenMove(boolean[][] green, int t, int r, int c) {	//최초 중력
		int nx = r;
		if (t == 1) {
			for (int i = 0; i < green.length; i++) {
				if (green[i][c]) {
					break;
				} else {
					nx = i;
				}
			}
			green[nx][c] = true;
		} else if (t == 2) {
			for (int i = 0; i < green.length; i++) {
				if (green[i][c] || green[i][c + 1]) {
					break;
				}
				nx = i;
			}
			green[nx][c] = true;
			green[nx][c + 1] = true;
		} else if (t == 3) {
			for (int i = 0; i < green.length - 1; i++) {
				if (green[i][c] || green[i + 1][c]) {
					break;
				}
				nx = i;
			}
			green[nx][c] = true;
			green[nx + 1][c] = true;
		}
	}

}
