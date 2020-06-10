package jUnitTestSuite;

import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.miu.cs.cs425.testDrivenJUnitTest.ArrayReversor;
import edu.miu.cs.cs425.testDrivenJUnitTest.IArrayFlattenerService;

public class ArrayReversorTest {
	
	
	private IArrayFlattenerService arrayFlattenerService = mock(IArrayFlattenerService.class);
	private ArrayReversor arrayReversor;
	
 
	@Before
	public void setUp() throws Exception {
		this.arrayReversor = new ArrayReversor(arrayFlattenerService);
		
	}

	@After
	public void tearDown() throws Exception {
		this.arrayReversor = null;
	}

	@Test
	public void test() {
		
		int[][] test = new int[][] {{1}, {2,3 }, {4,5,6}};
		int[] test2 = new int[] {1,2,3,4,5,6};
		
		when(arrayFlattenerService.flattenedArray(test)).thenReturn(test2);
		
		int[] actual = arrayReversor.reverseArray(test);
		
		int[] expected = {6,5,4,3,2,1};
		
		assertArrayEquals(actual, expected);
		
		assertThat(actual, is (expected));
		
		verify(arrayFlattenerService).flattenedArray(test);
		
		
		
	}
	

}
