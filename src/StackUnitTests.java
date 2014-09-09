import static org.junit.Assert.*;
import org.junit.*;

public class StackUnitTests {

	@Test
	public void testStackSize(){
		Stack<String> stack = new Stack<String>();
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
		assertEquals("Baltimore", stack.push("Baltimore"));
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("Cincinnati", stack.push("Cincinnati"));
		assertEquals(2, stack.size());
		assertEquals("Cincinnati", stack.pop());
		assertEquals(1, stack.size());
		assertEquals("Baltimore", stack.push("Baltimore"));
		assertEquals(2, stack.size());
		assertEquals("Baltimore", stack.pop());
		assertEquals("Baltimore", stack.pop());
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testNullPush(){
		Stack<Boolean> stack = new Stack<Boolean>();
		try {
			stack.push(null);
		} catch (NullPointerException e){
			assertEquals("No Null Elements allowed", e.getMessage());
		}
	}
	
	@Test
	public void testStackMin(){
		Stack<Integer> stack = new Stack<Integer>();
		assertNull(stack.getMinimum());
		stack.push(1);
		assertEquals(new Integer(1), stack.getMinimum());
		stack.push(0);
		assertEquals(new Integer(0), stack.getMinimum());
		stack.push(3);
		stack.push(7);
		assertEquals(new Integer(0), stack.getMinimum());
		stack.push(3);
		stack.push(2);
		stack.push(12);
		stack.push(11);
		assertEquals(new Integer(0), stack.getMinimum());
		stack.pop();
		stack.pop();
		assertEquals(new Integer(0), stack.getMinimum());
		stack.pop();
		assertEquals(new Integer(0), stack.getMinimum());
		stack.pop();
		stack.pop();
		assertEquals(new Integer(0), stack.getMinimum());
		stack.pop();
		assertEquals(new Integer(0), stack.getMinimum());
	}
	
	@Test
	public void testStackMax(){
		Stack<Integer> stack = new Stack<Integer>();
		assertNull(stack.getMaximum());
		stack.push(1);
		assertEquals(new Integer(1), stack.getMaximum());
		stack.push(0);
		assertEquals(new Integer(1), stack.getMaximum());
		stack.push(3);
		stack.push(7);
		assertEquals(new Integer(7), stack.getMaximum());
		stack.push(3);
		stack.push(18);
		stack.push(2);
		stack.push(8);
		stack.push(12);
		stack.push(11);
		assertEquals(new Integer(18), stack.getMaximum());
		stack.pop();
		stack.pop();
		assertEquals(new Integer(18), stack.getMaximum());
		stack.pop();
		assertEquals(new Integer(18), stack.getMaximum());
		stack.pop();
		stack.pop();
		assertEquals(new Integer(7), stack.getMaximum());
		stack.pop();
		assertEquals(new Integer(7), stack.getMaximum());
	}
	
	@Test
	public void testStackPeek(){
		Stack<Integer> stack = new Stack<Integer>();
		assertNull(stack.pop());
		assertNull(stack.peek());
		assertEquals(new Integer(234), stack.push(234));
		assertEquals(new Integer(234), stack.peek());
		assertEquals(1, stack.size());
		assertEquals(new Integer(234), stack.pop());
		assertTrue(stack.isEmpty());
	}
}