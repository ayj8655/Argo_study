package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/13335
 * 트럭
 * 큐에 다리를 건너는 트럭을 넣고 뺀다
 * 
4 2 10
7 4 5 6

00 -> 07 -> 70
 * 
 * */
public class B_13335_트럭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//다리를 건너는 트럭의 수
		int W = sc.nextInt();	//다리의 길이
		int L = sc.nextInt();	//다리의 최대 하중
		
		Queue<Integer> bridge_on = new LinkedList();		//다리위에있는 트럭들
		Queue<Integer> truck_weights = new LinkedList();	//각 트럭들의 무게
		int answer = 0;			//걸린 시간
		int curr_weight = 0;		//다리 위에있는 트럭의 무게
		int bridge_out=0;			//다리를 빠져나오는 트럭
		int truck =0;				//대기하던 트럭의 무게
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			truck_weights.add(arr[i]);
		}
		
		for (int i = 0; i < W; i++) {
			bridge_on.add(0);
		}
		
		while(truck_weights.isEmpty() == false) {		//트럭이 남아있는동안
			answer++;
			bridge_out = bridge_on.poll();				//다리위에 큐에서 나가는 트럭 빼기
			curr_weight -= bridge_out;					//다리 무게 
		//	System.out.format("%d %d\n",bridge_out,curr_weight );
			
			if(curr_weight + truck_weights.peek() > L) {		//다리에 올라가있는 트럭과 대기하고있는 트럭의 무게가 다리최대 하중보다 크다면
				bridge_on.add(0);								//0을 추가
			}
			else {				
				truck = truck_weights.poll();
				bridge_on.add(truck);							//트럭 한대 전진
				curr_weight += truck;							//무게 갱신
			}
			
		}
		
		while(curr_weight > 0) {			//아직 다리를 건너고있는 트럭 계산
			answer++;
			bridge_out = bridge_on.poll();
			curr_weight -= bridge_out;
		}
		
		
		System.out.println(answer);
		
	}
}
