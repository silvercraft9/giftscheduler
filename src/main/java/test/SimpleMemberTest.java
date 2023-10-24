/**
 * 
 */
package test;
import static org.junit.Assert.*;

import org.junit.Test;

import core.member.IMember;
import core.member.SimpleMember;

/**
 * @author ro6k4
 *
 */
public class SimpleMemberTest {
	
	private static IMember alice = new SimpleMember("alice", "alice@domain.com", 1);
	private static IMember bob = new SimpleMember("bob", "bob@domain.com", 2);
	private static IMember bob2 = new SimpleMember("bob", "bob@domain.com", 2);

	/**
	 * Test method for {@link core.member.SimpleMember#getName()}.
	 */
	@Test
	public final void testGetName() {
		assertEquals("alice", alice.getName());
		assertEquals("bob", bob.getName());
		assertTrue(alice.getName() != bob.getName());
		assertTrue(bob.getName() == bob2.getName());
	}

	/**
	 * Test method for {@link core.member.SimpleMember#getAddress()}.
	 */
	@Test
	public final void testGetAddress() {
		assertEquals("alice@domain.com", alice.getAddress());
		assertEquals("bob@domain.com", bob.getAddress());
		assertTrue(alice.getAddress() != bob.getAddress());
		assertTrue(bob.getAddress() == bob2.getAddress());
	}

	/**
	 * Test method for {@link core.member.SimpleMember#getScore()}.
	 */
	@Test
	public final void testGetScore() {
		assertTrue(alice.getScore() == 1);
		assertTrue(bob.getScore() == 2);
		assertTrue(alice.getScore() < bob.getScore());
		assertTrue(bob.getScore() == bob2.getScore());
	}

	/**
	 * Test method for {@link core.member.SimpleMember#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		assertTrue(!alice.equals(bob));
		assertTrue(!alice.equals(bob2));
		assertTrue(bob.equals(bob2));
	}

}
