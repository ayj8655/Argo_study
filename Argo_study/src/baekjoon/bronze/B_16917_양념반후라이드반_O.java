package baekjoon.bronze;

/*

 * //https://codinghack.tistory.com/43 백준 16917 양념 반 후라이드 반

브론즈3
 * */
import java.util.Scanner;
public class B_16917_양념반후라이드반_O {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();	//양념
        int B = sc.nextInt();	//후라이드
        int C = sc.nextInt();	//반반
        int X = sc.nextInt();	//양념 갯수
        int Y = sc.nextInt();	//후라이드 갯수

        int price1 = A+B;	//양념 후라이드합한거
        int banban =C+C;	//반반 두개 합한거
        long sum =0;
        
        if (price1 > banban) {	// 반반으로 최대한 많은 개수를 확보 -> X, Y 중에 더 적은것을 반반으로 최대한 산다.
        	
        	
        	if (X > Y) {	//X 가 크다면 Y * (C * 2) 그러면 X-Y 개수의 후라이드(A)를 더 사야한다.
        		sum += Y*banban;
        		sum += Math.min((X - Y) * A, (X - Y) * banban);		//(X-Y)*A 와 (X-Y)*(C*2) 중 작은 값을 더해준다.  
        															//< = 양념을 더 사더라도 반반이 싸다면 최소비용이 적어지기 때문
        	}else {
        		sum += X*banban;
        		sum += Math.min((Y - X) * B, (Y - X) * banban);
        	}
        	
        }
        else if (price1 <= banban){	//단품을 시키는게 더 낫다
        	for (int i =0; i<X; i++) sum += A;
        	for (int i =0; i<Y; i++) sum += B;
        }
        
        System.out.println(sum);
	}
}



/*
 * 
 * 이건 위에 코드에서 불필요한거 뺀거
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();   //양념
        int B = sc.nextInt();   //후라이드
        int C = sc.nextInt();   //반반
        int X = sc.nextInt();   //양념 갯수
        int Y = sc.nextInt();   //후라이드 갯수

        int price1 = A+B;   //양념 후라이드합한거
        int banban =C+C;    //반반 두개 합한거
        long sum =0;

        if (price1 > banban) {  // 반반으로 최대한 많은 개수를 확보 -> X, Y 중에 더 적은것을 반반으로 최대한 산다.

            if (X > Y) {    //X 가 크다면 Y * (C * 2) 그러면 X-Y 개수의 후라이드(A)를 더 사야한다.
                sum += Y*banban;
                sum += Math.min((X - Y) * A, (X - Y) * banban);     //(X-Y)*A 와 (X-Y)*(C*2) 중 작은 값을 더해준다.  
                                                                    //< = 양념을 더 사더라도 반반이 싸다면 최소비용이 적어지기 때문
            }else {
                sum += X*banban;
                sum += Math.min((Y - X) * B, (Y - X) * banban);
            }

        }
        else if (price1 <= banban){ //단품을 시키는게 더 낫다
            for (int i =0; i<X; i++) sum += A;
            for (int i =0; i<Y; i++) sum += B;
        }

        System.out.println(sum);
    }
}
*/
















