package edu.miu.cs.cs425.testDrivenJUnitTest;

import java.util.Arrays;

public class ArrayReversor {
	
	private IArrayFlattenerService  arrayFlattenerService;
	
	
	public ArrayReversor(IArrayFlattenerService arrayFlattenerService){
		
		this.arrayFlattenerService = arrayFlattenerService;
		
	}
	
	
	
	public int[] reverseArray(int[][] a) {
		
        
		
		int[] flattenedA = arrayFlattenerService.flattenedArray(a);
		
		if (a == null) {
			
			return null;
		}
	
		

		int[] newArray = new int[flattenedA.length];
			
      for (int i=flattenedA.length-1,j=0; i>=0; i--,j++) {
			
    	 
    	  newArray[j] = flattenedA[i];
    	 
		}
      
		
      
      
	return newArray;
				
	
	}
	
//	public static void main(String[] args) {
//		
//		for (int y: reverseArray(new int[][] {{1}, {2,3 }, {4,5,6 }})) {
//			
//			System.out.println(y);
//			
//		}
//	}

	
	
}
