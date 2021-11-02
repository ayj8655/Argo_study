package old.baekjoon.bronze;

import java.util.*;
import java.io.*;

public class B_1157_단어공부 {

	static int arr[],cnt[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		
//		System.out.println(str);
		arr = new int [str.length()];
		cnt = new int [26];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
//		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < str.length(); i++) {
			cnt[arr[i]-65]++;
		}
//		System.out.println(Arrays.toString(cnt));
		
		int max = Integer.MIN_VALUE;
		int idx=-1;
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] > max) {
				idx=i;
				max = cnt[i];
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if(i==idx) continue;
			if(cnt[idx] == cnt[i]) {
				System.out.println("?");
				System.exit(0);
			}
		}
		
		
		String result;
		char a = (char) (idx+65);
		result = Character.toString(a).toUpperCase();
		System.out.println(result);
		
		
		
	}

}
