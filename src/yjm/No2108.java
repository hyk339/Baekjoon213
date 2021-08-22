package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No2108 {
	static int[] nums = new int[8001];
	static int sum;
	static int maxNum;
	static int minNum;
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		solve();
		System.out.println(sb);
	}
	
	private static void solve() {
		//산술평균
		double avg = (double)sum/n;
		sb.append(Math.round(avg)).append("\n");
		
		//중앙값 변수
		int mid = (n+1)/2;
		int midCnt = 0;
		int midIdx = 0;
		
		//최빈도 변수
		int maxFreq = 0;
		int freqIdx = 0;
		boolean flag = false;		//두번째 체크용 플래그
		
		for(int i=minNum+4000; i<=maxNum+4000; i++) {
			if(nums[i]!=0) {
				if(midCnt < mid) {
					midCnt += nums[i];
					midIdx = i;
				}
				
				if(maxFreq < nums[i]) {
					maxFreq = nums[i];
					freqIdx = i;
					flag = true;
				}else if(maxFreq == nums[i] && flag) {
					freqIdx = i;
					flag = false;
				}
			}
		}
		
		//중앙값
		sb.append(midIdx-4000).append("\n");
		//최빈값
		sb.append(freqIdx-4000).append("\n");
		//범위
		sb.append(maxNum-minNum);
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int num = 0;
		maxNum = Integer.MIN_VALUE;
		minNum = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			num = Integer.parseInt(br.readLine());
			sum += num;
			nums[num+4000]++;
			maxNum = Math.max(maxNum, num);
			minNum = Math.min(minNum, num);
		}
	}
}
