package baekjoon.gold;

import java.util.LinkedList;
import java.util.Scanner;

public class B_17135_캐슬디펜스 {

	static int N, M, D, Ans;
	static int arr[][]; // 게임판
	static int copyarr[][]; // 게임판원본
	static int sel[]; // 조합저장용
	static int com[]; // 조합생성용

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static LinkedList<Point> enemy;// 적 위치 저장용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		arr = new int[N + 1][M];
		copyarr = new int[N + 1][M];
		sel = new int[3];
		com = new int[M];

		for (int i = 0; i < M; i++) {
			com[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				copyarr[i][j] = arr[i][j];
			}
		}

		// 궁수 배치 조합으로
		combi(0, 0);

		System.out.println(Ans);
		// print();

	}

	private static void print() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = copyarr[i][j];
			}
		}
	}

	private static void combi(int k, int idx) {
		if (k == sel.length) {

			// 뽑힌 조합에서 최대 수 나오게 계산하면 끝
			init(); // 매번 계산할 때 마다 배열 초기화

			fight();

			return;

		}

		for (int i = idx; i < com.length; i++) {
			sel[k] = com[i];
			combi(k + 1, i + 1);
		}

	}

	private static void fight() {

		int cnt = 0;
		int round = 0;
		enemy = new LinkedList<>(); // 적의 위치 저장용 리스트

		while (round < N) {
			for (int i = 0; i < 3; i++) { // 각 각의 아처들 한번씩 돌리기
				int x = N - round; // 행
				int y = sel[i]; // 선택된 아처 위치
				int min = Integer.MAX_VALUE;
				int minx = -1;
				int miny = -1;
				boolean flag = false; // 적을 찾았는지 확인

				for (int j = N - 1 - round; j >= 0; j--) {// 맨 아래부터 탐색

					for (int k = 0; k < M; k++) {

						if (arr[j][k] == 1) { // 만약 적이 있다면?

							int dis = Math.abs(j - x) + Math.abs(k - y);

							if (dis <= D) { // 적의 거리가 유효 사거리 안이라면?

								if (dis < min) { // 최소거리 갱신
									flag = true;
									min = dis;
									minx = j;
									miny = k;
								} else if (dis == min) { // 거리가 같다면 왼쪽으로
									if (miny > k) {
										minx = j;
										miny = k;

									}
								}
							}
						}
					}
				}

				if (flag)
					enemy.add(new Point(minx, miny)); // 상대가 있다면 추가

			}

			while (!enemy.isEmpty()) { // 죽일 상대 하나씩 꺼내서 제거
				Point p = enemy.poll();
				if (arr[p.x][p.y] == 1) {
					arr[p.x][p.y] = 0;
					cnt++;
				}
			}

			round++;

		}

		Ans = Math.max(cnt, Ans);

	}
}
