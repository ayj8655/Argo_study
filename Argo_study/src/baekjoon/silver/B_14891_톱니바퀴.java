package baekjoon.silver;

import java.util.LinkedList;
import java.util.Scanner;
/*
 * 톱니바퀴
 * 
10101111
01111101
11001110
00000010
2
3 -1
1 1

7
 */
public class B_14891_톱니바퀴 {

	static int ans=0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		int[][] arr = new int[4][8];
		
		
		for (int i = 0; i < 4; i++) {
			String str = sc.next();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = (str.charAt(i)-'0');
			}
		}
		
		
		//0은 N극, 1은 S극
		//방향은 1이 시계, -1이 반시계
		
		//1번 -> 2
		//2번 -> 2, 6
		//3번 -> 2, 6
		//4번 -> 6
		
		/* 
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			
			int num = sc.nextInt();
			int d = sc.nextInt();
			boolean flag = true;
			if(d==-1) flag =false;
			if(num==1) {
				if(flag) {	//원본 시계방향
					if(q1.get(2) != q2.get(6)) {//고로 옆은 반시계방향
						q2.addLast(q2.poll());
					}
					
				}
				else {	//원본 반시계방향
					if(q1.get(2) != q2.get(6)) {//얘는 시계방향으로
						q2.add(q2.pollLast());
					}
//					
				}
			}
			else if (num==2) {
				if(flag) {	//원본 시계방향
					if(q2.get(6) != q1.get(2)) {//고로 옆은 반시계방향
						q1.addLast(q1.poll());
					}
					if(q2.get(2) != q3.get(6)) {//고로 옆은 반시계방향
						q3.addLast(q3.poll());
					}
				}
				else {	//원본 반시계방향
					if(q1.get(2) != q2.get(6)) {//얘는 시계방향으로
						q2.add(q2.pollLast());
					}
//					
				}
				
			}
			else if (num ==3) {
				if(flag) {
					
				}
				else {
//					
				}
				
			}
			else if (num ==4) {
				
			}
			
			
		}
		
		
		if(q1.get(0)==1) ans+=1;
		if(q2.get(0)==1) ans+=2;
		if(q3.get(0)==1) ans+=4;
		if(q4.get(0)==1) ans+=8;
		System.out.println(ans);
		
		*/
		
	}

}
