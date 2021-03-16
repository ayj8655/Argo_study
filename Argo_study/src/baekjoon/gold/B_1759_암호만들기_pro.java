package baekjoon.gold;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class B_1759_암호만들기_pro {
	static int L,C;
	static char[]key;
	
	//static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("암호만들기.txt"));
		Scanner sc = new Scanner(System.in);
		L=sc.nextInt();
		C=sc.nextInt();
		key=new char[C];
		Arrays.sort(key);
		for (int i = 0; i < C; i++) {
			key[i]=sc.next().charAt(0);
		}
		
		combination(0,0,new char[L]);
		
		Collections.sort(res,new Comparator<char[]>() {

			@Override
			public int compare(char[] o1, char[] o2) {
				for (int i = 0; i < o1.length; i++) {
					if(o1[i]==o2[i]) {
						continue;
					}
					return o1[i]-o2[i];
				}
				return 0;
			}
		});
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		
	}
	static char[] mo = {'a','e','i','o','u'};
	static int[] ja = {'b','c','d','f','g','h','j','k','l','m',
					   'n','p','q','r','s','t','v','w','x','y','z'};
	static ArrayList<char[]>res=new ArrayList<>();
	private static void combination(int idx, int k, char[] sel) {
		if(k==sel.length) {
			
			int mcnt=0,jcnt=0;
			for (int i = 0; i < sel.length; i++) {
				for (int j = 0; j < mo.length; j++) {
					if(sel[i]==mo[j]) {
						mcnt++;
					}
				}
				for (int j = 0; j < ja.length; j++) {
					if(sel[i]==ja[j]) {
						jcnt++;
					}
				}
			}
			
			char[] tmp = new char[sel.length];
			if(mcnt>=1&&jcnt>=2) {
				for (int i = 0; i < sel.length; i++) {
					tmp[i]=sel[i];
				}
				Arrays.sort(tmp);
				res.add(tmp);
			}
			return;
		}
		if(idx==key.length) {return;}
		
		sel[k]=key[idx];
		combination(idx+1,k+1,sel);
		combination(idx+1,k,sel);
	}

}