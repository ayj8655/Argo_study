package old.baekjoon.bronze;

import java.io.*;
import java.util.*;

//배열 2개를 만든다
//돌아가면서 비교한다
//1. 승점
//2. 마지막으로 이긴사람 찾기
//3. 다 비겼으면 끝

public class B_2511_카드놀이 {

	static int arr[], arr2[];
	
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_B_2511.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		int arr[] = new int[10];
		int arr2[] = new int[10];
		
	
		int a_score =0;
		int b_score =0;
		int draw =0;
		boolean win = true; 
		
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < 10; j++) 
			arr[j] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < 10; j++) 
			arr2[j] = Integer.parseInt(st.nextToken());
		
	
		
		for (int i = 0; i < 10; i++) {
			
			if(arr[i] > arr2[i]) { // a가 이김
				a_score+=3;
				win = true;
				
			} else if (arr[i] < arr2[i]) { //b가이김
				b_score+=3;
				win = false;
				
			} else { //비김
				a_score+=1;
				b_score+=1;
				draw++;
			}
			
			
		}
		
		
		if(a_score > b_score) {
			//점수랑 a가이김
			
			System.out.println(a_score + " " + b_score);
			System.out.println("A");
		} else if(a_score < b_score) {
			//점수랑 b가이김
			System.out.println(a_score + " " + b_score);
			System.out.println("B");
			
		} else if(a_score == b_score) {
			if(draw == 10) {
				//점수랑 d가 나오면 끝
				System.out.println(a_score + " " + b_score);
				System.out.println("D");
			} else {
				
				if(win) {
					System.out.println(a_score + " " + b_score);
					System.out.println("A");
					
				}else {
					System.out.println(a_score + " " + b_score);
					System.out.println("B");
				}

			}
			
		}
		
		
		
		
		
		
		
		
		

	}

}
