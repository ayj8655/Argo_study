package old.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 
 * 
 * 
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
 * 암호생성기
 * 
 * 큐 사용
 * 
 * 
 * 
 */
public class S1225 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			N = sc.nextInt();
			Queue<Integer> qq = new LinkedList<>();
			
			for (int q = 0; q < 8; q++) {
				int add= sc.nextInt();	//숫자 입력
				qq.add(add);
			}

			int tmp=0;
			int count=1;		//1씩증가시키면서 빼주는 변수
			int mid=0;			//감소한 값
			while (true) {
				
				tmp =qq.poll();		//첫번째 빼기
				mid = tmp-count;	//뺀숫자에서 값 감소
				count++;			
				
				if(count>5) count=1;	//6이되면 다시 1로 변경
				if(mid<=0) mid=0;		//0보다 작거나 같을경우 0으로 변경
				
				qq.add(mid);	
				if(mid==0) break;		//0이면 끝
				
			}
			
			System.out.printf("#%d ",t);
			while (!qq.isEmpty()) {
				System.out.print(qq.poll()+" ");
			}
			System.out.println();
		}
		
	}

}
