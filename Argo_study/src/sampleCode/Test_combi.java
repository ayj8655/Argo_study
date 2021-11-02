package sampleCode;
import java.util.Arrays;

/*
 * 순열 조합 연습
 * 
 * 
 * */
public class Test_combi {

	static int N =3;
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		System.out.println("--------순열-----------");
		
		permutation(arr,new int[N],new boolean[N],0);
		
		System.out.println("-------중복순열------------");
		
		permutation(arr,new int[N],0);
		
		System.out.println("--------조합-----------");
		
		combination(arr,new int[2],0,0);
		
		System.out.println("--------중복조합--------------");
		
		combination2(arr,new int[2],0,0);
		
		System.out.println("--------파워셋--------------");
		
		powerset(arr,new boolean[N],0,0);
	}
	//파워셋
	
	private static void powerset(int[] arr, boolean[] sel, int k,int id) {
		if(k==sel.length) {
			
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) System.out.print((arr[i]));
			}
			System.out.println();
			return;
		}
		
		sel[k]=true;
		powerset(arr, sel, k+1, id+1);
		sel[k]=false;
		powerset(arr, sel, k+1, id);
	}
	//조합
	
	private static void combination(int[] arr, int[] sel, int k,int idx) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k]= arr[i];
			combination(arr, sel, k+1, i+1);
		}
	}
	//중복조합
	
		private static void combination2(int[] arr, int[] sel, int k,int idx) {
			if(k==sel.length) {
				System.out.println(Arrays.toString(sel));
				return;
			}
			for (int i = idx; i < arr.length; i++) {
				sel[k]= arr[i];
				combination(arr, sel, k+1, i);
			}
		}
		

	//순열
	private static void permutation(int[] arr, int[] sel, boolean[] v, int k) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int j = 0; j < N; j++) {
			if(!(v[j])) {
				v[j] =true;
				sel[k]=arr[j];
				permutation(arr, sel, v, k+1);
				v[j]=false;
			}
		}
	}
	
	//중복 순열
	private static void permutation(int[] arr, int[] sel, int k) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int j = 0; j < N; j++) {
			sel[k]=arr[j];
			permutation(arr, sel, k+1);
		}
	}
		
}
	
	
