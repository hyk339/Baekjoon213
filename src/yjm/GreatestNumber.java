package yjm;

import java.util.Arrays;
import java.util.Comparator;

public class GreatestNumber {
	public static void main(String[] args) {
		int[] numbers = {6,10,2};
		
		GreatestNumber test = new GreatestNumber();
		System.out.println(test.solution(numbers));
	}
    public String solution(int[] numbers) {
    	
        String answer = "";

        String[] snums = new String[numbers.length];
        
        //숫자배열을 문자열배열로
        for(int i=0; i<numbers.length; i++){
            snums[i] = String.valueOf(numbers[i]);
        }
        
        //정렬
        Arrays.sort(snums,new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(String s:snums){
            if(s.equals("0") && answer.equals("0")){
                answer = "0";
                continue;
            }
            answer += s;
        }
        
        return answer;
        
        //실패
//        int[] cnt = new int[10];
//        
//        for(int n:numbers){
//            if(n<10){
//                cnt[n]++;
//            }else{
//                while(n>0){
//                    cnt[n%10]++;
//                    n/=10;
//                }
//            }
//        }
//        
//        for(int i=9; i>=0; i--){
//            while(cnt[i]>0){
//                answer += (i+"");
//                cnt[i]--;
//            }
//        }
        
       
    }
}
