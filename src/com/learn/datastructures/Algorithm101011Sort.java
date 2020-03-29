package com.learn.datastructures;

public class Algorithm101011Sort {
	
	public static void main(String[] args) {
	 int[] binArray = {1,0,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0};
	int j=-1;
	 for(int i=0;i<binArray.length;i++) {
		 System.out.println("i="+i + ", j="+j);
		 if(binArray[i]<1 ) {
			 j++;
			 int temp = binArray[j];
			 binArray[j] = binArray[i];
			 binArray[i] =  temp;
			 System.out.println("i="+binArray[i] + ", j="+binArray[j]);
			 
			
		 }
		// System.out.println("i="+i+" j="+j);
		 ////printArray(binArray);
	 }
	 
	}

	private static void printArray(int[] binArray) {
		for(int i=0;i< binArray.length;i++) {
			 System.out.print(binArray[i]);	 
		 }		
		 System.out.println();
	}
}
