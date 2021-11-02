package old.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

//진기의 최고급 붕어빵
//20210208


/*
1
100 94 1
4985 6951 10980 5624 11027 4481 501 235 6720 7466 491 8011 9663 1408 2228 1979 3431 9962 8819 3158 147 1154 1338 7636 8642 2841 3656 7390 4510 1989 10629 9942 4993 6158 4381 10422 10697 5982 5626 5446 9766 740 9515 9998 3976 7057 5849 7765 9638 3102 1064 10735 8694 2829 980 866 4054 418 3841 3411 9222 1679 1657 882 1455 10779 3914 3917 6175 10080 4715 4412 251 5788 6107 4331 5739 5130 4428 9269 2662 9322 5134 1446 4837 5211 3899 9462 9648 10565 7635 1540 8696 3984 471 9050 7064 3524 3593 4383
D3
 * */

public class S_1860_진기의최고급붕어빵 {

	static int T,N,M,K;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();	//사람
			M = sc.nextInt();	//만드는데 걸리는 시간
			K = sc.nextInt();	//한번에 만들어지는 양
			
			boolean flag = true;
			int arr[] = new int[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();	//사람들이기다리는 시간
			}
			
			Arrays.sort(arr);		//정렬
			
			for (int i = 0; i < N; i++) {
				int sum = K*(arr[i]/M);		//arr[n] 초에 만든 붕어빵의 개수를 구한다
				
				if(sum < (i+1)) flag =false;	//도착한 손님수보다 작은지 확인
			}
			
			
			System.out.printf("#%d ",t);
			if(!(flag)) System.out.println("Impossible");
			else System.out.println("Possible");
			
			
		}
		
		
		

	}

}
