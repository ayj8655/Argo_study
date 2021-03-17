package profe;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 캐슬디펜스_pro {
	static int ans, N, M, D;

	static class Enemy implements Comparable<Enemy> {
		int r, c;

		Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Enemy o) {
			// TODO Auto-generated method stub
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return o.r - this.r;
		}

		@Override
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + "]";
		}
		
	}

	static ArrayList<Enemy> enemys;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("캐슬디펜스.txt"));
		Scanner sc = new Scanner(System.in);
		enemys = new ArrayList<>();
		ans = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt(); 

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (sc.nextInt() == 1) {
					enemys.add(new Enemy(r, c));
				}
			}
		}
		Collections.sort(enemys);
		//System.out.println(enemys.toString());
		//System.out.println(enemys.size());
		combination(0, 0, new int[3]);
		System.out.printf("%d\n", ans);
		

	}

	private static void combination(int idx, int k, int[] sel) {
		if (k == sel.length) {
			// 다 골랐다
			// System.out.println(Arrays.toString(sel));
			// solve(sel);
			// 거리를 계산해서 죽일놈 고른다음 죽이고 1보 전진을 죽일 적들이 없을때 까지 반복
			ArrayList<Enemy>tmp = new ArrayList<>();
			for (int i = 0; i < enemys.size(); i++) {
				Enemy e = enemys.get(i);
				tmp.add(new Enemy(e.r, e.c));
			}
			
			int cnt=0;
			while (tmp.size() > 0) {
				ArrayList<Enemy> death = new ArrayList<>();
				// 궁순 수만큼 반복
				for (int i = 0; i < sel.length; i++) {
					// 적들과 궁수의 거리계산
					int minD=Integer.MAX_VALUE;
					int minIdx=-1;
					for (int j = 0; j < tmp.size(); j++) {
						Enemy en = tmp.get(j);
						int dist = Math.abs(N - en.r) + Math.abs(sel[i] - en.c);
						// 사거리 안에 있으면
						if (dist <= D) {
							// 최단거리 적 찾기
							if(minD>dist) {
								minD=dist;
								minIdx=j;
							}
							// 최단거리가 같으면
							else if(minD==dist) {
								if(en.c<sel[i]) {
									minD=dist;
									minIdx=j;
								}
							}
						}
					}
					//System.out.println(minIdx);
					if(minIdx!=-1) {
						death.add(tmp.get(minIdx));
					}
				}
				//
				
				// death 에 있는 병사들 제거
				//System.out.println("death : "+death.size());
				for (int i = 0; i < death.size(); i++) {
					for (int j = 0; j < tmp.size(); j++) {
						if(death.get(i)==tmp.get(j)) {
							tmp.remove(j);
							cnt++;
						}
					}
				}
				
				// enemy 1보 전진
				for (int i = 0; i < tmp.size(); i++) {
					tmp.get(i).r++;
					if (tmp.get(i).r == N) {
						tmp.remove(i--);
					}
				}
			}
			ans = Math.max(ans, cnt);
			//System.out.println(tmp.size());
			return;
		}
		if (idx == M) {
			// 더 고를놈이 없다
			return;
		}
		sel[k] = idx;
		combination(idx + 1, k + 1, sel);
		combination(idx + 1, k, sel);
	}

}
