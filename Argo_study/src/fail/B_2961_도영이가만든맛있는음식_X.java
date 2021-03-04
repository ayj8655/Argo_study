package fail;

import java.util.Scanner;

/*
도영이가 만든 맛있는 음식

이거 틀렸는데 왜 틀린건지 모르겠음
ㅇ
4
1 7
2 6
3 8
4 9

1

//조합
조합 N개만큼 만들어서 인덱스값 더해서 최소값 찾아보기
 * 
 */
public class B_2961_도영이가만든맛있는음식_X {

	static int N,Ans = Integer.MAX_VALUE;
	static int[] s;	//신
	static int[] ss;//쓴
	static int[] arr;
	static int[] sel;
	static boolean []v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		s = new int[N];
		ss = new int[N];
		sel = new int[N];
		arr = new int[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			s[i] = sc.nextInt();
			ss[i] = sc.nextInt();
			arr[i] = i+1;
		}
		
		powerset(0,0);
		
		System.out.println(Ans);
	}
	
	private static void powerset(int k, int idx) {
		if(k==v.length) {
			int S = 1, SS =0; //S = 신, SS = 쓴
			
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					S *= s[i];
					SS += ss[i];
				}
				
			}
			
			int sum=Math.abs(S - SS);
			
			//System.out.println(sum + " " + Ans);
			Ans = Math.min(Ans, sum);
			
			return;
		}
		
		
		v[k]=true;
		powerset(k+1, idx+1);
		v[k]=false;
		powerset(k+1, idx);
			
	}
	

}
