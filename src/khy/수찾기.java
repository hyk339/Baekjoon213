package khy;

import java.io.*;
import java.util.*;


public class 수찾기 {
	
	static int n;
	static int m;
	static int[] nlist;
	static int[] mlist;
	static StringBuilder sb = new StringBuilder();
	
	
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		input();
		Arrays.sort(nlist);
		method();
		System.out.println(sb);
	}
	
	public static void method() {
		for(int i=0; i<m; i++) {
			int v = mlist[i];
			check(nlist,0,n-1,v);
		}
	}
	
	public static void check(int[] A, int left, int right, int num) {
		int ch = 0;
		while(left<=right) {
			int mid = (left + right)/2;
			if(A[mid] == num) {
				ch = 1;
				break;
			} else if(A[mid] < num) {
				left = mid+1;
			} else if(A[mid] > num) {
				right = mid-1;
			}
		}
		sb.append(ch).append('\n');
	}
	
	
	
	
	public static void input() throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		n = Integer.parseInt(br.readLine());
		nlist = new int[n];
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<n; i++) {
			nlist[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		mlist = new int[m];
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<m; i++) {
			mlist[i] = Integer.parseInt(st.nextToken());
		}
	}
}
