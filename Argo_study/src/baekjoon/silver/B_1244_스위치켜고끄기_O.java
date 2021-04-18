package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B_1244_스위치켜고끄기_O {

	static int N, S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int arr[] = new int[N + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		S = sc.nextInt();
		int s[][] = new int[S][2];
		for (int i = 0; i < S; i++) {
			s[i][0] = sc.nextInt();
			s[i][1] = sc.nextInt();
		}

		for (int i = 0; i < S; i++) {

			if (s[i][0] == 1) { // 남자일때
				int a = s[i][1];
				for (int j = a; j <= N; j += a) {
					arr[j] = 1 - arr[j];
				}
			} else if (s[i][0] == 2) { // 여자일때
				int a = s[i][1];
				int l = a;
				int r = a;

				while (1 < l && r < N && arr[l - 1] == arr[r + 1]) {
					l--;
					r++;
				}

				for (int j = l; j <= r; j++)
					arr[j] = 1 - arr[j];
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
}
