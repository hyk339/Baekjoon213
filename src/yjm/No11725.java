package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11725 {
	static int[] par;
	static ArrayList<ArrayList<Integer>> tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		input();
		search(1);
		for(int i=2; i<par.length; i++) {
			sb.append(par[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void search(int node) {
		//인접 리스트 노드 탐색
		//check[node] = true;
		//루트 노드면 부모에 -1 넣기
		for(int n:tree.get(node)) {
			//현재 노드의 부모와 탐색한 노드가 같으면 컨티뉴,
			if(node==par[n] || par[n]!=0) continue;
			//부모 배열에 노드 넣어주기
			par[n] = node;
			search(n);
		}
	}

	public static void input() throws NumberFormatException, IOException {
		//노드 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		
		//tree 틀 만들기
		tree = new ArrayList<>();
		par = new int[v+1];
		for(int i=0; i<v+1; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		int x=0;
		int y=0;
		//연결 정보 입력(tree는 간선 수 = 노드-1)
		for(int i=0; i<v-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			tree.get(x).add(y);
			tree.get(y).add(x);
		}
	}
}
