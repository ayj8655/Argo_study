package baekjoon.silver;

import java.util.*;
import java.io.*;

public class B_1316_그룹단어체커 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	public static void main(String[] args) throws Exception {
 
		int Ans = 0;
		int T = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < T; i++) {
			if (check()) {
				Ans++;
			}
		}
		System.out.print(Ans);
	}
 
	public static boolean check() throws Exception {
		boolean[] v = new boolean[26];
		String str = br.readLine();
		int next = 0;
		int len = str.length();
		for(int i = 0; i < len; i++) {
			int now = str.charAt(i);
			
			if (next != now) {		
				if (!v[now - 'a']) {
					v[now - 'a'] = true;
					next = now;	
				}
				else {
					return false;	
				}
			}
		}    
		return true;
	}
}

