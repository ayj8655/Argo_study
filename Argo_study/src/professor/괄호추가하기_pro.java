package professor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 괄호추가하기_pro {
	static int N,ans=Integer.MIN_VALUE;
	static char[] op;
	static int[] num;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("괄호추가하기.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		op=new char[N/2];
		num=new int[N/2+1];
		String str = sc.next();
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				num[i/2]=Integer.parseInt(str.charAt(i)+"");
			}else {
				op[i/2]=str.charAt(i);
			}
		}
		//System.out.println(Arrays.toString(num));
		//System.out.println(Arrays.toString(op));
		recursive(0,num[0]);
		System.out.println(ans);
	}
	private static void recursive(int idx, int val) {
		if(idx==op.length) {//연산자 수 만큼
			ans = Math.max(ans, val);
			return;
		}
		
		// 1
		int res = calc(op[idx],val,num[idx+1]);
		recursive(idx+1,res);
		// 2
		if(idx+1<op.length) {
			res =  calc(op[idx],val,calc(op[idx+1],num[idx+1],num[idx+2]));
			recursive(idx+2,res);
		}
	}
	private static int calc(char op, int val1, int val2) {
		switch (op) {
		case '+':
			return val1+val2;
		case '-':
			return val1-val2;
		case '*':
			return val1*val2;
		}
		return 0;
	}

}
