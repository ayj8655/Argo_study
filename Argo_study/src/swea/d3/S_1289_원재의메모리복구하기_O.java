package swea.d3;

import java.util.Scanner;

/*
 *원재의 메모리 복구하기 
 *

입력
2
0011
100

출력
#1 1
#2 2 
D3
 * */
public class S_1289_원재의메모리복구하기_O {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            char[] str = sc.next().toCharArray();
            int count =0;
            char tmp='0';
            for (int i =0; i< str.length;i++){
                if(str[i] != tmp) {
                    tmp = str[i];
                    count++;
                }
            }
            System.out.println("#"+test_case  + " " + count);
            
		}
	}

}
