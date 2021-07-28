package khy;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {
	
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] nums;
	static int[] operators = new int[5];
	static StringBuilder sb = new StringBuilder();
	
	
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		input();
		func(1, nums[1]);
		sb.append(max).append('\n').append(min);
		System.out.println(sb);
	}
	
	public static void func(int k, int value) {
		if(k == n) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for(int cand=1; cand<=4 ; cand++) {
				if(operators[cand]>=1) {
					operators[cand]--;
					func(k+1, calculator(value, cand, nums[k+1]));
					operators[cand]++;
				}
			}
		}
	}
	
	public static int calculator(int num1, int operator, int num2){
		if(operator == 1) {
			return num1+num2;
		}else if(operator == 2) {
			return num1-num2;
		}else if(operator == 3) {
			return num1*num2;
		}else {
			return num1/num2;
		}
	}


	private static void input() throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n+1];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=1; i<=4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
	}
}
