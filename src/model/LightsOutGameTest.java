package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import presenter.Contract;
import presenter.Contract.Presenter;

public class LightsOutGameTest {

	@Before
	public void setUp() {
		public Contract.Presenter presenter;
		presenter = null;
	}
	
	@Test
	public void testLightsOutGame() {
		
		LightsOutGame game = new LightsOutGame(5);
		assertTrue(game.getBoard().length == 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLightsOutGameError() {
		LightsOutGame game = new LightsOutGame(0);	
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLightsOutGameLimitError() {
		LightsOutGame game = new LightsOutGame(3);		
	}
	
	@Test
	public void testGenerateLights() {
		LightsOutGame game = new LightsOutGame(5);
		game.generateLights(1, 3);
		assertTrue(game.giveMeLight(1, 3));
	}
	
	@Test 
	public void testGenerateLightsOppositeCase() {
		LightsOutGame game = new LightsOutGame(5);
		game.generateLights(1, 3);
		assertTrue(game.giveMeLight(0, 3));		
	}

	

	@Test
	public void testOneMovement() {
		LightsOutGame game = new LightsOutGame(5);
		game.oneMovement();
		assertTrue(game.getMovements() == 1);
	}
	
	@Test
	public void testOneMovementError() {
		LightsOutGame game = new LightsOutGame(5);
		game.oneMovement();
		assertFalse(game.getMovements() == 2);
	}
}
