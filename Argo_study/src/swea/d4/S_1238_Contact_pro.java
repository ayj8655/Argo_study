package swea.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S_1238_Contact_pro {
	static int[][] adj;
	static int N, start;

	static class Node {
		int num, depth;

		Node(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
	static int tc=1;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("contact.txt"));
		Scanner sc = new Scanner(System.in);
		for (tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			start = sc.nextInt();
			adj = new int[N + 1][N + 1];
			for (int i = 0; i < N / 2; i++) {
				adj[sc.nextInt()][sc.nextInt()] = 1;
			}
			// print(adj);
			bfs();
		}
	}

	private static void bfs() {
		int[] v = new int[N + 1];
		Queue<Node> Q = new LinkedList<>();
		Q.add(new Node(start, 1));
		v[start] = 1;
		int max = 0;
		while (!Q.isEmpty()) {
			Node p = Q.poll();
			for (int i = 1; i < adj.length; i++) {
				if (v[i] == 0 && adj[p.num][i] == 1) {
					v[i] = p.depth + 1;
					Q.add(new Node(i, p.depth + 1));
				}
			}
			max = Math.max(max, p.depth);
		}
		// System.out.println(Arrays.toString(v));
		int idx = 0;
		for (int i = 0; i < v.length; i++) {
			if (max <= v[i]) {
				idx = i;
			}
		}
		System.out.printf("#%d %d\n",tc,idx);
	}

	private static void print(int[][] adj) {
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj[i].length; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}

	}

}