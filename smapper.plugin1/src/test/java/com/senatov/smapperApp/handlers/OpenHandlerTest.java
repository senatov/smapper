/*
 * JDK: ver. 1.8_51
 * @author Iakov
 * DATE: 11.08.2015 11:56:40 2015
 * PRJ: com.senatov.smapperApp
 * PACKAGE: com.senatov.smapperApp.handlers
 * FILE: OpenHandlerTest.java
 */
package com.senatov.smapperApp.handlers;



import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * The Class OpenHandlerTest.
 */
public class OpenHandlerTest {

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


	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		// merely a placeholder
		assertTrue("Not yet implemented", true);
	}

}
