package baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1244
 * https://slllju.tistory.com/m/103?category=871863
 * 스위치 켜고 끄기
 * 
 * 스위치 번호 : 1 2 3 4 5 6 7 8
 * 스위치 상태 : 0 1 0 1 0 0 0 1
 * 남학생 3 -> 3,6, 변경
 * 
 * 스위치 번호 : 1 2 3 4 5 6 7 8
 * 스위치 상태 : 0 1 1 1 0 1 0 1
 * 여학생 3 -> 중심으로 대칭확인
 * 
 * 스위치 번호 : 1 2 3 4 5 6 7 8
 * 스위치 상태 : 1 0 0 0 1 1 0 1
 * 
예제 입력 

8
0 1 0 1 0 0 0 1
2
1 3
2 3

예제 출력
1 0 0 0 1 1 0 1

 * 
 * 
 * */
public class B_1244_스위치켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//스위치의 갯수
		int [] arr = new int[N+1];
		
		
		for (int i = 1; i <=N; i++) {	
			arr[i] = sc.nextInt();	//스위치의 상태 입력
		}
		
//		System.out.println("시작전");
//		for (int i1 = 1; i1 <= N; i1++) {
//	        System.out.print(arr[i1] + " ");
//	        if (i1 % 20 == 0) {
//	            System.out.println();
//	        }
//	    }
		
		
		int S = sc.nextInt();	//학생 수
		
		for (int i = 1; i <= S; i++) {
			int sex = sc.nextInt();		//성별
			int num = sc.nextInt();		//숫자
			
			if(sex ==1) {	//남자일때
				for (int j = num; j <= N; j+=num) {
					arr[j] = 1-arr[j];
				}
				
//				System.out.println("남좌");
//				for (int i1 = 1; i1 <= N; i1++) {
//			        System.out.print(arr[i1] + " ");
//			        if (i1 % 20 == 0) {
//			            System.out.println();
//			        }
//			    }
			}
			else if (sex ==2) {		//여자일때
				int l=num;
				int r=num;
				
				while(1<l&&r<N&&arr[l-1]==arr[r+1]) {
					l--;
					r++;
				}
				
				for (int j = l; j <=r; j++) arr[j] = 1-arr[j];
				
//				System.out.println("여좌");
//				for (int i1 = 1; i1 <= N; i1++) {
//			        System.out.print(arr[i1] + " ");
//			        if (i1 % 20 == 0) {
//			            System.out.println();
//			        }
//			    }
					
			}
			
		}
		
		
//		System.out.println("끝");
	    for (int i = 1; i <= N; i++) {
	        System.out.print(arr[i] + " ");
	        if (i % 20 == 0) {
	            System.out.println();
	        }
	    }

		
	}

}
