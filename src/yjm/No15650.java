package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * isUsed 안써도 조건 충족가능(그 전의 수에 +1을 해 줌)
 * 배열은 객체생성할 때 0으로 초기화
 */
public class No15650 {
	static int n;
	static int m;
	static int[] selected;
	//static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		input();
		search(1);
		System.out.println(sb);
	}
	
	private static void search(int depth) {
		//depth가 끝까지 탐색하면 출력
		if(depth == m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			//for(n값)
			int startNum = selected[depth-1];
			//중복체크(순서)
			for(int i=startNum+1; i<=n; i++) {
				//중복체크(같은수)
				//if(isUsed[i]) continue;
				
				selected[depth] = i;
				//isUsed[i] = true;
				search(depth+1);
				//isUsed[i] = false;
			}
		}
	}
	
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m+1];
		//isUsed = new boolean[n+1];
		br.close();
	}
}
