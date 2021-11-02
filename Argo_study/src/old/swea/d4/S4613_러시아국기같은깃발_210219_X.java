package old.swea.d4;


import java.util.Scanner;


public class S4613_러시아국기같은깃발_210219_X {
	
	static int T,N,M,Ans;
	static char[][] arr;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];
			Ans=0;
			
			boolean WH = true, BU = true, RE = true;
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);		
				}
			}
			
			for (int i = 0; i < arr.length; i++) {		//이걸로 첫줄 흰색인지 검사
				if(!(arr[0][i] == 'W')) WH = false;
			}
			
			for (int i = 0; i <M-1; i++) {
				for (int j = i+1; j < M; j++) {	//배열을 복사하여 값 비교
					if(diff(arr[i],arr[j])) Ans++;
				}
			}
			
			
			
			
			
	//		print();
			
		}
		
	}
	private static boolean diff(char[] ch1, char[] ch2) {
		for (int i = 0; i < ch2.length; i++) {
			for (int j = 0; j < ch2.length; j++) {
				
				//플래그 검사해서 흰색인지 파란색인지 빨간색인지 확인해서 배열 검사하고 바꿔주던가 말던가 해야함
				
				
				int sum1=0,sum2=0;
				
				
				
				
			}
		}
		
		
//		for(int i=0; i<N-1; i++) {
//			for(int j=i+1; j<N; j++) {
//				if(arr1[i] > arr1[j]) {
//					if(arr2[i] <= arr2[j]) return false;
//				}else if(arr1[i] < arr1[j]) {
//					if(arr2[i] >= arr2[j]) return false;
//				}else {
//					if(arr2[i] != arr2[j]) return false;
//				}
//			}
//		}
		
		
		
		
		
		return false;
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	}
		
	}

}
