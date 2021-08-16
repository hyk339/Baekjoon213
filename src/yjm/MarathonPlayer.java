package yjm;

import java.util.Arrays;
import java.util.HashMap;

public class MarathonPlayer {
	public static void main(String[] args) {
		//n의 약수의 합 구하기
		String[] arr1 = {"leo", "kiki", "eden"};
		String[] arr2 = {"eden","kiki"}; 
		
		MarathonPlayer test = new MarathonPlayer();
		test.solution(arr1, arr2);
	}
    public String solution(String[] participant, String[] completion) {
    	//시간초과
    	String answer = "";
//    	List<String> partList = new ArrayList<>();
//    	partList.addAll(Arrays.asList(participant));
//    	
//    	List<String> compList = new ArrayList<>();
//    	compList.addAll(Arrays.asList(completion));
//    	
//    	for(String comp : compList) {
//    		if(partList.contains(comp)) {
//    			partList.remove(comp);
//    		}
//    	}
//    	answer = partList.get(0);
    	//-----------------------------------------------------
    	//배열을 비교해서 풀이
    	String temp = "";
    	Arrays.sort(participant);
    	Arrays.sort(completion);
    	
    	for(int i=0; i<completion.length; i++) {
    		if(!participant[i].equals(completion[i])) {
    			temp = participant[i];
    		}
    	}
    	
    	if(!temp.equals("")) {
    		answer = temp;
    	}else {
    		answer = participant[participant.length-1]; 
    	}
    	//-------------------------------------------------------
    	//해쉬맵을 이용하여 풀이
    	 HashMap<String,Integer> hash = new HashMap<>();
         for(String part:participant){
             hash.put(part,hash.getOrDefault(part,0)+1);
         }
         for(String comp:completion){
             hash.put(comp,hash.getOrDefault(comp,0)-1);
         }
         for(String ans:hash.keySet()){
             if(hash.get(ans)!=0)
             answer = ans;
         }
    	return answer;
    }
}
