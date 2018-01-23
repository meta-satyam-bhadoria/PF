import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class JoinTwoArrayTest {
	JoinTwoArray merge;
	
	@Before
	public void testThis(){
		merge = new JoinTwoArray();
	}

	@Test
	public void test() {
		int[] a = new int[] {1,2,3,4,5,7,8,9};
		int aLength = a.length;
		int[] b = new int[] {-2,-1,2,4,5,6};
		int bLength = b.length;
		int[] c = new int[aLength + bLength];
		int[] output = new int[] {-2,-1,1,2,2,3,4,4,5,5,6,7,8,9};
		assertArrayEquals(output, 
							merge.join(a, aLength, b, bLength, c));
	}

}
