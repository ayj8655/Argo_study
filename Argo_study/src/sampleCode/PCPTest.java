package sampleCode;



import java.util.Arrays;

public class PCPTest {

	static int[] arr = {1,3,5};
	static int[] sel = new int[3];
	public static void main(String[] args) {
		// 조합
		//combination(0,0);
		combination_bit(0,0);
		//combination_np();
		// 순열
		//permutation(0,new boolean[arr.length]);
		//permutation_bit(0,0);
		//permutation_np();
		// 부분집합
		//powerSet(0,0,new boolean[arr.length]);
		//powerSet_bit();
		
	}
	
	private static void combination_np() {
		int K = 1;
		//선택배열에 뒤에서부터 뽐을 갯수만큼 1로 채움
		for (int i = 0; i < K; i++) {
			sel[sel.length-1-i]=1;
		}
		//System.out.println(Arrays.toString(sel));
		do {
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]==1) System.out.print(arr[i]+" ");
			}
			System.out.println();
		}while(np(sel));
	}

	private static void permutation_np() {
		// 만들수 있는 가장 작은 순열
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
//		np(arr);
//		System.out.println(Arrays.toString(arr));
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(np(arr));
		
	}

	private static boolean np(int[] arr) {
		int i = arr.length-1;
		while(i>0&&arr[i-1]>=arr[i]) {--i;}
		// 꼭지점이 없으면 종료
		if(i==0) return false;
		
		// i 가 꼭지점
		// 뒤에서 부터 꼭지점까지 검색을해서 i-1 보다 큰값이 나오면 정지
		int j=arr.length-1;
		while(arr[i-1]>=arr[j]) {--j;}
		
		// j 는 i-1 보다 크거나같은 값입니다
		// 그래서 i-1 가 j값을 교환
		swap(arr,i-1,j);
		
		// 꼭지점이 맨마지막값이 아니라면 꼭지점자리를 기준으로 오름차순 정렬
		int k = arr.length-1;
		while(i<k) {
			swap(arr,i++,k--);
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

	private static void powerSet_bit() {
		for (int i = 0; i < (1<<arr.length); i++) {
			//i는 0,1,2,3,4,5,6,7
			// 2진수로 0000, 0001, 0010, 0011, 0100, 0101, 0110, 0111
			
			for (int j = 0; j < arr.length; j++) {
				// j 는 0,1,2
				// 0001, 0010, 0100
				if((i&(1<<j))!=0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
	}


	private static void combination_bit(int k, int bit) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			// 방문을 했다면 continue;
			if((bit&1<<i)!=0) continue;
			// 여기서부터는 방문하지 안을경우
			// 방문체크
			bit = (bit|1<<i);
			// 값담고
			sel[k]=arr[i];
			// 재귀호출시에 인자로 bit를 넘기면 백트레킹을 하지 안아도 됩니다
			// 이유는 인자는 지역변수이기 때문입니다
			combination_bit(k+1, bit);
			// 여기에 bit 값을 원복시켜야 할까요? 네
			//bit=(bit&1<<i);
		}
	}


	private static void permutation_bit(int k, int bit) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			// 방문을 했다면 continue;
			if((bit&1<<i)!=0) continue;
			// 여기서부터는 방문하지 안을경우
			// 방문체크
			//bit = (bit|1<<i);
			// 값담고
			sel[k]=arr[i];
			// 재귀호출시에 인자로 bit를 넘기면 백트레킹을 하지 안아도 됩니다
			// 이유는 인자는 지역변수이기 때문입니다
			permutation_bit(k+1, bit|1<<i);
			// 여기에 bit 값을 원복시켜야 할까요? 네
			//bit=(bit&1<<i);
		}
	}

	private static void permutation(int k, boolean[] v) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(v[i]) continue;
			v[i]=true;
			sel[k]=arr[i];
			permutation(k+1, v);
			v[i]=false;
		}
	}
	
	private static void powerSet(int idx, int k, boolean[] sel) {
		if(idx==arr.length) {
			//System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		sel[idx]=true;
		powerSet(idx+1, k+1, sel);
		sel[idx]=false;
		powerSet(idx+1, k, sel);
	}

	

	private static void combination(int idx, int k) {
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx==arr.length) {
			return;
		}
		sel[k]=arr[idx];
		combination(idx+1, k+1);
		combination(idx+1, k);
	}

}
