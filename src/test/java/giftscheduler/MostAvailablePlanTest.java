/**
 * 
 */
package giftscheduler;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.exclusion.*;
import core.member.*;
import core.plan.*;
import core.utils.ArrayUtils;

/**
 * @author admin
 *
 */
public class MostAvailablePlanTest {
	
	private IMember alice;
	private IMember bob;
	private IMember charlie;
	private IMember daniel;
	private IMember edgar;
	private IMemberCollection collection;
	private IExclusionSet exclusions;
	private IPlan plan;
	

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
		collection.addMember(daniel);
		collection.addMember(edgar);
		
		IExclusion excl1 = new Exclusion(bob, alice);
		IExclusion excl2 = new Exclusion(daniel, bob);
		IExclusion excl3 = new Exclusion(alice, edgar);
		IExclusion excl4 = new Exclusion(daniel, edgar);
		ArrayList<IExclusion> exclList = new ArrayList<IExclusion>();
		exclList.add(excl1);
		exclList.add(excl2);
		exclList.add(excl3);
		exclList.add(excl4);
		exclusions = new ExclusionSet(exclList);
		
		plan = new MostAvailablePlan("testPlan", this.collection, this.exclusions);
	}

	/**
	 * Test method for {@link core.plan.MostAvailablePlan#getAvailableReceivers(core.member.IMember)}.
	 */
	@Test
	public final void testGetAvailableReceivers() {
		ArrayList<IMember> expectedAliceList = new ArrayList<IMember>();
		expectedAliceList.add(bob);
		expectedAliceList.add(charlie);
		expectedAliceList.add(daniel);
		
		ArrayList<IMember> actualAliceList = this.plan.getAvailableReceivers(alice);
		
		String expectedAlice = ArrayUtils.memberArrayToString(expectedAliceList);
		String actualAlice = ArrayUtils.memberArrayToString(actualAliceList);
		
		assertTrue(expectedAlice.equalsIgnoreCase(actualAlice));
		
		ArrayList<IMember> expectedBobList = new ArrayList<IMember>();
		expectedBobList.add(charlie);
		expectedBobList.add(daniel);
		expectedBobList.add(edgar);
		
		ArrayList<IMember> actualBobList = this.plan.getAvailableReceivers(bob);
		
		String expectedBob = ArrayUtils.memberArrayToString(expectedBobList);
		String actualBob = ArrayUtils.memberArrayToString(actualBobList);
		
		assertTrue(expectedBob.equalsIgnoreCase(actualBob));
		
		ArrayList<IMember> expectedDanielList = new ArrayList<IMember>();
		expectedDanielList.add(alice);
		expectedDanielList.add(charlie);
		
		ArrayList<IMember> actualDanielList = this.plan.getAvailableReceivers(daniel);
		
		String expectedDaniel = ArrayUtils.memberArrayToString(expectedDanielList);
		String actualDaniel = ArrayUtils.memberArrayToString(actualDanielList);
		
		assertTrue(expectedDaniel.equalsIgnoreCase(actualDaniel));
	}

	/**
	 * Test method for {@link core.plan.MostAvailablePlan#getAvailableGifters(core.member.IMember)}.
	 */
	@Test
	public final void testGetAvailableGifters() {
		fail("Not yet implemented");
				
	}

	/**
	 * Test method for {@link core.plan.MostAvailablePlan#generate()}.
	 */
	@Test
	public final void testGenerate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link core.plan.MostAvailablePlan#validate()}.
	 */
	@Test
	public final void testValidate() {
		fail("Not yet implemented");
	}

}
