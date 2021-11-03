package bakejoon.bronze;


import java.io.*;
import java.util.*;

public class B_11720_숫자의합 {

		public static void main(String[] args) throws Exception{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			int result =0;
			for (int i = 0; i < length; i++) {
				int temp = 	str.charAt(i)-48;
				
				result += temp;
			}
			
			
			System.out.println(result);
			
		}
	
}
