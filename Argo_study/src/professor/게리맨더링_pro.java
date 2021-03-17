package professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//파워셋
public class 게리맨더링_pro {
	static int N,ans=Integer.MAX_VALUE;
	static int[] voter;
	static int[][] adj;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("게리맨더링.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		voter=new int[N+1];
		adj=new int[N+1][N+1];
		for (int i = 1; i < voter.length; i++) {
			voter[i]=sc.nextInt();
		}
		
		for (int i = 1; i < N+1; i++) {
			int n =sc.nextInt();
			for (int j = 0; j < n; j++) {
				int k = sc.nextInt();
				adj[i][k]=1;
				adj[k][i]=1;
			}
		}
		//print(adj);
		powerSet(0,new boolean[N+1]);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
	private static void powerSet(int idx, boolean[] sel) {
		if(idx==sel.length) {
			if(check(sel)) {
				int sumA=0,sumB=0;
				for (int i = 1; i < sel.length; i++) {
					if(sel[i]) {
						sumA+=voter[i];
					}else {
						sumB+=voter[i];
					}
				}
				ans = Math.min(ans, Math.abs(sumA-sumB));
			}
			
			return;
		}
		sel[idx]=true;
		powerSet(idx+1,sel);
		sel[idx]=false;
		powerSet(idx+1,sel);
	}
	private static boolean check(boolean[] sel) {
		ArrayList<Integer>areaA = new ArrayList<>();
		ArrayList<Integer>areaB = new ArrayList<>();
		for (int i = 1; i < sel.length; i++) {
			if(sel[i]) {
				areaA.add(i);
			}else {
				areaB.add(i);
			}
		}
		if(areaA.size()==0||areaB.size()==0) return false;
		
		boolean[] v = new boolean[N+1];
		dfs(areaA, areaA.get(0),v);
		dfs(areaB, areaB.get(0),v);
		for (int i = 1; i < v.length; i++) {
			if(v[i]==false) return false;
		}
		return true;
	}
	private static void dfs(ArrayList<Integer> area, Integer idx, boolean[] v) {
		v[idx]=true;
		
		for (int i = 0; i < area.size(); i++) {
			if(!v[area.get(i)]&&adj[idx][area.get(i)]==1) {
				dfs(area,area.get(i),v);
			}
		}
	}
	private static void print(int[][] adj) {
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj[i].length; j++) {
				System.out.print(adj[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
