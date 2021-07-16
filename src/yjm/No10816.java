package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10816 {
	
	static int[] n;
	static int[] m;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		input();
		Arrays.sort(n);
		for(int i=0; i<m.length; i++) {
			int start = lower_bound(n , 0, n.length, m[i]);
			int last = upper_bound(n , 0, n.length, m[i]);
			sb.append(last-start).append(" ");
			count=0;
		}
		System.out.println(sb);
	}
	
private static int upper_bound(int[] n, int left, int right, int m) {
		int mid = 0;
		while(left<right) {
			mid = (left+right)/2;
			if(n[mid]<=m) {
				left = mid+1;
			}else {
				right = mid;
			}
			
		}
		return left;
	}




private static int lower_bound(int[] n, int left, int right, int m) {
		int mid = 0;
		while(left<right) {
			mid = (left+right)/2;
			if(n[mid]>=m) {
				right = mid;
			}else {
				left = mid+1;
			}
			
		}
		return left;
		
	}

//시간초과
//	private static void midChk(int[] n, int left, int right, int m) {
//		int mid;
//		
//		while(left<=right) {
//			mid = (left+right)/2;
//			if(n[mid] == m) {
//				count++;
//				checkCount(mid);
//				break;
//			}else if(n[mid] < m){
//				left = mid+1;
//			}else {
//				right = mid-1;
//			}
//		}
//	}
//
//	private static void checkCount(int mid) {
//		int startR = mid;
//		int startL = mid;
//		while(startL>0) {
//			if(n[--startL]==n[mid]) count++;
//			else break;
//		}
//		while(startR<n.length-1) {
//			if(n[++startR]==n[mid]) count++;
//			else break;
//		}
//				
//	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n값 입력, 설정
		n = new int[Integer.parseInt(br.readLine())];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n.length; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		
		//m값 입력, 설정
		m = new int[Integer.parseInt(br.readLine())];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m.length; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	
}
