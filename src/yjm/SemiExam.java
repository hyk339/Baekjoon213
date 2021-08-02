package yjm;

import java.util.ArrayList;
import java.util.Arrays;

public class SemiExam {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		SemiExam se = new SemiExam();
		int[] result = se.solution(numbers);
		System.out.println(Arrays.toString(result));
		
	}
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i]==stu1[i%stu1.length]) count[0]++;
            if(answers[i]==stu2[i%stu2.length]) count[1]++;
            if(answers[i]==stu3[i%stu3.length]) count[2]++;
        }
        
        int maxStu = Math.max(count[0], Math.max(count[1],count[2]));
        
        ArrayList<Integer> arr = new ArrayList<>();
        if(maxStu == count[0]) arr.add(1);
        if(maxStu == count[1]) arr.add(2);
        if(maxStu == count[2]) arr.add(3);
        
        answer = new int[arr.size()];
        int answerCount = 0;
        for(int stu:arr){
            answer[answerCount++] = stu;
        }
        return answer;
    }
}
