/*
 * JDK: ver. 1.8_51
 * @author Iakov
 * DATE: 11.08.2015 11:56:33 2015
 * PRJ: com.senatov.smapperApp
 * PACKAGE: com.senatov.smapperApp.handlers
 * FILE: SaveHandlerTest.java
 */
package com.senatov.smapperApp.handlers;



import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class SaveHandlerTest {

	@Inject
	private static org.eclipse.e4.core.services.log.Logger LOG;


	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug(" setUpBeforeClass() ");
		assertTrue("Not yet implemented", true);
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}


	@Before
	public void setUp() throws Exception {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}


	@After
	public void tearDown() throws Exception {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}


	@Test
	public void testCanExecute() {
		assertTrue("Not yet implemented", true);
	}


	@Test
	public void testExecuteShell() {
		assertTrue("Not yet implemented", true);
	}


	@Test
	public void testExecuteIEclipseContextShellMContribution() {
		assertTrue("Not yet implemented", true);
	}

}
