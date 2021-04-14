package baekjoon.bronze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 기념품 7트클
 * 
 * */
public class B_12873_기념품 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long count;
		long num;
		LinkedList<Integer> q = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			q.add(n);
		}
		// 첫번째 빼고 나머지는 카운트만큼 빼고 넣기 계속 반복
		if (N == 1) {
			System.out.println("1");

		}

		else {
			q.poll();

			for (long i = 2; i < N; i++) {

				count = (i * i * i);

				num = (int) (count % q.size());

				if (num == 0) {
					q.remove(q.size() - 1);
				} else {

					for (int j = 1; j < (num); j++) {
						q.add(q.poll());
					}

					q.poll();
				}
			}
			System.out.println(q.poll());
		}

	}
}

/*
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * int N = sc.nextInt();
 * 
 * Queue<Integer> q = new LinkedList<>();
 * 
 * for (int n = 1; n <= N; n++) { q.add(n); } q.poll(); //첫번째 빼고 나머지는 카운트만큼 빼고
 * 넣기 계속 반복
 * 
 * for (int i = 2; i < N; i++) {
 * 
 * for (int j = 1; j < (i*i*i); j++) { q.add(q.poll()); } q.poll(); }
 * 
 * System.out.println(q.poll()); }
 * 
 */
/*
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * int N = sc.nextInt(); long count=1; LinkedList<Integer> q = new
 * LinkedList<>();
 * 
 * for (int n = 1; n <= N; n++) { q.add(n); } //첫번째 빼고 나머지는 카운트만큼 빼고 넣기 계속 반복
 * q.remove(0); for (int i = 2; i < N; i++) { count=i*i*i; int num = (int)
 * (count%q.size());
 * 
 * // System.out.println(num); if(num<=0) System.out.println(q.remove(0)); else
 * System.out.println(q.remove(num-1)); //q.remove(1); }
 * 
 * System.out.println(q.poll()); }
 */

/*
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * int N = sc.nextInt(); long count=1; int num=0; int idx=0, tmp=0;
 * LinkedList<Integer> q = new LinkedList<>();
 * 
 * for (int n = 1; n <= N; n++) { q.add(n); } //첫번째 빼고 나머지는 카운트만큼 빼고 넣기 계속 반복
 * if(N == 1) { System.out.println("1");
 * 
 * }
 * 
 * else { q.remove(0);
 * 
 * for (int i = 2; i < N; i++) {
 * 
 * count = (i*i*i); count -= tmp; num = (int) (count%q.size());
 * 
 * if(num == 0) { q.remove(q.size()-1); tmp = 0 ; } else { tmp = q.size()-num;
 * q.remove(num-1); } } System.out.println(q.poll()); }
 * 
 * }
 */
