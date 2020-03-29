package com.learn.findings.java;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
	   public static void main(String[] args) 
	    { 
		   String input="abcd";
		   System.out.println(getPermutationList(input));
		   
	    }

	private static List<String> getPermutationList(String input) {
		List<String> list = new ArrayList<>();
		for(int i =0;i<input.length()-1;i++) {
			list.addAll(getResult(input.substring(i+1, input.length()-1),input.charAt(i)));
			
		}
		return list;
		
	} 
	private static List<String> getResult(String substring,char appendChar){
		System.out.println(">>" + substring);
		List<String> list = new ArrayList<>();
		char ch = 0;
		for(int j=0;j<substring.length()-1;j++) {
			list.addAll(getResult(substring.substring(j+1, substring.length()-1),ch));
		}
		return list;
		
	}
	} 



