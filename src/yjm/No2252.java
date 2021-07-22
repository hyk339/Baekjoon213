package yjm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2252 {
	static int n,m;
	static int[] indeg;
	static ArrayList<Integer> result;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		//위상정렬
		input();
		
		sol();
		for(int n:result) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
	
	private static void sol() {
		//1.정점들의 indegree, indeg[1....N] 계산하기
		//	indeg배열을 ++ 해주어서 우선순위를 나눈다
		
		//2.제일 먼저 올 수 있는 정점 큐에 넣기
		//	indeg==0인 경우
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(indeg[i]==0) que.add(i);
		}
		//3.while문 (큐가 빌때 까지)
		while(!que.isEmpty()) {
			//큐에서 원소 꺼내서 정렬시키기
			int n = que.poll();
			result.add(n);
			//하나씩 정렬하면서 그래프에서 삭제
			for(int nextn:graph.get(n)) {
				indeg[nextn]--;
			//새롭게 정렬가능한 점을 큐에 넣기
				if(indeg[nextn]==0) que.add(nextn);
			}
			
			
			
			
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//n = 정점, m = 간선
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		result = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		indeg = new int[n+1];
		
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph.get(n1).add(n2);
			indeg[n2]++;
		}
	}
}
