package bakejoon.bronze;

import java.util.*;
import java.io.*;

public class B_2292_벌집 {

	// 6의 배수로 늘어난다.
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_B_2292.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int num = 1; // 최소 루트
		int range = 2; // 범위 (최소값기준)

		if (N == 1) {
			System.out.print("1");
		}

		else {
			while (range <= N) { // 범위가 N보다 커지기 전까지ㅁ
				range += (6 * num); // 다음 범위의 최솟값으로 변경
				num++;
			}
			System.out.print(num);
		}

	}

}
