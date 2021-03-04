package baekjoon.silver;

import java.util.Scanner;
/*


https://www.acmicpc.net/problem/16931
겉넓이 구하기
https://yabmoons.tistory.com/271


입력
첫째 줄에 종이의 크기 N, M이 주어진다. 둘째 줄부터 N개의 줄에는 종이의 각 칸에 놓인 정육면체의 수가 주어진다.

출력
첫째 줄에 도형의 겉넓이를 출력한다.

제한
1 ≤ N, M ≤ 100
1 ≤ 종이의 한 칸에 놓인 정육면체의 수 ≤ 100

예제 입력 1 
1 1
1
예제 출력 1 
6
예제 입력 2 
3 3
1 3 4
2 2 3
1 2 4
예제 출력 2 
60


 */
public class B_16931_겉넓이구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };	    
		
        int N = sc.nextInt();		//종이의 크기
        int M = sc.nextInt();		//종이의 크기
        int count =0;				//결과값 저장
        int arr[][] = new int[N][M];
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
 
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {	//탐색
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx >= 0 && nx< N && ny>=0&& ny<M) {	//탐색 범위 안에 있을 경우
						if(arr[nx][ny] < arr[i][j]) {		//
							count += (arr[i][j] - arr[nx][ny]);
							System.out.println(count);
						}
					}
					else count += arr[i][j];				//범위 밖
				}
			}
		}
        
        count += 2*N*M;			//윗면과 아랫면은 무조건 더하기
        
        
        System.out.println(count);
        

	}

}
