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

public class ArrayReversorNullTest {
	
	
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
	public void testNullable() {
		

		when(arrayFlattenerService.flattenedArray(null)).thenReturn(null);
		
		int[] actual = arrayReversor.reverseArray(null);
		
		int[] expected = null;
		
		assertArrayEquals(actual, expected);
		
		assertThat(actual, is (expected));
		
		verify(arrayFlattenerService).flattenedArray(null);
		
		
		
	}
}
