/**
 * 
 */
package giftscheduler;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.member.IMember;
import core.member.IMemberCollection;
import core.member.SimpleMember;
import core.member.SimpleMemberCollection;

/**
 * @author ro6k4
 *
 */
public class SimpleMemberCollectionTest {

	private IMember alice;
	private IMember bob;
	private IMember charlie;
	private IMember daniel;
	private IMember edgar;
	private IMemberCollection collection;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		alice = new SimpleMember("alice", "alice@domain.com", 1);
		bob = new SimpleMember("bob", "bob@domain.com", 2);
		charlie = new SimpleMember("charlie", "charlie@domain.com", 2);
		daniel = new SimpleMember("daniel", "daniel@domain.com", 4);
		edgar = new SimpleMember("edgar", "edgar@domain.com", 3);
		collection = new SimpleMemberCollection();
		
		collection.addMember(alice);
		collection.addMember(bob);
		collection.addMember(charlie);
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#contains(core.member.IMember)}.
	 */
	@Test
	public final void testContains() {
		assertTrue(collection.contains(alice));
		assertTrue(collection.contains(bob));
		assertTrue(collection.contains(charlie));
		assertTrue(!collection.contains(daniel));
		assertTrue(!collection.contains(edgar));
	}
	
	/**
	 * Test method for {@link core.member.SimpleMemberCollection#addMember(core.member.IMember)}.
	 */
	@Test
	public final void testAddMember() {
		assertTrue(collection.contains(charlie));
		assertTrue(!collection.contains(daniel));
		collection.addMember(daniel);
		assertTrue(collection.contains(daniel));
		assertTrue(!collection.contains(edgar));
		collection.addMember(edgar);
		assertTrue(collection.contains(edgar));
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#deleteMember(core.member.IMember)}.
	 */
	@Test
	public final void testDeleteMember() {
		assertTrue(collection.contains(alice));
		assertTrue(collection.contains(bob));
		collection.deleteMember(alice);
		assertTrue(!collection.contains(alice));
		collection.deleteMember(bob);
		assertTrue(!collection.contains(bob));
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#getOtherMembers(core.member.IMember)}.
	 */
	@Test
	public final void testGetOtherMembers() {
		collection.addMember(daniel);
		collection.addMember(edgar);
		ArrayList<IMember> expectedAlice = new ArrayList<IMember>();
		expectedAlice.add(bob);
		expectedAlice.add(charlie);
		expectedAlice.add(daniel);
		expectedAlice.add(edgar);
		ArrayList<IMember> expectedCharlie = new ArrayList<IMember>();
		expectedCharlie.add(alice);
		expectedCharlie.add(bob);
		expectedCharlie.add(daniel);
		expectedCharlie.add(edgar);
		
		ArrayList<IMember> actualAlice = collection.getOtherMembers(alice);
		ArrayList<IMember> actualCharlie = collection.getOtherMembers(charlie);
		int sizeAlice = expectedAlice.size();
		int sizeCharlie = expectedCharlie.size();
		for(int i = 0; i < sizeAlice; i++) {
			assertEquals(expectedAlice.get(i), actualAlice.get(i));
		}
		for(int i = 0; i < sizeCharlie; i++) {
			assertEquals(expectedCharlie.get(i), actualCharlie.get(i));
		}
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#getSortAscByScore()}.
	 */
	@Test
	public final void testGetSortAscByScore() {
		collection.addMember(alice);
		collection.addMember(bob);
		collection.addMember(charlie);
		collection.addMember(daniel);
		collection.addMember(edgar);
		
		ArrayList<IMember> expected = new ArrayList<IMember>();
		expected.add(alice);
		expected.add(bob);
		expected.add(charlie);
		expected.add(edgar);
		expected.add(daniel);
		
		ArrayList<IMember> actual = collection.getSortAscByScore();
		
		int size = expected.size();
		for(int i = 0; i < size; i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#getSortDescByScore()}.
	 */
	@Test
	public final void testGetSortDescByScore() {
		collection.addMember(alice);
		collection.addMember(bob);
		collection.addMember(charlie);
		collection.addMember(daniel);
		collection.addMember(edgar);
		
		ArrayList<IMember> expected = new ArrayList<IMember>();
		expected.add(daniel);
		expected.add(edgar);
		expected.add(charlie);
		expected.add(bob);
		expected.add(alice);
		
		ArrayList<IMember> actual = collection.getSortDescByScore();
		
		int size = expected.size();
		for(int i = 0; i < size; i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#getMinMemberByScore()}.
	 */
	@Test
	public final void testGetMinMemberByScore() {
		collection.addMember(alice);
		collection.addMember(bob);
		collection.addMember(charlie);
		collection.addMember(daniel);
		collection.addMember(edgar);
		
		assertEquals(alice, collection.getMinMemberByScore());
		collection.deleteMember(alice);
		assertEquals(bob, collection.getMinMemberByScore());
	}

	/**
	 * Test method for {@link core.member.SimpleMemberCollection#getMaxMemberByScore()}.
	 */
	@Test
	public final void testGetMaxMemberByScore() {
		collection.addMember(alice);
		collection.addMember(bob);
		collection.addMember(charlie);
		collection.addMember(daniel);
		collection.addMember(edgar);
		
		assertEquals(daniel, collection.getMaxMemberByScore());
		collection.deleteMember(daniel);
		assertEquals(edgar, collection.getMaxMemberByScore());
	}

}
