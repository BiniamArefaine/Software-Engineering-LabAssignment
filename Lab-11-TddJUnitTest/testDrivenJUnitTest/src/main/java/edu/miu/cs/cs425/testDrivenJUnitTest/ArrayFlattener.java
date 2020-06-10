package edu.miu.cs.cs425.testDrivenJUnitTest;
import java.util.Arrays;
public class ArrayFlattener {

	public ArrayFlattener() {

	}

	public static int[] flattenArray(int[][] a) {

		if (a == null)
			return null;
		
		int[] flatArray = Arrays.stream(a)
		        .flatMapToInt(Arrays::stream)
		        .toArray();
		
		
		return flatArray;
	}



	@Override
	public String toString() {
		return String.format("ArrayFlattener [toString()=%s]", super.toString());
	}

	public static void main(String[] args) {
		
		

	for (int x: flattenArray(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6, 7 }})) {
		
		System.out.println(x);
	};

	}
}
