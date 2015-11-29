/*
 * JDK: ver. 1.8_51
 * @author Iakov
 * DATE: Aug 12, 2015 11:36:00 PM 2015 
 * PRJ: com.senatov.smapperApp
 * PACKAGE: com.senatov.smapperApp
 * FILE: ActivatorTest.java
 */
package com.senatov.smapperApp;



import static org.junit.Assert.assertTrue;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * The Class ActivatorTest.
 */
public class ActivatorTest {

	private static final Logger LOG = Logger.getLogger(ActivatorTest.class);


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
		assertTrue(true);
		LOG.debug("  ()");
	}


	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		// merely a placeholder
		assertTrue(true);
		LOG.debug("setUp ()");
	}


	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		// merely a placeholder
		assertTrue(true);
		LOG.debug("tearDown ()");
	}


	/**
	 * Test activator.
	 */
	@Test
	public void testActivator() {
		// merely a placeholder
		LOG.debug(" testActivator ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test start bundle context.
	 */
	@Test
	public void testStartBundleContext() {
		// merely a placeholder
		LOG.debug("testStartBundleContext ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test stop bundle context.
	 */
	@Test
	public void testStopBundleContext() {
		// merely a placeholder
		LOG.debug(" testStopBundleContext ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test get default.
	 */
	@Test
	public void testGetDefault() {
		// merely a placeholder
		LOG.debug(" testGetDefault()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test get image descriptor.
	 */
	@Test
	public void testGetImageDescriptor() {
		// merely a placeholder
		LOG.debug(" testGetImageDescriptor()");
		assertTrue("Not yet implemented", true);
	}

}
