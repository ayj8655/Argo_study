package fail;

import java.util.Scanner;

/*
오목

//이거 틀렸는데 모르겠다
 * 
 */

public class B_2072_오목_X {
	
	
	static int N, cnt=0;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[35][35];
		boolean flag =true;
		boolean end = false;
		for (int i = 0; i < N; i++) {
				int x = sc.nextInt()+4;
				int y = sc.nextInt()+4;
				
				if(flag) {
					arr[x][y] = 1;
					flag = false;
				}
				else {
					arr[x][y]=2;
					flag = true;
				}
				cnt++;
				
				System.out.println("----------"+cnt+"-----------------");
				for (int i1 = 0; i1 < arr.length; i1++) {
					for (int j = 0; j < arr.length; j++) {
						System.out.print(arr[i1][j]+" ");
					}
					System.out.println();
				}
//				
				if (cnt >10) {
					
					if(flag) {
						int Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x+d][y] ==2) Ans++;
							if(arr[x-d][y] ==2) Ans++;
						}
						if(Ans==5) end=true;
						Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x][y+d] ==2) Ans++;
							if(arr[x][y-d] ==2) Ans++;
						}
						if(Ans==5) end=true;
						Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x+d][y+d] ==2) Ans++;
							if(arr[x-d][y-d] ==2) Ans++;
						}
						if(Ans==5) end=true;
						Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x-d][y+d] ==2) Ans++;
							if(arr[x+d][y-d] ==2) Ans++;
						}
						if(Ans==5) end=true;
					}
					else {
						int Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x+d][y] ==1) Ans++;
							if(arr[x-d][y] ==1) Ans++;
						}
						if(Ans==5) end=true;
						Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x][y+d] ==1) Ans++;
							if(arr[x][y-d] ==1) Ans++;
						}
						if(Ans==5) end=true;
						Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x+d][y+d] ==1) Ans++;
							if(arr[x-d][y-d] ==1) Ans++;
						}
						if(Ans==5) end=true;
						Ans=1;
						for (int d = 1; d <= 4; d++) {
							if(arr[x-d][y+d] ==1) Ans++;
							if(arr[x+d][y-d] ==1) Ans++;
						}
						if(Ans==5) end=true;
					}
					
					if(end) {
						System.out.println(cnt);
						break;
					}
					
				}
				
		}
		if(!end) System.out.println(-1);
		
		
		
		
		
		
	}

}
