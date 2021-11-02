package old.baekjoon.silver;

import java.util.Scanner;

//실버 1

public class B_2564_경비원_O {
	static int N,T,Ans;
	static int H,W,M,dx,dy;
	static int [][] arr;
	
	//방향 판단을 위해서 좌표를 시용한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		M = sc.nextInt();
		arr = new int [M][2];
		
		for (int i = 0; i < M; i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		dx = sc.nextInt();
		dy = sc.nextInt();
		
		
		if(dx==1) {//북
			for(int i=0;i<M;i++) {
				if(arr[i][0]==1) Ans+=Math.abs(arr[i][1]-dy);
				else if(arr[i][0]==2) Ans+=Math.min(arr[i][1]+dy,W-arr[i][1]+W-dy)+H;
				else if(arr[i][0]==3) Ans+=arr[i][1]+dy;
				else if(arr[i][0]==4) Ans+=W-dy+arr[i][1];
			}
		}
		else if(dx==2) {//남
			for(int i=0;i<M;i++) {
				if(arr[i][0]==1) {
					Ans+=Math.min(arr[i][1]+dy,W-arr[i][1]+W-dy)+H;
				}
				else if(arr[i][0]==2) {
					Ans+=Math.abs(arr[i][1]-dy);
				}else if(arr[i][0]==3) {
					Ans+=H-arr[i][1]+dy;
				}else if(arr[i][0]==4) {
					Ans+=W-dy+H-arr[i][1];
				}
			}
		}else if(dx==3) {//서
			for(int i=0;i<M;i++) {
				if(arr[i][0]==1) {
					Ans+=arr[i][1]+dy;
				}
				else if(arr[i][0]==2) {
					Ans+=H-dy+arr[i][1];
				}else if(arr[i][0]==3) {
					Ans+=Math.abs(arr[i][1]-dy);
				}else if(arr[i][0]==4) {
					Ans+=Math.min(arr[i][1]+dy,H-arr[i][1]+H-dy)+W;
				}
			}
		}else if(dx==4) {//동
			for(int i=0;i<M;i++) {
				if(arr[i][0]==1) {
					Ans+=W-arr[i][1]+dy;
				}
				else if(arr[i][0]==2) {
					Ans+=H-dy+W-arr[i][1];
				}else if(arr[i][0]==3) {
					Ans+=Math.min(arr[i][1]+dy,H-arr[i][1]+H-dy)+W;
				}else if(arr[i][0]==4) {
					Ans+=Math.abs(arr[i][1]-dy);
				}
			}
		}
		
		
		System.out.println(Ans);
		
		
	}
}
