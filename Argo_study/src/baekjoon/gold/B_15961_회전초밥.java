package baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_15961_회전초밥 {

	static int N, D, K, C, maxCnt, eat;
	static int v[], arr[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_B_15961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 접시
		D = Integer.parseInt(st.nextToken());// 초밥의 가짓수
		K = Integer.parseInt(st.nextToken());// 연속접시 수
		C = Integer.parseInt(st.nextToken());// 쿠폰 번호

		arr = new int[N]; // 초밥
		v = new int[D + 1]; // 초밥 종류
		maxCnt = 0;

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			if (v[arr[i]]++ == 0) { // 초밥 [테이블에 있는 종류] +1
				eat++; // 먹음
			}
		}

		if (v[C] == 0)
			eat++; // 쿠폰 초밥 먹은 적 없으면 먹고+1

		maxCnt = Math.max(eat, maxCnt); // 최대치 갱신

		if (v[C] == 0)
			eat--; // 가장 앞의 초밥을 안먹은 거로 치고 추가추가 하며 갈 것이므로 먹은거 -1

		slide();

		br.close();
	}

	private static void slide() {

		int idx = 0; // 인덱스
		for (int i = 1; i < N; i++) {
			if (--v[arr[idx]] == 0)
				eat--;

			if (v[arr[(i + K - 1) % N]]++ == 0) // 원형이라 %연산
				eat++;

			if (v[C] == 0)
				eat++;
			
			maxCnt = Math.max(eat, maxCnt);
			
			if (v[C] == 0)
				eat--;
			idx++;
		}

		System.out.println(maxCnt);
	}
}