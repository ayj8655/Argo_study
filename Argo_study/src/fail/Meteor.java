package fail;

import java.util.Scanner;

public class Meteor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int S = sc.nextInt();
		
		char[][] grid = new char[R][S];
		
        
		for (int i = 0; i < R; i++) {
            String tmp = sc.next();
            for (int j = 0; j < S; j++) {
            	grid[i][j]=tmp.charAt(j);
            }
        }
		
		L: while(true) {
			for (int i = (R-1); 0<=i; i--) {
	            for (int j = (S-1); 0<=j; j--) {
	            	if (grid[i][j] == 'X') {
	            		//System.out.printf("x 발견\n", i,j);
	            		
	            		if(grid[i+1][j] == '#') {
	            			break L;
	            		}else {
	            			grid[i+1][j] = 'X';
	                		grid[i][j] = '.';
	            		}
	            		
	            	}
	            }
	        }
		}
		
		for (int i =0; i< R; i++) {
			for (int j =0; j < S; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}

	}

}
