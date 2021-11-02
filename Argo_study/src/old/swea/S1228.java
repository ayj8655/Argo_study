package old.swea;

import java.util.LinkedList;
import java.util.Scanner;
/*
1228 암호문 리스트로 풀기
 * 
 * x의 위치에 y개의 숫자를 add해주면 된다. 다만 x의 위치는 add함에 따라 증가해야 정상적으로 들어간다.
 * */
public class S1228 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K;
		for (int t = 1; t <= 10; t++) {
			int count=0;
			N = sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();		//리스트 선언
			
			for (int i = 0; i < N; i++) list.add(sc.nextInt());	//원본암호문 추가
			
			K = sc.nextInt();
			
			for (int q = 0; q < K; q++) {
				String s = sc.next();	//i 제거
				int x =sc.nextInt();	//넣을 인덱스
				int y = sc.nextInt();	//넣을 숫자
				
				for (int i = 0; i < y; i++) {
					list.add(x, sc.nextInt());	//삽입하면서 x값을 증가시켜 인덱스도 증가
					x++;
				}
			}
			System.out.printf("#%d ",t);
			while (!(list.isEmpty())) {
				if(count >9) break;
				System.out.print(list.poll() + " ");
				count++;
			}
			System.out.println();
		}
	}
}
