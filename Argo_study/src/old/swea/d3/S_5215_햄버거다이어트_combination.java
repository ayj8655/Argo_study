package old.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

/*

1
5 1000
100 200
300 500
250 300
500 1000
400 400 

#1 750
 * 
 * 
 * 
 * */
public class S_5215_햄버거다이어트_combination {

	static public class Food{
		public int jum, cal;
		
		public Food(int jum, int cal) {
			super();
			this.jum = jum;
			this.cal = cal;
		}
		@Override
		public String toString() {
			return "Food [jum=" + jum + ", cal=" + cal + "]";
		}
	}
	
	static int T,N,L;
	
	static int ans=0,max=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			ans=0;
			//재료 정보를 받는다.
			
			Food[] arr = new Food[N];
			
			for (int q = 0; q < N; q++) {
				arr[q] = new Food(sc.nextInt(),sc.nextInt());
			}
			
			
			for (int i = 1; i <= N; i++) {
				combination(arr,new Food[i],0,0);
			}
			
			//combination(arr,new Food[N],0,0);
			
			System.out.println("#"+t+" "+ans);
			
		}
		

	}

	private static void combination(Food[] arr, Food[] food, int idx, int k) {
		if(k== food.length) {
			//System.out.println("222");
			int sum = 0;
			int calsum=0;
			for (int i = 0; i < food.length; i++) {
				sum+= food[i].jum;
				calsum += food[i].cal;
			}
			if(calsum>L) {
				return;
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		
		for (int i = idx; i < N; i++) {
			food[k] = arr[i];
			
			//System.out.print(food.length+" "+ k+ " " + i + "" + idx + "\n");
			combination(arr,food,i+1,k+1);
		}
	}
}
