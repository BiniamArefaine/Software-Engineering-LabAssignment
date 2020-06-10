package jUnitTestSuite;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.miu.cs.cs425.testDrivenJUnitTest.ArrayFlattener;

public class ArrayFlattenerTest {
	
	private ArrayFlattener arrayFlattener;

	@Before
	public void setUp() throws Exception {
		this.arrayFlattener = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayFlattener = null;
	}

	@Test
	public void test() {
		
       int[][] inputA = {{1, 2}, {3, 4}, {5, 6, 7}};
       int[] expected = {1,2,3,4,5,6,7};
       
       int[] actual= this.arrayFlattener.flattenArray(inputA);
       
       
       //assertEquals(expecteds, actuals);
       assertArrayEquals(expected, actual);
       
		
	}
	
	@Test
	public void nullTest() {
		
		int[][] inputA = null ;
	       int[] expected = null;
	       
	       int[] actual= this.arrayFlattener.flattenArray(inputA);
	       
	      
	       assertArrayEquals(expected, actual);
	}

}
