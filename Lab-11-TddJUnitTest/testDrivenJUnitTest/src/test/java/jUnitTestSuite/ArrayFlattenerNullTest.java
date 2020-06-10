package jUnitTestSuite;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.miu.cs.cs425.testDrivenJUnitTest.ArrayFlattener;

public class ArrayFlattenerNullTest {
	
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
	public void nullTest() {
		
		int[][] inputA = null ;
	       int[] expected = null;
	       
	       int[] actual= this.arrayFlattener.flattenArray(inputA);
	       
	      
	       assertArrayEquals(expected, actual);
	}

}
