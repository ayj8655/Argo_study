package baekjoon.gold;

import java.util.*;
import java.io.*;
//210317 1회 풀이
//https://www.acmicpc.net/problem/1759

public class B_1759_암호만들기 {

	private static int L;
    private static int C;
    private static String[] alphas;
    
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        alphas = br.readLine().split(" ");

        Arrays.sort(alphas);
        dfs(0, "");
		
	}
	private static void dfs(int index, String ret) {
		 if (ret.length() == L) {
	            if (isPossible(ret)) {
	                System.out.println(ret);
	            }
	            return;
	        }
        if (index >= C) return;

        dfs(index + 1, ret + alphas[index]);
        dfs(index + 1, ret);
	}
	
	private static boolean isPossible(String ret) {
        int vowel = 0, consonant = 0;
        for (int i = 0; i < ret.length(); i++) {
            if (find(ret.charAt(i))) vowel++;
            else consonant++;
        }

        return vowel >= 1 && consonant >= 2;
    }

    private static boolean find(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }


}	
