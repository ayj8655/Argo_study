package bakejoon.bronze;

import java.io.*;
import java.util.*;


public class B_3052_나머지 {
	
	static int arr[], result [];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		arr = new int [10];
		result = new int [42];
		for(int i=0; i <10 ; i++) {
			arr[i] = Integer.parseInt(br.readLine()) % 42;
			
		}
		
		for(int i=0; i <10 ; i++) {
			result[arr[i]]++;
		}
		
		
		int cnt=0;
		for(int i=0; i <42 ; i++) {
			if(result[i] !=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
