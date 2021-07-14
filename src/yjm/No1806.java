package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, s;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		input();
		int result = solution();
		System.out.println(result);
	}
	
	private static int solution() {
		int right = 0;
		int sum = 0;
		int count = n+1;
		
		for(int left=0; left<n; left++) {
			
			while(right < n && sum < s) {
				sum += arr[right++];
			}
			
			if(sum >= s) {
				count = Math.min(count, (right-left));
			}
			
			sum -= arr[left];
		}
		
		if(count >= n+1 || count < 0) {
			count = 0;
		}
		
		return count;
	}

	private static void input() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
