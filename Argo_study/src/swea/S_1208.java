package swea;

import java.util.Arrays;
import java.util.Scanner;

/*
가로 길이는 항상 100으로 주어진다.

모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.

덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

[입력]

총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다. 그리고 다음 줄에 각 상자의 높이값이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력한다.


2
5 8 3 2 5 6 8 8 3 2 4



 */
public class S_1208 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();		//덤프 횟수
			int[] arr = new int[100];
			for (int j = 0; j < 100; j++) {
				arr[j]= sc.nextInt();
			}
			
			Arrays.sort(arr);
			for (int j = 0; j < N; j++) {		//덤프 횟수만큼 반복하기
				
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			
			System.out.println("#"+(i)+" "+(arr[99]-arr[0]));
		}
		
	}

}
