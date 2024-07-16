package practice;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        for(int i = 1; i<=9; i++) {
        	if(arr.length == Math.pow(2,i)) {
        		answer = arr;
        		break;
        	} 
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i<arr.length; i++) {
        	list.add(arr[i]);
        }
        

        
        return answer;
    }
}
