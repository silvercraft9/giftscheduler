/**
 * 
 */
package giftscheduler;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.exclusion.Exclusion;
import core.exclusion.ExclusionSet;
import core.exclusion.IExclusion;
import core.exclusion.IExclusionSet;
import core.member.IMember;
import core.member.IMemberCollection;
import core.member.SimpleMember;
import core.member.SimpleMemberCollection;
import core.plan.IPlan;
import core.plan.RandomPlan;
import core.utils.ArrayUtils;

/**
 * @author ro6k4
 *
 */
public class RandomPlanTest {
	
	private IMember alice;
	private IMember bob;
	private IMember charlie;
	private IMember daniel;
	private IMember edgar;
	private IMember francine;
	private IMemberCollection collection;
	private IExclusionSet exclusions;
	private IPlan plan;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		alice = new SimpleMember("alice", "alice@domain.com", 0);
		bob = new SimpleMember("bob", "bob@domain.com", 0);
		charlie = new SimpleMember("charlie", "charlie@domain.com", 0);
		daniel = new SimpleMember("daniel", "daniel@domain.com", 0);
		edgar = new SimpleMember("edgar", "edgar@domain.com", 0);
		francine = new SimpleMember("francine", "francine@domain.com", 0);
		
		
		
		collection = new SimpleMemberCollection();
		collection.addMember(alice);
		collection.addMember(bob);
		collection.addMember(charlie);
		collection.addMember(daniel);
		collection.addMember(edgar);
		collection.addMember(francine);
		
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
		
		plan = new RandomPlan("testPlan", this.collection, this.exclusions);
	}

	/**
	 * Test method for {@link core.plan.RandomPlan#getAvailableReceivers(core.member.IMember)}.
	 */
	@Test
	public final void testGetAvailableReceivers() {
		ArrayList<IMember> expectedAliceList = new ArrayList<IMember>();
		expectedAliceList.add(bob);
		expectedAliceList.add(charlie);
		expectedAliceList.add(daniel);
		expectedAliceList.add(francine);
		
		ArrayList<IMember> actualAliceList = this.plan.getAvailableReceivers(alice);
		
		String expectedAlice = ArrayUtils.memberArrayToString(expectedAliceList);
		String actualAlice = ArrayUtils.memberArrayToString(actualAliceList);
		
		assertTrue(expectedAlice.equalsIgnoreCase(actualAlice));
		
		ArrayList<IMember> expectedBobList = new ArrayList<IMember>();
		expectedBobList.add(charlie);
		expectedBobList.add(daniel);
		expectedBobList.add(edgar);
		expectedBobList.add(francine);
		
		ArrayList<IMember> actualBobList = this.plan.getAvailableReceivers(bob);
		
		String expectedBob = ArrayUtils.memberArrayToString(expectedBobList);
		String actualBob = ArrayUtils.memberArrayToString(actualBobList);
		
		assertTrue(expectedBob.equalsIgnoreCase(actualBob));
		
		ArrayList<IMember> expectedDanielList = new ArrayList<IMember>();
		expectedDanielList.add(alice);
		expectedDanielList.add(charlie);
		expectedDanielList.add(francine);
		
		ArrayList<IMember> actualDanielList = this.plan.getAvailableReceivers(daniel);
		
		String expectedDaniel = ArrayUtils.memberArrayToString(expectedDanielList);
		String actualDaniel = ArrayUtils.memberArrayToString(actualDanielList);
		
		assertTrue(expectedDaniel.equalsIgnoreCase(actualDaniel));
	}

	/**
	 * Test method for {@link core.plan.RandomPlan#getAvailableGifters(core.member.IMember)}.
	 */
	@Test
	public final void testGetAvailableGifters() {
		ArrayList<IMember> expectedAliceList = new ArrayList<IMember>();
		expectedAliceList.add(charlie);
		expectedAliceList.add(daniel);
		expectedAliceList.add(edgar);
		expectedAliceList.add(francine);
		
		ArrayList<IMember> actualAliceList = this.plan.getAvailableGifters(alice);
		
		String expectedAlice = ArrayUtils.memberArrayToString(expectedAliceList);
		String actualAlice = ArrayUtils.memberArrayToString(actualAliceList);
		
		assertTrue(expectedAlice.equalsIgnoreCase(actualAlice));
		
		ArrayList<IMember> expectedBobList = new ArrayList<IMember>();
		expectedBobList.add(alice);
		expectedBobList.add(charlie);
		expectedBobList.add(edgar);
		expectedBobList.add(francine);
		
		ArrayList<IMember> actualBobList = this.plan.getAvailableGifters(bob);
		
		String expectedBob = ArrayUtils.memberArrayToString(expectedBobList);
		String actualBob = ArrayUtils.memberArrayToString(actualBobList);
		
		assertTrue(expectedBob.equalsIgnoreCase(actualBob));
		
		ArrayList<IMember> expectedDanielList = new ArrayList<IMember>();
		expectedDanielList.add(alice);
		expectedDanielList.add(bob);
		expectedDanielList.add(charlie);
		expectedDanielList.add(edgar);
		expectedDanielList.add(francine);
		
		ArrayList<IMember> actualDanielList = this.plan.getAvailableGifters(daniel);
		
		String expectedDaniel = ArrayUtils.memberArrayToString(expectedDanielList);
		String actualDaniel = ArrayUtils.memberArrayToString(actualDanielList);
		
		assertTrue(expectedDaniel.equalsIgnoreCase(actualDaniel));
	}

	/**
	 * Test method for {@link core.plan.RandomPlan#generate()}.
	 */
	@Test
	public final void testGenerate() {
		this.plan.generate();
	}

	/**
	 * Test method for {@link core.plan.RandomPlan#validate()}.
	 */
	@Test
	public final void testValidate() {
		//this.plan.generate();
		//boolean valid1 = this.plan.validate();
		//assertTrue(valid1);
		
		//this.plan.generate();
		//boolean valid2 = this.plan.validate();
		//assertTrue(valid2);
	}

}
