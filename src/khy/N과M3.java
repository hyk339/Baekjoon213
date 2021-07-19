package khy;

import java.io.*;
import java.util.*;


public class N과M3 {
	
	static int n;
	static int m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		input();
		pro(1);
		System.out.println(sb);
	}
	
	public static void pro(int k) {
		if(k == m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		}else {
			for(int cand=1; cand<=n; cand++) {
				selected[k] = cand;
				pro(k+1);
				selected[k] = 0;
			}
		}
	}
	
	
	public static void input() throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st =  new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m+1];
	}
	
}
