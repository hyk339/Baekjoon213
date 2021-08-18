package yjm;

import java.util.Arrays;

public class H_Index {
	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		
		H_Index test = new H_Index();
		System.out.println(test.solution(citations));
	}
    public int solution(int[] citations) {
    	int answer = 0;
        Arrays.sort(citations);
        
        //h값은 계속 작아지므로 최초의 값이 h의 최대값이다
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i;
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}
