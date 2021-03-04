package swea.d2;

import java.util.Scanner;

/*

3
3
10 7 6
3
3 5 9
5
1 1 3 1 2

#1 0
#2 10
#3 5

 */
public class S1859_백만장자프로젝트 {
	static int T,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			long sum = 0;
			
			int [] arr = new int[N];
			for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
			int max = arr[N-1];
            
			//뒤에서부터 확인
			
			for(int i=N-2; i>=0; i--) {
				if( arr[i] > max ) max = arr[i];
				else sum += max - arr[i];
			}
			
			System.out.format( "#%d %d\n", t, sum); 
			
			
			
		}

	}

}
