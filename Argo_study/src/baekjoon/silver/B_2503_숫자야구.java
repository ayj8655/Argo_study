package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 숫자 야구
 * 순열
 * 
 */
public class B_2503_숫자야구{
	
	static public class Base{
		int ans;
		int st;
		int ball;
		public Base(int ans, int st, int ball) {
			super();
			this.ans = ans;
			this.st = st;
			this.ball = ball;
		}
		@Override
		public String toString() {
			return "base [ans=" + ans + ", st=" + st + ", ball=" + ball + "]";
		}
	}
	
	static int N, Ans=0;
	static int[] ori = {1,2,3,4,5,6,7,8,9}; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Base[] arr = new Base[N];
		for (int n = 0; n < N; n++) {
			arr[n] = new Base(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		permutation(arr,ori,new int[3],new boolean[9],0);
		System.out.println(Ans);
		
	}
	
	
	private static void permutation(Base[] arr,int [] ori, int[] sel, boolean[] v, int k) {
		if (k==sel.length) {
		//	System.out.println(Arrays.toString(sel));
			for (int i = 0; i < N; i++) {
				
				int nst=0,nball=0;
				int none = arr[i].ans/100;
				int ntwo =arr[i].ans%100/10;
				int nthird = arr[i].ans%100%10;
				
				if(none == sel[0]) ++nst;
				if(ntwo == sel[1]) ++nst;
				if(nthird == sel[2]) ++nst;
				
				if (none != sel[0] && (none == sel[1] || none == sel[2])) ++nball;
	            if (ntwo != sel[1] && (ntwo == sel[0] || ntwo == sel[2])) ++nball;
	            if (nthird != sel[2] && (nthird == sel[0] || nthird == sel[1])) ++nball;
				
	            if (nst == arr[i].st && nball == arr[i].ball) continue;
	            return;
			}
			Ans++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!(v[i])) {
				v[i]=true;
				sel[k]=ori[i];
				permutation(arr, ori, sel, v, k+1);
				v[i]=false;
			}	
		}
	}
}
