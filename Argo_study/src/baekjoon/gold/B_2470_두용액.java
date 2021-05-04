package baekjoon.gold;

import java.io.*;
import java.util.*;

public class B_2470_두용액 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_B_2470.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int left = 0;
		int right = n - 1;
		int min = 0;
		int max = 0;
		int diff = Integer.MAX_VALUE;
		

		Arrays.sort(arr); // 정렬

		while (left < right) {

			int tem = Math.abs(arr[left] + arr[right]); // 수의 차이 절대값으로

			if (tem < diff) { // 0에 가까우면 갱신
				diff = tem;
				min = arr[left];
				max = arr[right];
			}
			
			if (arr[left] + arr[right] > 0)
				right--;// 차이가 양수면 오른쪽을 내린다
			else
				left++; // 차이가 음수면 왼쪽을 올린다

		}
		System.out.println(min + " " + max);

	}

}
