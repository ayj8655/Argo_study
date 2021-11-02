package sampleCode;

import java.util.Arrays;

public class Purmu_combi_power {

	
	static int arr[] = {1,2,3};
	static int sel[];
	static boolean v[];
	public static void main(String[] args) {
		
		sel = new int [3];
		v = new boolean[3];
		
		System.out.println("\n순열 시작");
		permu(0);
		
		System.out.println("\n파워셋 시작");
		power(0,0);
		
		System.out.println("\n조합 시작");
		sel = new int [2];
		combi(0,0);
		
	}
	private static void power(int k, int idx) {
		if(k==v.length) {
			for (int i = 0; i < v.length; i++) {
				if(v[i]) System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		
		v[k]=true;
		power(k+1, idx+1);
		v[k]=false;
		power(k+1, idx);
		
		
		
	}
	private static void combi(int k, int idx) {
		
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combi(k+1, i+1);
		}
		
	}
	
	
	private static void permu(int k) {
		if(k == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < sel.length; i++) {
			if(!v[i]) {//v를 방문하지 않았다면
				v[i] = true;
				sel[k] = arr[i];
				permu(k+1);
				v[i] = false;
			}
		}
		
		
	}

}
