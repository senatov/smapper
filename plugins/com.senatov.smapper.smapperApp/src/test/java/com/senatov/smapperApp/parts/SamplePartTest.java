package com.senatov.smapperApp.parts;



import static org.junit.Assert.assertTrue;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class SamplePartTest {
	private static final Logger LOG = Logger.getLogger(SamplePartTest.class);


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug("   ()");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		LOG.debug("   ()");
	}


	@Before
	public void setUp() throws Exception {
		LOG.debug("   ()");
	}


	@After
	public void tearDown() throws Exception {
		LOG.debug("   ()");
	}


	@Test
	public void testCreateComposite() {
		LOG.debug("   ()");
		assertTrue("Not yet implemented", true);
	}


	@Test
	public void testSetFocus() {
		LOG.debug("   ()");
		assertTrue("Not yet implemented", true);
	}

}
