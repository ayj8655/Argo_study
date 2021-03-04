package fail;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B_17276_배열돌리기_X{
    static int T,n,d;
    static int[][] map;
    static int[][] tmp;
    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("배열돌리기4.txt"));
        Scanner sc  = new Scanner(System.in);
        T = sc.nextInt();
        for(int t = 0; t < T; t++)
        {
            n = sc.nextInt();
            d= sc.nextInt();
            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            if(d>0) {
                int times = d/45;
                for(int i = 0; i < times; i++) {
                    rotateR();
                }
                print(map);
            }else if(d<0){
                int times = Math.abs(d/45); 
                for(int i = 0; i < times; i++) {
                    rotateL();
                }
                print(map);
            }
        }
        sc.close();

    }



    private static void rotateL() {
        tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j]=map[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                tmp[i][j] = map[i][n/2];//map[n/2][j];
                tmp[n/2][j] = map[i][j];//map[i][n-j-1];
                tmp[i][n-j-1] = map[n/2][n-j-1];//map[i][n/2];
                tmp[i][n/2] = map[i][n-j-1];//map[i][j];
                i++;
            }
        }
        map = tmp;
    }
        
    

private static void rotateR() {
    tmp = new int[n][n];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            tmp[i][j]=map[i][j];
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = i; j < n; j++) {
            tmp[i][j] = map[n/2][j];
            tmp[i][n/2] = map[i][j];
            tmp[i][n-j-1] = map[i][n/2];
            tmp[n/2][n-j-1] = map[i][n-j-1];                
            i++;
        }            
    }
    map = tmp;
    
}



private static void print(int[][] arr) {
    for(int r = 0; r < n; r++) {
        for(int c = 0;c < n; c++){    
            System.out.print(arr[r][c]+ " ");
        }
        System.out.println();        
    }
}
}