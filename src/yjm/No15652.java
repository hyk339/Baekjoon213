package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15652 {
	static int n;
	static int m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		input();
		search(1);
		System.out.println(sb);
	}
	
	private static void search(int depth) {
		if(depth == m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		}else {
			int startNum = selected[depth-1];
			
			for(int i=startNum; i<=n; i++) {
				selected[depth] = i;
				search(depth+1);
			}
		}
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m+1];
		selected[0] = 1;
		br.close();
	}
}
