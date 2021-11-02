package sampleCode;

import java.util.*;
import java.io.*;

public class 사방탐색 {
    static int x = 3;
    static int y = 3;

    public static void main(String[] args) {
        // (0,0) (0,1) (0,2)
        // (1,0) (1,1) (1,2)
        // (2,0) (2,1) (2,2)
        int[] dx = {-1, 1, 0, 0}; // 가운데 기준 상하좌우 (x좌표)
        int[] dy = {0, 0, -1, 1}; // 가운데 기준 상하좌우 (y좌표)

        int[][] arr = new int[x][y];
        int[][] arr_t = new int[x][y];

        for(int i=0 ; i<x ; i++){
            for(int j=0 ; j<y ; j++){
                arr[i][j] = (int) (Math.random() * x) + 1;
            }
        }

        for(int i=0 ; i<x ; i++){
            for(int j=0 ; j<y ; j++){
                int total = 0;
                for(int k=0 ; k<4 ; k++){
                    int target_x = i + dx[k];
                    int target_y = j + dy[k];
//                    System.out.println(target_x);
//                    System.out.println(target_y);
                    if(target_x < x && target_x >= 0 && target_y < y && target_y >= 0){
                        total += Math.abs(arr[target_x][target_y] - arr[i][j]);
                    }

                }
                arr_t[i][j] = total;
            }
        }


        for(int i=0 ; i<x ; i++){
            for(int j=0 ; j<y ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        for(int i=0 ; i<x ; i++){
            for(int j=0 ; j<y ; j++){
                System.out.print(arr_t[i][j]);
            }
            System.out.println("");
        }
    }
}