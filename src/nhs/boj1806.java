package nhs;

import java.util.Scanner;

public class boj1806 {

	public static void main(String[] args) {
		System.out.println(hoosss());
	}
	
	private static int hoosss() {
		
		int n = 0;
		int S = 0;
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		S = sc.nextInt();
		
		int[] arr = new int[n];
		int answer = n+1;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int L = 0;	
		int R = 0;
		
		while(true) {
			if(sum >= S) {
				sum -= arr[L++];
				answer = Math.min(answer, R-L+1);
			} else if(sum < S && R < n) {
				sum += arr[R++];
			} else {
				if(answer == n+1) answer = 0;
				break;
			}
			if(L >= n) {
				if(answer == n+1) answer = 0;
				break;
			}
		}
		
		sc.close();
		
		return answer;
	}

}
