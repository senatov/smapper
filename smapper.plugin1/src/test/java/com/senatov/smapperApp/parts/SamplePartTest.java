/*
 * JDK: ver. 1.8_51
 * @author Iakov
 * DATE: Aug 12, 2015 11:42:41 PM 2015
 * PRJ: com.senatov.smapperApp
 * PACKAGE: com.senatov.smapperApp.parts
 * FILE: SamplePartTest.java
 */
package com.senatov.smapperApp.parts;



import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * The Class SamplePartTest.
 */
public class SamplePartTest {

	@Inject
	private static org.eclipse.e4.core.services.log.Logger LOG;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// merely a placeholder
		LOG.debug("setUpBeforeClass ()");
	}


	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// merely a placeholder
		LOG.debug(" tearDownAfterClass  ()");
	}


	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		// merely a placeholder
		LOG.debug(" setUp ()");
	}


	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		// merely a placeholder
		LOG.debug("tearDown()");
	}


	/**
	 * Test create composite.
	 */
	@Test
	public void testCreateComposite() {
		// merely a placeholder
		LOG.debug("testCreateComposite()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test set focus.
	 */
	@Test
	public void testSetFocus() {
		// merely a placeholder
		LOG.debug(" testCreateComposite()");
		assertTrue("Not yet implemented", true);
	}

}
