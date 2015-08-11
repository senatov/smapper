/*
 * JDK: ver. 1.8_51
 * @author Iakov
 * DATE: 11.08.2015 11:57:02 2015 
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



// TODO: Auto-generated Javadoc
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
		LOG.debug("setUpBeforeClass ()");
	}


	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LOG.debug("  ()");
	}


	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.debug("  ()");
	}


	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		LOG.debug("  ()");
	}


	/**
	 * Test activator.
	 */
	@Test
	public void testActivator() {
		LOG.debug("  ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test start bundle context.
	 */
	@Test
	public void testStartBundleContext() {
		LOG.debug("  ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test stop bundle context.
	 */
	@Test
	public void testStopBundleContext() {
		LOG.debug("  ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test get default.
	 */
	@Test
	public void testGetDefault() {
		LOG.debug("  ()");
		assertTrue("Not yet implemented", true);
	}


	/**
	 * Test get image descriptor.
	 */
	@Test
	public void testGetImageDescriptor() {
		LOG.debug("  ()");
		assertTrue("Not yet implemented", true);
	}

}
