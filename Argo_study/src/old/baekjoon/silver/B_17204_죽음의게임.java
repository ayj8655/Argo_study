package old.baekjoon.silver;

import java.util.Scanner;

/*
17204 죽음의 게임

5 3
1
3
2
1
4
---------
2

6 2
1
3
5
4
0
2
---------
-1



 */
public class B_17204_죽음의게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	//학생
		int K = sc.nextInt();	//타겟
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++)	arr[i]=sc.nextInt();
		
		int val =0,count=0,flag=0;	//타켓위치 확인,결과횟수,무한루프 확인
		boolean visited[] = new boolean[N];	//무한루프 확인용
		
		while(true) {
			
			if(arr[val]==K) {	//학생이 타켓을 만났다면?
				count++;
				break;
			}
			
			if(visited[arr[val]]) {	//학생이 방문한곳을 다시 돌아온경우
				flag = 1;
				break;
			}
			else {
				val=arr[val];	//다음 사람에게 넘어가기
				visited[val] = true;	//지나간 위치 저장
				count++;
			}
			
			
		}
		
		if(flag==1)System.out.println(-1);
		else System.out.println(count);
		
		
		
	}

}
